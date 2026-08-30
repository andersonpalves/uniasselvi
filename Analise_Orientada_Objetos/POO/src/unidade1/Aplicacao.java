package unidade1;

import unidade1.modelos.Pessoa;
import unidade1.modelos.PessoaFisica;
import unidade1.modelos.PessoaJuridica;

public class Aplicacao {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Anderson");
        pf.setIdade(38);
        pf.setEmail("anderson@uniasselvi.com");
        pf.setCpf("01234");

        System.out.println("Nome: " + pf.getNome());
        System.out.println("Idade: " + pf.getIdade());
        System.out.println("Email: " + pf.getEmail());
        System.out.println("CPF: " + pf.getCpf());

        pf.andar();
        pf.pular();

        PessoaJuridica pj1 = new PessoaJuridica();
        pj1.setCnpj("98765");
        pj1.setNome("Uniasselvi");
        pj1.setIdade(15);
        pj1.setEmail("empresa@uniasselvi.com.br1");

        System.out.println("Nome: " + pj1.getNome());
        System.out.println("Idade: " + pj1.getIdade());
        System.out.println("Email: " + pj1.getEmail());
        System.out.println("CPNJ: " + pj1.getCnpj());

    }
}
