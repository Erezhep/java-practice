package org.example.week_5.P;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        run();
    }

    public static void run() throws SQLException, IOException {
        // WorkWithMySQL.createTable();
        // WorkWithMySQL.readTable();
        boolean b = WorkWithMySQL.deleteTable(9);
        if (b){
            System.out.println("Пользователь успешно удален из таблиц!");
        }else{
            System.out.println("Такой пользователь нет!");
        }

        boolean a = WorkWithMySQL.updateTable(1, "Bekarys", 20);
        if (a){
            System.out.println("Успешно обновлен!");
        }else{
            System.out.println("Какой то ошибка или такой пользователь нет!");
        }
    }
}
