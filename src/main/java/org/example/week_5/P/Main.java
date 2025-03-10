package org.example.week_5.P;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        run();
    }

    public static void run() throws SQLException, IOException {
         Scanner sc = new Scanner(System.in);
         while (true){
             printMenu();
             int n = sc.nextInt();
             switch (n) {
                 case 1:
                     WorkWithMySQL.createTable();
                     break;
                 case 2:
                     WorkWithMySQL.readTable();
                     break;
                 case 3:
                     System.out.print("Введите id для удаление: ");
                     int id = sc.nextInt();
                     boolean res = WorkWithMySQL.deleteUser(id);
                     System.out.println((res) ? "Пользователь удален" : "Проверьте есть ли такой пользователь для удаление");
                     break;
                 case 4:
                     System.out.print("Введите id: ");
                     int ID = sc.nextInt();
                     System.out.print("Введите name: ");
                     String name = sc.next();
                     System.out.print("Введите age: ");
                     int age = sc.nextInt();
                     boolean r = WorkWithMySQL.updateTable(ID, name, age);
                     System.out.println((r) ? "Пользователь обновлен" : "Проверьте есть ли такой пользователь для обновление");
                     break;
                 case 5:
                     System.out.print("Введите name: ");
                     String Name = sc.next(); // name
                     System.out.print("Введите age: ");
                     int Age = sc.nextInt(); // age
                     WorkWithMySQL.insertUser(Name, Age);
                     break;
                 case 6:
                     System.out.println("Bye bye");
                     System.exit(0);
                     break;
                 default:
                     System.out.println("Неправильная команда!");
             }
         }
    }

    private static void printMenu(){
        System.out.println("\nMENU:");
        System.out.println("PRESS [1] TO CREATE TABLE");
        System.out.println("PRESS [2] TO ALL USERS");
        System.out.println("PRESS [3] TO DELETE USERS");
        System.out.println("PRESS [4] TO UPDATE USER");
        System.out.println("PRESS [5] TO INSERT USER");
        System.out.println("PRESS [6] TO EXIT");
        System.out.print("Выберите кнопку: ");
    }
}
