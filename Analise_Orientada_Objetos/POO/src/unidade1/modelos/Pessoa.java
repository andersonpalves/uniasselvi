package unidade1.modelos;

public class Pessoa {
    private String nome;
    private Integer idade;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void andar(){
        System.out.println("Estou andando");
    }

    public void pular(){
        System.out.println("Estou pulando");
    }
}
