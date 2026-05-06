package repository;

import model.Order;
import model.Meal;
import enums.OrderStatus;
import util.DatabaseConnection;
import java.sql.*;

public class OrderRepository {
    public void saveOrder(Order order) { 
        String query = "INSERT INTO orders (customer_name, total_price, status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, order.getCustomerName());
            pstmt.setDouble(2, order.getTotalPrice());
            pstmt.setString(3, order.getStatus().toString());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                saveOrderItems(rs.getInt(1), order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveOrderItems(int orderId, Order order) {
        String query = "INSERT INTO order_items (order_id, meal_id, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            for (Meal meal : order.getMeals()) {
                pstmt.setInt(1, orderId);
                pstmt.setInt(2, meal.getMealId());
                pstmt.setInt(3, 1);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(int orderId, OrderStatus status) {
        String query = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, status.toString());
            pstmt.setInt(2, orderId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}