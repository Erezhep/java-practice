package org.example.week_5.P;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {
    // MySQL конфигурации загрузка
    public static Properties loadConfig() throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("config3.properties");
        props.load(fis);
        fis.close();
        return props;
    }

    // Подключение к база данных MySQL
    public static Connection connectToMySQL() throws IOException, SQLException {
        Properties props = loadConfig();

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}
