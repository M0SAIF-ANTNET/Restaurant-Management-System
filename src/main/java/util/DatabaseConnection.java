package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:restaurant.db";

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC"); 
            
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Database Connection Error: " + e.getMessage());
            return null;
        }
    }
}