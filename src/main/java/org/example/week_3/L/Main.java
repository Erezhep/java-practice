package org.example.week_3.L;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "";
        String user = "root";
        String password = "";

        // Подключение к базе данных MySQL
        try (Connection conn = DriverManager.getConnection(url, user, password)){
            System.out.println("✅ Успешное подключение к MySQL!");
            conn.setAutoCommit(false);

            // Создать таблицу users
            String createTableSql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(100) NOT NULL, "
                    + "email VARCHAR(100) UNIQUE NOT NULL"
                    + ")";
            try (Statement stmt = conn.createStatement()){
                stmt.executeUpdate(createTableSql);
                System.out.println("✅ Таблица 'users' создана!");
            }

            // Добавление пользователи в база данных
            String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)){
//                 pstmt.setString(1, "Bekarys");
//                 pstmt.setString(2, "beka@example.com");
//                 pstmt.executeUpdate();

                System.out.println("✅ Данные добавлены!");
            }

            // Чтение данных
            String selectSQL = "SELECT * FROM users";
            try (Statement state = conn.createStatement();
                ResultSet rs = state.executeQuery(selectSQL)){
                System.out.println("📋 Список пользователей:");
                System.out.println(rs);
            }

        }
    }
}
