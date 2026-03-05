package com.exemplo.alunoapi.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "aluno")
data class Aluno(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    val idAluno: Long? = null,

    @field:NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    var nome: String,

    @field:Email(message = "Email inválido")
    @field:NotBlank(message = "Email é obrigatório")
    @Column(nullable = false, unique = true)
    var email: String
)