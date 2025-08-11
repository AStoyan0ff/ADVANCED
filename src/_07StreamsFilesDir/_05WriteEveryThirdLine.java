package _07StreamsFilesDir;
import java.io.*;
import java.util.Scanner;

public class _05WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {

        String inputText = "C:\\AStoyanoff\\ADVANCED\\ADVANCED\\src\\_07StreamsFilesDir\\input.txt";

        InputStream iStr = new FileInputStream(inputText);
        Scanner in = new Scanner(iStr);

        String outputText = "C:\\AStoyanoff\\ADVANCED\\ADVANCED\\src\\_07StreamsFilesDir\\WriteEveryThirdLineOutput.txt";

        OutputStream oStr = new FileOutputStream(outputText);
        PrintWriter out = new PrintWriter(oStr);

        int cnt = 1;
        String line = in.nextLine();

        while (in.hasNextLine()) {

            if (cnt % 3 == 0) {
                out.println(line);
            }
            cnt++;
            line = in.nextLine();
        }
        in.close();
        out.close();
    }
}
