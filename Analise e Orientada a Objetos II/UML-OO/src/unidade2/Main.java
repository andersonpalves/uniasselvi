package unidade2;

public class Main {
    public static void main(String[] args) {
        Estudante aluno1 = new Estudante("João", 20, "Engenharia");
        Professor professor1 = new Professor("Maria", 40, "Matemática");

        aluno1.exibirInfo();
        aluno1.estudar();

        professor1.exibirInfo();
        professor1.ensinar();
    }
}