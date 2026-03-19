package exemplo;

public class Aplicacao {
    public static void main(String[] args) {
//        Pessoa p1 = new Pessoa();
//        p1.setAltura(1.87f);
//        p1.setPeso(60);
//        p1.setEmail("andersonpalves@gmail.com");
//        p1.setIdade(37);
//        p1.setNome("Anderson");
//
//        System.out.println("Nome: " + p1.getNome());
//        System.out.println("Altura: " + p1.getAltura());
//        System.out.println("Idade: " + p1.getIdade());
//        System.out.println("Peso: " + p1.getPeso());
//        System.out.println("Email: " + p1.getEmail());
//        p1.falar("Boa noite :)");
//        p1.correr("Boa noite :)");
//        p1.andar("Boa noite :)");
//        System.out.println();

        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj("012345678911121314");
        pj.falar("Boa noite :)");
        pj.setNome("Empresa XPTO");

        PessoaFisica pf = new PessoaFisica();
        pf.setCpf("01234567891011");
        pf.setNome("João");

        System.out.println("CNPJ " + pj.getCnpj() +" - Nome: " + pj.getNome());
        System.out.println("CPF " + pf.getCpf()+" - Nome: " + pf.getNome());
    }
}
