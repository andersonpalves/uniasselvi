package com.exemplo.alunoapi.repository

import com.exemplo.alunoapi.entity.Aluno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlunoRepository : JpaRepository<Aluno, Long>