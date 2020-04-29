package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer2 {
    public static void main(String[] args) {
        char[] in = new char[50];
        int size = 0;

        try {
            File file = new File("fileWrite2.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(";kl\njlkj\\j;lkj");
            fileWriter.flush();
            fileWriter.close();

            FileReader fileReader = new FileReader(file);
            size = fileReader.read(in);
            System.out.println(size + " ");
            for (char c : in) {
                System.out.print(c);
            }
            fileReader.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
