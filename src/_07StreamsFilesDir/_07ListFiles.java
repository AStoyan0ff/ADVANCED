package _07StreamsFilesDir;

import java.io.File;

public class _07ListFiles {
    public static void main(String[] args) {

        File dir = new File("C:\\AStoyanoff\\ADVANCED\\ADVANCED\\src\\_07StreamsFilesDir");

        if (dir.exists()) {

            if (dir.isDirectory()) {
                File [] files = dir.listFiles();

                for (File file : files) {

                    if(!file.isDirectory()) {

                        System.out.printf("%s: [%s]\n",
                                file.getName(),
                                file.length());
                    }
                }
            }
        }
    }
}
