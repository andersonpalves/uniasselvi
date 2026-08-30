package unidade3;

// Domínio: Produto que será construído
public class ExemploBuilder {
    private final String nome;
    private final double preco;
    private final String categoria;

    // Construtor privado: só o Builder pode chamar
    private ExemploBuilder(Builder builder) {
        this.nome = builder.nome;
        this.preco = builder.preco;
        this.categoria = builder.categoria;
    }

    // Métodos de domínio (comportamento do objeto final)
    public void mostrarInfo() {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Categoria: " + categoria);
    }

    // Domínio: Builder responsável pela construção
    public static class Builder {
        private String nome;
        private double preco;
        private String categoria;

        // Métodos de configuração (domínio do Builder)
        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setPreco(double preco) {
            if (preco < 0) {
                throw new IllegalArgumentException("Preço não pode ser negativo!");
            }
            this.preco = preco;
            return this;
        }

        public Builder setCategoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        // Método que finaliza a construção (domínio do Builder)
        public ExemploBuilder build() {
            return new ExemploBuilder(this);
        }
    }

    // Teste no main
    public static void main(String[] args) {
        ExemploBuilder celular = new ExemploBuilder.Builder()
                .setNome("Smartphone X")
                .setPreco(1999.99)
                .setCategoria("Eletrônicos")
                .build();

        celular.mostrarInfo();

        ExemploBuilder livro = new ExemploBuilder.Builder()
                .setNome("Clean Code")
                .setPreco(89.90)
                .setCategoria("Livros")
                .build();

        livro.mostrarInfo();
    }
}

