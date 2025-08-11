package _07StreamsFilesDir;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class _01ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\AStoyanoff\\ADVANCED\\ADVANCED\\src\\_07StreamsFilesDir\\input.txt";
        InputStream iss = new FileInputStream(path);

        int curr = iss.read();
        while (curr >= 0) {

            System.out.print(Integer.toBinaryString(curr) + " ");
            curr = iss.read();
        }
        iss.close();
    }
}
