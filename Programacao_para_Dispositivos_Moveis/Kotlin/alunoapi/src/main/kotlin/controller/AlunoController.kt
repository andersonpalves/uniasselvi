package com.exemplo.alunoapi.controller

import com.exemplo.alunoapi.entity.Aluno
import com.exemplo.alunoapi.service.AlunoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alunos")
class AlunoController(private val service: AlunoService) {

    @GetMapping
    fun listar(): ResponseEntity<List<Aluno>> =
        ResponseEntity.ok(service.listarTodos())

    @GetMapping("/{id}")
    fun buscar(@PathVariable id: Long): ResponseEntity<Aluno> =
        ResponseEntity.ok(service.buscarPorId(id))

    @PostMapping
    fun criar(@Valid @RequestBody aluno: Aluno): ResponseEntity<Aluno> {
        val novoAluno = service.salvar(aluno)
        return ResponseEntity.status(201).body(novoAluno)
    }

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable id: Long,
        @Valid @RequestBody aluno: Aluno
    ): ResponseEntity<Aluno> =
        ResponseEntity.ok(service.atualizar(id, aluno))

    @PatchMapping("/{id}")
    fun atualizarParcial(
        @PathVariable id: Long,
        @RequestBody dados: Map<String, String>
    ): ResponseEntity<Aluno> {
        val aluno = service.atualizarParcial(
            id,
            dados["nome"],
            dados["email"]
        )
        return ResponseEntity.ok(aluno)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        service.deletar(id)
        return ResponseEntity.noContent().build()
    }
}