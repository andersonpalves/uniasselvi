package exemplo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ArquivoExemplo {
    public static void main(String[] args) {
        // Caminho do arquivo
        File arquivo = new File("exemplo.txt");

        // Escrita no arquivo
        try (FileOutputStream fos = new FileOutputStream(arquivo)) {
            String texto = "Olá, Ânderson! Este é um exemplo de escrita.";
            fos.write(texto.getBytes());
            fos.close();
            System.out.println("Arquivo escrito com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever: " + e.getMessage());
        }

        // Leitura do arquivo
        try (FileInputStream fis = new FileInputStream(arquivo)) {
            int dado;
            System.out.print("Conteúdo do arquivo: ");
            while ((dado = fis.read()) != -1) {
                System.out.print((char) dado);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler: " + e.getMessage());
        }
    }
}
