package service;

import model.Employee;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

public List<Employee> getAllEmployees() {
    List<Employee> employees = new ArrayList<>();
    String query = "SELECT * FROM users WHERE role != 'ADMIN'"; 
    
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            Employee emp = new Employee(
                rs.getInt("id"),          
                rs.getString("name"),      
                "N/A",                     
                "N/A",                     
                rs.getString("username"),  
                rs.getString("password"),  
                rs.getString("role"),      
                8000.0                     
            );
            employees.add(emp);
        }
    } catch (SQLException e) {
        System.err.println("Error fetching employees: " + e.getMessage());
    }
    return employees;
}
    public boolean deleteEmployee(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
            return false;
        }
    }
}