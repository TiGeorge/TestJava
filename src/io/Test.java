package io;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.print("Enter Characters: ");
        // declare the BufferedReader Class
        // used the InputStreamReader to read the console input

        // catch the possible IOException by the read() method
        try {
            BufferedReader reader = new BufferedReader(new StringReader("123456789"));

            System.out.println((char)reader.read());
            System.out.println((char)reader.read());
            System.out.println((char)reader.read());
            reader.mark(1);
            System.out.println("Printing characters after mark");
            System.out.println((char)reader.read());
            System.out.println((char)reader.read());
            System.out.println((char)reader.read());
            reader.reset();
            System.out.println("Printing characters after reset");
            System.out.println((char)reader.read());
            System.out.println((char)reader.read());
            System.out.println((char)reader.read());
            // close the BufferedReader object
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
