package unidade2

// =============================
// ABSTRAÇÃO
// =============================
abstract class Produto(
    private val id: Int,
    private var nome: String,
    protected var preco: Double
) {

    fun getId() = id
    fun getNome() = nome
    fun setNome(novoNome: String) { nome = novoNome }

    abstract fun calcularPrecoFinal(): Double

    open fun exibirDetalhes() {
        println("ID: $id | Nome: $nome | Preço Base: R$ $preco")
    }
}

// =============================
// HERANÇA + POLIMORFISMO
// =============================
class ProdutoFisico(
    id: Int,
    nome: String,
    preco: Double,
    private val peso: Double
) : Produto(id, nome, preco) {

    override fun calcularPrecoFinal(): Double {
        return preco + (peso * 2) // frete
    }

    override fun exibirDetalhes() {
        super.exibirDetalhes()
        println("Tipo: Físico | Peso: $peso kg | Preço Final: R$ ${calcularPrecoFinal()}")
    }
}

class ProdutoDigital(
    id: Int,
    nome: String,
    preco: Double
) : Produto(id, nome, preco) {

    override fun calcularPrecoFinal(): Double {
        return preco * 0.9 // desconto digital
    }

    override fun exibirDetalhes() {
        super.exibirDetalhes()
        println("Tipo: Digital | Preço Final: R$ ${calcularPrecoFinal()}")
    }
}

// =============================
// CRUD EM MEMÓRIA
// =============================
class ProdutoService {

    private val produtos = mutableListOf<Produto>()

    fun criar(produto: Produto) {
        produtos.add(produto)
        println("Produto cadastrado com sucesso!")
    }

    fun listar() {
        println("\n--- LISTA DE PRODUTOS ---")
        produtos.forEach { it.exibirDetalhes() } // POLIMORFISMO
    }

    fun buscarPorId(id: Int): Produto? {
        return produtos.find { it.getId() == id }
    }

    fun atualizarNome(id: Int, novoNome: String) {
        val produto = buscarPorId(id)
        produto?.setNome(novoNome)
        println("Produto atualizado!")
    }

    fun deletar(id: Int) {
        produtos.removeIf { it.getId() == id }
        println("Produto removido!")
    }
}

// =============================
// MAIN
// =============================
fun main() {
    val service = ProdutoService()
    var opcao: Int

    do {
        println(
            """
            =============================
            MENU DE PRODUTOS
            =============================
            1 - Cadastrar Produto Físico
            2 - Cadastrar Produto Digital
            3 - Listar Produtos
            4 - Atualizar Nome
            5 - Deletar Produto
            0 - Sair
            =============================
            Escolha uma opção:
            """.trimIndent()
        )

        opcao = readLine()?.toIntOrNull() ?: -1

        when (opcao) {
            1 -> {
                println("Digite ID:")
                val id = readLine()?.toIntOrNull() ?: 0
                println("Digite Nome:")
                val nome = readLine() ?: ""
                println("Digite Preço:")
                val preco = readLine()?.toDoubleOrNull() ?: 0.0
                println("Digite Peso:")
                val peso = readLine()?.toDoubleOrNull() ?: 0.0

                val produto = ProdutoFisico(id, nome, preco, peso)
                service.criar(produto)
            }
            2 -> {
                println("Digite ID:")
                val id = readLine()?.toIntOrNull() ?: 0
                println("Digite Nome:")
                val nome = readLine() ?: ""
                println("Digite Preço:")
                val preco = readLine()?.toDoubleOrNull() ?: 0.0

                val produto = ProdutoDigital(id, nome, preco)
                service.criar(produto)
            }
            3 -> service.listar()
            4 -> {
                println("Digite ID do produto a atualizar:")
                val id = readLine()?.toIntOrNull() ?: 0
                println("Digite novo nome:")
                val novoNome = readLine() ?: ""
                service.atualizarNome(id, novoNome)
            }
            5 -> {
                println("Digite ID do produto a deletar:")
                val id = readLine()?.toIntOrNull() ?: 0
                service.deletar(id)
            }
            0 -> println("Saindo...")
            else -> println("Opção inválida!")
        }

    } while (opcao != 0)
}