package unidade2

open class Animal {
    open fun emitirSom() {
        println("Som genérico")
    }
}

class Cachorro : Animal() {
    override fun emitirSom() {
        println("Au au")
    }
}

class Gato : Animal() {
    override fun emitirSom() {
        println("Miau")
    }
}

fun main() {
    val cachorro = Cachorro()
    val gato = Gato()

    cachorro.emitirSom()   // imprime "Au au"
    gato.emitirSom()       // imprime "Miau"

    // também dá pra usar polimorfismo:
    val animais: List<Animal> = listOf(cachorro, gato)
    for (animal in animais) {
        animal.emitirSom()
    }
}
