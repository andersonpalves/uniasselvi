import java.io.*;
class Ex16_FileWrite {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("teste.txt");
        fos.write("Olá".getBytes());
        fos.close();
    }
}