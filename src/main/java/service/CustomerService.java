package service;

import model.Customer;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public List<Customer> getAllCustomers() {
    List<Customer> customers = new ArrayList<>();
    String query = "SELECT * FROM users WHERE role = 'CUSTOMER'"; 
    
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            Customer cust = new Customer(
                rs.getInt("id"),        
                rs.getString("name"),     
                "01xxxxxxxxx",            
                "customer@email.com",     
                "Cairo, Egypt"            
            );
            customers.add(cust);
        }
    } catch (SQLException e) {
        System.err.println("Error fetching customers: " + e.getMessage());
    }
    return customers;
}
}