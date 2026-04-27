import java.io.*;
class Ex15_File {
    public static void main(String[] args) throws Exception {
        File f = new File("teste.txt");
        f.createNewFile();
    }
}