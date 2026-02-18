package unidade1

fun main() {
    // Lista (permite elementos repetidos)
    val lista = mutableListOf("Kotlin", "Java", "Python")
    lista.add("Go")
    println("Lista: $lista")

    // Conjunto (não permite elementos repetidos)
    val conjunto = mutableSetOf(1, 2, 2, 3, 4)
    println("Conjunto: $conjunto") // saída: [1, 2, 3, 4]

    // Mapa (chave -> valor)
    val mapa = mutableMapOf("BR" to "Brasil", "US" to "Estados Unidos")
    mapa["FR"] = "França"
    println("Mapa: $mapa")
}