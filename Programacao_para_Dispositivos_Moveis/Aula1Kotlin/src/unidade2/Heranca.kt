package unidade2

open class Funcionario(val nome: String, val salario: Double) {
    open fun calcularBonus(): Double {
        return 0.0
    }
}

class Gerente(nome: String, salario: Double) : Funcionario(nome, salario) {
    override fun calcularBonus(): Double {
        return salario * 0.20
    }
}

class Desenvolvedor(nome: String, salario: Double) : Funcionario(nome, salario) {
    override fun calcularBonus(): Double {
        return salario * 0.10
    }
}

fun main() {
    val gerente = Gerente("Maria", 5000.0)
    val desenvolvedor = Desenvolvedor("João", 4000.0)

    println("Gerente: ${gerente.nome}, bônus: ${gerente.calcularBonus()}")
    println("Desenvolvedor: ${desenvolvedor.nome}, bônus: ${desenvolvedor.calcularBonus()}")
}