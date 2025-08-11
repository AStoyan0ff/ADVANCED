package _07StreamsFilesDir;

import java.io.*;

public class _02WriteFile {
    public static void main(String[] args) throws IOException {

        String readFile = "C:\\AStoyanoff\\ADVANCED\\ADVANCED\\src\\_07StreamsFilesDir\\input.txt";
        String writeFile = "C:\\AStoyanoff\\ADVANCED\\ADVANCED\\src\\_07StreamsFilesDir\\WriteFile.txt";

        InputStream iStr = new FileInputStream(readFile);
        OutputStream oStr = new FileOutputStream(writeFile);

        int currByte = iStr.read();

        while(currByte >= 0){
            char currSymbol = (char)currByte;

            if (    currSymbol != '.' &&
                    currSymbol != ',' &&
                    currSymbol != '!' &&
                    currSymbol != '?'){

                oStr.write(currSymbol);
            }
            currByte = iStr.read();
        }
        iStr.close();
        oStr.close();
    }
}
