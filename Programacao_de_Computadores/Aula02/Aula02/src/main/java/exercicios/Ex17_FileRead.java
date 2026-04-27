package exercicios;

import java.io.*;
class Ex17_FileRead {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("teste.txt");
        int i;
        while((i = fis.read()) != -1){
            System.out.print((char)i);
        }
        fis.close();
    }
}