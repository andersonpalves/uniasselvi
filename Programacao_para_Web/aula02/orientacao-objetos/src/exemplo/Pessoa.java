package exemplo;

public class Pessoa {

    private String nome;
    private float altura;
    private int peso;
    private String email;
    private Integer idade;

    Pessoa () {
        System.out.println("Passei pelo construtor Pessoa");
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void falar(String mensagem) {
        System.out.println("Falar " + mensagem);
    }

    public void correr(String mensagem) {
        System.out.println("Correr " + mensagem);
    }

    public void andar(String mensagem) {
        System.out.println("Andar " + mensagem);
    }

}
