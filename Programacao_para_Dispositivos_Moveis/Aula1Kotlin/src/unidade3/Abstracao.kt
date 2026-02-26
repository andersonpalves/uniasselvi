package unidade2

abstract class Forma {
    abstract fun calcularArea(): Double
}

class Retangulo(val base: Double, val altura: Double) : Forma() {
    override fun calcularArea(): Double {
        return base * altura
    }
}

class Circulo(val raio: Double) : Forma() {
    override fun calcularArea(): Double {
        return Math.PI * raio * raio
    }
}

fun main() {
    val retangulo = Retangulo(5.0, 3.0)
    val circulo = Circulo(2.0)

    println("Área do retângulo: ${retangulo.calcularArea()}")
    println("Área do círculo: ${circulo.calcularArea()}")

    // Usando polimorfismo
    val formas: List<Forma> = listOf(retangulo, circulo)
    for (forma in formas) {
        println("Área calculada: ${forma.calcularArea()}")
    }
}
