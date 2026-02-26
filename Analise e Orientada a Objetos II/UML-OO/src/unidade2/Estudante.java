package unidade2;

class Estudante extends Pessoa {
    private String curso;

    public Estudante(String nome, int idade, String curso) {
        super(nome, idade);
        this.curso = curso;
    }

    public void estudar() {
        System.out.println(getNome() + " está estudando " + curso);
    }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}