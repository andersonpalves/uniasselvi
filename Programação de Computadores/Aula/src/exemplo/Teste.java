package exemplo;

class Pai {
    static String tipo = "Pai";
}

class Filho extends Pai {
    static String tipoFilho = "Filho";
}

public class Teste {
    public static void main(String[] args) {
        Pai referenciaPai = new Filho();
        System.out.println(referenciaPai.tipo); // Saída: "Pai"
        System.out.println(Filho.tipo);         // Saída: "Filho"
    }
}

