package util;

import java.sql.Connection;
import java.sql.Statement;

public class DataSeeder {
    public static void seed() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "username TEXT UNIQUE, " +
                         "password TEXT, " +
                         "name TEXT, " +
                         "phone TEXT, " +
                         "email TEXT, " +
                         "address TEXT, " +
                         "role TEXT, " +
                         "salary REAL DEFAULT 0.0)");

            stmt.execute("CREATE TABLE IF NOT EXISTS meals (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "name TEXT, " +
                         "description TEXT, " +
                         "price REAL, " +
                         "category TEXT, " +
                         "available INTEGER)");

            stmt.execute("INSERT OR IGNORE INTO users (username, password, name, role, salary) " +
                         "VALUES ('admin', 'admin123', 'Mohamed Abdelsamea', 'ADMIN', 0.0)");
            stmt.execute("INSERT OR IGNORE INTO users (username, password, name, role, salary) " +
                         "VALUES ('chef1', '123', 'Ahmed the Chef', 'CHEF', 12000.0)");
            stmt.execute("INSERT OR IGNORE INTO users (username, password, name, role, salary) " +
                         "VALUES ('cust1', '123', 'hesham', 'CUSTOMER', 0.0)");
            
            stmt.execute("INSERT OR IGNORE INTO meals (id, name, description, price, category, available) " +
                         "VALUES (1, 'Margherita Pizza', 'Tomato & Mozzarella', 120.0, 'PIZZA', 1)");
            stmt.execute("INSERT OR IGNORE INTO meals (id, name, description, price, category, available) " +
                         "VALUES (2, 'Beef Burger', 'Double patty with cheese', 150.0, 'BURGER', 1)");
            
            System.out.println("✅ Database updated with all attributes.");

        } catch (Exception e) {
            System.err.println("Seeding Error: " + e.getMessage());
        }
    }
}