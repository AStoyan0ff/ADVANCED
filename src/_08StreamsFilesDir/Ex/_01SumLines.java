package _08StreamsFilesDir.Ex;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class _01SumLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filePath = "C:\\AStoyanoff\\ADVANCED\\ADVANCED\\src\\_08StreamsFilesDir\\Ex\\input.txt";
        Path path = Paths.get(filePath);

        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = buffer.readLine()) != null) {
                int result = 0;

                for (char c : line.toCharArray()) {
                    result += c;
                }
                System.out.println(result);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
