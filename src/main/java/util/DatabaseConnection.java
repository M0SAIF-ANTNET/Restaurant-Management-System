package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:restaurant.db";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.xerial.sqlite-jdbc");
                connection = DriverManager.getConnection(URL);
                initializeDatabase();
            }
        } catch (Exception e) {
            System.err.println("Database Connection Error: " + e.getMessage());
        }
        return connection;
    }

    private static void initializeDatabase() {
        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, username TEXT UNIQUE, password TEXT, role TEXT)");
            
        } catch (SQLException e) {
            System.err.println("Table Creation Error: " + e.getMessage());
        }
    }
}