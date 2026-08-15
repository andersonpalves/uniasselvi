package unidade1.modelos;

public class Medico {
    private String nome;
    private String especialidade;

    public Medico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public void realizarConsulta() {
        System.out.println(nome + " está realizando uma consulta de " + especialidade);
    }
}
