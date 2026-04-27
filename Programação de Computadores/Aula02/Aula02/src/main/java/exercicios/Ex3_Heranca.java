class Ex3_Heranca {
    static class Pessoa {
        String nome;
        int idade;
    }

    static class Funcionario extends Pessoa {
        double salario;
    }

    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        f.nome = "Carlos";
        f.idade = 30;
        f.salario = 5000;
        System.out.println(f.nome);
    }
}