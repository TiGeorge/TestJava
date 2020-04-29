package io;

import java.io.*;

public class Writer3 {
    public static void main(String[] args) {
        byte[] in = new byte[50];
        int size = 0;

        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        File file = new File("fileWrite3.txt");
        try {
            fileOutputStream = new FileOutputStream(file);
            String s = "lkj\n;lkjlkjkj\n";
            fileOutputStream.write(s.getBytes("UTF-8"));
            fileOutputStream.flush();
            fileOutputStream.close();

            fileInputStream = new FileInputStream(file);
            size = fileInputStream.read(in);
            System.out.print(size + " ");
            for (byte b : in) {
                System.out.print((char) b);
            }
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}