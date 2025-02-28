package org.example.week_3.grant_pdf;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFilter {

    public static void main(String[] args) throws IOException {
        run(); // Запуск кода
    }

    public static void run() throws IOException {

        // Путь к директорию где расположен файл с исходным результатом где уже из pdf преобразован к текст
        String pathToDirectory = "/home/bekarys/IdeaProjects/WorkWord/src/main/java/org/example/week_3/grant_pdf/";
        // Название файла
        String fileName = "green.txt";

        // Файл где уже есть данные из pdf в виде текст
        // И код преобразования pdf -> txt в файле Main
        File file = new File(pathToDirectory, fileName); //

        // Проверят есть ли файл с названием green.txt
        if (!file.exists()){
            System.out.println("File Not Found");
            System.exit(0);
        }else {
            // try-catch-resources чтение файла
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)){

                // паттерн разделтель по дисциплину
                Pattern pattern = Pattern.compile("^[B6][B\\d]\\d{2} - [\\p{L}, ]+$");

                // Ключ-значение ---> ID дисциплина-ее расшифрока  (B001-Психология)
                Map<String, String> disciplines = new HashMap<>();

                // Ключ-значение ID дисциплина-данные или резултаты
                Map<String, String> data = new HashMap<>();
                String id_dis = ""; //  уникальный id дисциплина

                String line; // Чтение строку в файле

                // Чтение из файла пока не дойти до конца
                while (!((line = br.readLine()) == null)){

                    // Если строка пустой (не null) то просто пропустит
                    if (line.isEmpty()){
                        continue;
                    }

                    // Проверка строку по шаблону или регулярному выражений
                    Matcher matcher = pattern.matcher(line);

                    // Проверка есть ли текст которой подходить к шаблону
                    if (matcher.matches()){

                        // Пример строку которой подходит
                        // --- B001 - Педагогика және психология ---
                        // Если такой есть то разделить на две части
                        String[] split = line.strip().split(" - ");

                        // Добавить в отдельный хранение ключ-значение
                        disciplines.put(split[0], split[1]);

                        // Обновление дисциплина (Уникальный номер)
                        id_dis = split[0];

                        // Пропуск
                        continue;
                    }
                    // Добавляет строку в значение по ключу дисциплина
                    if (!id_dis.isEmpty()){
                        data.put(id_dis, data.getOrDefault(id_dis, "") + (data.containsKey(id_dis) ? " " : "") + line.strip());
                    }
                }
                System.out.println(disciplines.size() == data.size());
                System.out.println(data.get("B001"));
            }

        }
    }

}
