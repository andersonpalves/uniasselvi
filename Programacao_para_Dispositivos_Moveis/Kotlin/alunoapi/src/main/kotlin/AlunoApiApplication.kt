package com.exemplo.alunoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AlunoApiApplication

fun main(args: Array<String>) {
    runApplication<AlunoApiApplication>(*args)
}