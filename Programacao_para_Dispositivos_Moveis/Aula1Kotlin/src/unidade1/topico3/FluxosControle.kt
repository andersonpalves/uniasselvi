package unidade1.topico3

fun main() {
    // -------------------------------
    // IF / ELSE
    // -------------------------------
    val idade = 18
    if (idade >= 18) {
        println("Você é maior de idade")
    } else {
        println("Você é menor de idade")
    }

    // -------------------------------
    // WHEN (switch mais poderoso)
    // -------------------------------
    val dia = 3
    when (dia) {
        1 -> println("Segunda-feira")
        2 -> println("Terça-feira")
        3 -> println("Quarta-feira")
        4 -> println("Quinta-feira")
        5 -> println("Sexta-feira")
        6, 7 -> println("Fim de semana")
        else -> println("Dia inválido")
    }

    // -------------------------------
    // Laços de Repetição
    // -------------------------------
    // For
    for (i in 1..5) {
        println("For: número $i")
    }

    // While
    var contador = 0
    while (contador < 3) {
        println("While: contador = $contador")
        contador++
    }

    // Do-While
    var x = 0
    do {
        println("Do-While: x = $x")
        x++
    } while (x < 2)

    // -------------------------------
    // Funções
    // -------------------------------
    fun soma(a: Int, b: Int): Int {
        return a + b
    }

    fun saudacao(nome: String) = "Olá, $nome!"

    println("Soma: ${soma(5, 7)}")
    println(saudacao("Ânderson"))

    // -------------------------------
    // Operador Ternário (simulação)
    // -------------------------------
    val numero = 10
    val resultado = if (numero % 2 == 0) "Par" else "Ímpar"
    println("Número $numero é $resultado")
}