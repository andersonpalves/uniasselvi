package exemplo;

public class PessoaFisica extends Pessoa {

    private String cpf;

    PessoaFisica() {
        System.out.println("Passei pelo construtor Pessoa Fisica");
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
