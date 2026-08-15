package unidade1;

import unidade1.modelos.Medico;

public class Exemplo01_Medico {
    public static void main(String[] args) {
        Medico m1 = new Medico("Dra. Ana", "Pediatria");
        m1.realizarConsulta();
    }
}
