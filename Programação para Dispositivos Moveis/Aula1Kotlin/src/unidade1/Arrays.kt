package unidade1

fun main() {
    val numeros = arrayOf(1, 2, 3, 4, 5)
    val nomes = arrayOf("Ana", "Bruno", "Carlos")

    println("Primeiro número: ${numeros[0]}")
    println("Lista de nomes:")
    for (nome in nomes) {
        println(nome)
    }
}