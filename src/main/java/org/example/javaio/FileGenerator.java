package org.example.javaio;

import java.io.*;
import java.util.Scanner;

public class FileGenerator {
    public static void main(String[] args) throws IOException {
        // Create Directory
        File dir = new File("/home/bekarys/test");
        boolean ismkdir = dir.mkdir();
        System.out.println((ismkdir) ? "Каталог создан!" : "Каталог не создан");

        // Create files is directory
        for (int i = 0; i < 5; i++) {
            File file = new File(dir, "text_" + i + ".txt");
            boolean newFile = file.createNewFile();
            System.out.println((newFile) ? "Файл создан" : "Так что то не так");

            try (FileOutputStream os = new FileOutputStream(file)){
                os.write(("Java " + (i + 1)).getBytes());
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

        // Read files
        for (File f : dir.listFiles()){
            try (FileReader fr = new FileReader(f);
            Scanner sc = new Scanner(fr)){
                while (sc.hasNext()){
                    if (sc.nextLine().equals("Java 3")){
                        System.out.println("Я нашел файл с надписью Java 8: " + f.getName());
                    }
                }
            }
        }

        // Info about directory
        File[] files = dir.listFiles();
        assert files != null;
        for (File f: files){
            System.out.println(f);
        }
    }
}
