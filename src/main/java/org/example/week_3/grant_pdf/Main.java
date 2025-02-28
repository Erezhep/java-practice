package org.example.week_3.grant_pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "/home/bekarys/IdeaProjects/WorkWord/src/main/java/org/example/week_3/grant_pdf/grant_list_2022.pdf";
        File file = new File(filePath);

        try (PDDocument pdf = PDDocument.load(file)){
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(pdf);

            try (FileWriter f = new FileWriter(new File("/home/bekarys/IdeaProjects/WorkWord/src/main/java/org/example/week_3/grant_pdf/green.txt"))){
                f.write(text);
            }
            System.out.println("All Done!");

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
