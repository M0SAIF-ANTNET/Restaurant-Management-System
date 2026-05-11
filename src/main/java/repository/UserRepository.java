package repository;

import model.User;
import model.Employee;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public void save(User user) {
        String sql = "INSERT INTO users (username, password, name, phone, email, address, role, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getEmail());
            if (user instanceof Employee) {
                Employee emp = (Employee) user;
                pstmt.setString(6, "Restaurant HQ");
                pstmt.setString(7, emp.getUserRole());
                pstmt.setDouble(8, emp.getSalary());
            } else {
                pstmt.setString(6, "Customer Address");
                pstmt.setString(7, user.getUserRole());
                pstmt.setDouble(8, 0.0);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // الميثود دي هي اللي هتحل مشكلة عرض البيانات في الجداول
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String role = rs.getString("role");
                if ("CUSTOMER".equalsIgnoreCase(role)) {
                    // سحب العميل مع رقم تليفونه
                    users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), 
                                     rs.getString("email"), rs.getString("username"), rs.getString("password"), role));
                } else {
                    // سحب الموظف مع مرتبه ورقم تليفونه
                    users.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), 
                                         rs.getString("email"), rs.getString("username"), rs.getString("password"), 
                                         role, rs.getDouble("salary")));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return users;
    }

    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), 
                               rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}