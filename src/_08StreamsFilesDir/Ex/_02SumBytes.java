package _08StreamsFilesDir.Ex;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _02SumBytes {
    public static void main(String[] args) {

        Path inputPath = Paths.get("C:\\AStoyanoff\\ADVANCED\\ADVANCED\\src\\_08StreamsFilesDir\\Ex\\input.txt");
        Path outputPath = Paths.get("output.txt");

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {

            String line;
            while ((line = reader.readLine()) != null) {

                writer.write(line.toUpperCase());
                writer.newLine();
            }

            System.out.println(line);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
