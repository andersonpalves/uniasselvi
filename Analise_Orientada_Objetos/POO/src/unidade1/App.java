package unidade1;

import unidade1.modelos.PessoaFisica;
import unidade1.modelos.PessoaJuridica;

public class App {
    public static void main(String[] args) {
        PessoaFisica objetoPessoaFisica = new PessoaFisica();
        objetoPessoaFisica.setNome("Daniel");
        objetoPessoaFisica.setIdade(18);
        objetoPessoaFisica.setEmail("daniel@uniasselvi.com.br");
        objetoPessoaFisica.setCpf(12345);

        System.out.println("Nome: " + objetoPessoaFisica.getNome());
        System.out.println("Idade: " + objetoPessoaFisica.getIdade());
        System.out.println("Email: " + objetoPessoaFisica.getEmail());
        System.out.println("CPF: " + objetoPessoaFisica.getCpf());
        String mensagem = objetoPessoaFisica.andar();


        PessoaJuridica objetoPessoaJuridica = new PessoaJuridica();
        objetoPessoaJuridica.setNome("Uniasselvi");
        objetoPessoaJuridica.setIdade(20);
        objetoPessoaJuridica.setEmail("uniasselvi@uniasselvi.com.br");
        objetoPessoaJuridica.setCnpj(98765);

        System.out.println("Nome PJ: " + objetoPessoaJuridica.getNome());
        System.out.println("Idade PJ: " + objetoPessoaJuridica.getIdade());
        System.out.println("Email PJ: " + objetoPessoaJuridica.getEmail());
        System.out.println("CNPJ: " + objetoPessoaJuridica.getCnpj());


    }
}
