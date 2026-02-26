package unidade2

class ContaBancaria(private var saldo: Double) {

    fun depositar(valor: Double) {
        if (valor > 0) saldo += valor
    }

    fun sacar(valor: Double) {
        if (valor <= saldo) saldo -= valor
    }

    fun consultarSaldo(): Double {
        return saldo
    }
}

fun main() {
    val conta = ContaBancaria(1000.0)

    conta.depositar(500.0)
    println("Saldo após depósito: ${conta.consultarSaldo()}")

    conta.sacar(200.0)
    println("Saldo após saque: ${conta.consultarSaldo()}")
}
