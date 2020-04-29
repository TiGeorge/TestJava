package io;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        try {
            boolean newFile = false;
            File file = new File("fileWrite1.txt");
            System.out.println(file.exists());
            newFile = file.createNewFile();
            System.out.println(newFile);
            System.out.println(file.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
