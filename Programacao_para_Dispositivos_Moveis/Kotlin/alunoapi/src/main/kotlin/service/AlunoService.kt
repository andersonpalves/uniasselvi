package com.exemplo.alunoapi.service

import com.exemplo.alunoapi.entity.Aluno
import com.exemplo.alunoapi.repository.AlunoRepository
import org.springframework.stereotype.Service

@Service
class AlunoService(private val repository: AlunoRepository) {

    fun listarTodos(): List<Aluno> = repository.findAll()

    fun buscarPorId(id: Long): Aluno =
        repository.findById(id).orElseThrow {
            RuntimeException("Aluno não encontrado")
        }

    fun salvar(aluno: Aluno): Aluno = repository.save(aluno)

    fun atualizar(id: Long, alunoAtualizado: Aluno): Aluno {
        val aluno = buscarPorId(id)
        aluno.nome = alunoAtualizado.nome
        aluno.email = alunoAtualizado.email
        return repository.save(aluno)
    }

    fun atualizarParcial(id: Long, nome: String?, email: String?): Aluno {
        val aluno = buscarPorId(id)
        nome?.let { aluno.nome = it }
        email?.let { aluno.email = it }
        return repository.save(aluno)
    }

    fun deletar(id: Long) {
        val aluno = buscarPorId(id)
        repository.delete(aluno)
    }
}