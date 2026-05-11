package service;

import model.Customer;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public List<Customer> getAllCustomers() {
    List<Customer> customers = new ArrayList<>();
    // بنجيب البيانات اللي محتاجها الكاستمر من جدول users (باعتبارهم سجلوا فيه)
    // ولو عندك جدول منفصل للكاستمرز ممكن نغير اسم الجدول هنا
    String query = "SELECT * FROM users WHERE role = 'CUSTOMER'"; 
    
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            // بننادي الـ Constructor بتاعك بالـ 5 باراميترز بتوعه بالظبط
            Customer cust = new Customer(
                rs.getInt("id"),         // id
                rs.getString("name"),     // name
                "01xxxxxxxxx",            // phone (قيمة افتراضية للحفاظ على الموديل)
                "customer@email.com",     // email (قيمة افتراضية للحفاظ على الموديل)
                "Cairo, Egypt"            // address (قيمة افتراضية للحفاظ على الموديل)
            );
            customers.add(cust);
        }
    } catch (SQLException e) {
        System.err.println("Error fetching customers: " + e.getMessage());
    }
    return customers;
}
}