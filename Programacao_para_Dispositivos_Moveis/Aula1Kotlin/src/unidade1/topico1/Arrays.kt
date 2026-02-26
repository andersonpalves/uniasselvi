package unidade1.topico1

fun main() {
    var numeros = arrayOf(1, 2, 3, 4, 5)
    val nomes = arrayOf("Ana", "Bruno", "Carlos")

    println("Primeiro número: ${numeros[0]}")
    println("Ultimo número: ${numeros[4]}")

    println("Lista de nomes:")
    for (nome in nomes) {
        println(nome)
    }
}