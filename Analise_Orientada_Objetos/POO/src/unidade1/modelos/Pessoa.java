package unidade1.modelos;

public class Pessoa {

    private String nome;
    private int idade;
    private String email;

    public String andar(){
        return  "Olá, estou andando";
    }

    public void mensagemBoasVindas(){
        System.out.println("Olá humano");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
