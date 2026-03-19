package exemplo;

public class PessoaJuridica extends Pessoa {

    private String cnpj;

    PessoaJuridica () {
        System.out.println("Passei pelo construtor Pessoa Juridica");
        super();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
