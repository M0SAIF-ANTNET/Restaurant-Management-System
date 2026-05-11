package service;

import model.Employee;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

public List<Employee> getAllEmployees() {
    List<Employee> employees = new ArrayList<>();
    // بنجيب كل البيانات من جدول users عشان نملأ الـ Constructor بتاع الـ Employee
    String query = "SELECT * FROM users WHERE role != 'ADMIN'"; 
    
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            // هنا بنبعت كل الـ 8 باراميترز اللي الكود بتاعك محتاجها
            Employee emp = new Employee(
                rs.getInt("id"),          // id
                rs.getString("name"),      // name
                "N/A",                     // phone (ممكن تزوده في الداتا بيز بعدين)
                "N/A",                     // email (ممكن تزوده في الداتا بيز بعدين)
                rs.getString("username"),  // username
                rs.getString("password"),  // password
                rs.getString("role"),      // role
                8000.0                     // salary
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