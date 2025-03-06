package org.example.week_5.P;

import java.io.IOException;
import java.sql.*;

public class WorkWithMySQL {
    public static void createTable() throws SQLException, IOException {
        try (Connection conn = DBConnect.connectToMySQL()){
            String sqlQuery = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50) NOT NULL," +
                    "age INT NOT NULL)";
            try (Statement stmt = conn.createStatement()){
                stmt.executeUpdate(sqlQuery);
                System.out.println("Таблица успешно создано");
            }
        }
    }

    public static boolean deleteTable(int id) throws SQLException, IOException {
        try (Connection conn = DBConnect.connectToMySQL()){
            int res;
            String sqlQuery = "DELETE FROM users WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
                pstmt.setInt(1, id);
                res = pstmt.executeUpdate();
            }
            return res > 0;
        }
    }

    public static void readTable() throws SQLException, IOException {
        String sqlQuery = "SELECT * FROM users";
        try (Connection conn = DBConnect.connectToMySQL();
            Statement pstmt = conn.createStatement()){
            ResultSet rs = pstmt.executeQuery(sqlQuery);
            int counter = 0;
            while (rs.next()) {
                counter++;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
            if (counter == 0){
                System.out.println("Таблица еще пустой!");
            }
        }
    }

    public static boolean updateTable(int id, String name, int age) throws SQLException, IOException {
        String sqlQuery = "UPDATE users SET name = ?, age = ? WHERE id = ?";
        int res;
        try (Connection conn = DBConnect.connectToMySQL();
            PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            res = pstmt.executeUpdate();
        }
        return res > 0;
    }
}
