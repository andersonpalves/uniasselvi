package unidade1;

class Autor {
    String nome;

    public Autor(String nome) {
        this.nome = nome;
    }
}

class Livro {
    String titulo;
    Autor autor;

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void exibirInfo() {
        System.out.println(titulo + " escrito por " + autor.nome);
    }
}

public class Exemplo04_AutorLivro {
    public static void main(String[] args) {
        Autor autor = new Autor("Machado de Assis");
        Livro livro = new Livro("Dom Casmurro", autor);
        livro.exibirInfo();
    }
}

