package repository;

import model.Order;
import model.OrderItem;
import enums.OrderStatus;
import util.DatabaseConnection;
import java.sql.*;

public class OrderRepository {

    public void saveOrder(Order order) {
        String orderSql = "INSERT INTO orders (customer_id, total_amount, status, order_date) VALUES (?, ?, ?, ?)";
        String itemSql = "INSERT INTO order_items (order_id, meal_id, quantity, subtotal) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Start Transaction

            int generatedOrderId = -1;
            try (PreparedStatement pstmt = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setInt(1, order.getOrderId()); // Assuming manual ID or adjust for Auto-increment
                pstmt.setDouble(2, order.getTotalAmount());
                pstmt.setString(3, order.getStatus().name());
                pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                pstmt.executeUpdate();

                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    generatedOrderId = rs.getInt(1);
                }
            }

            try (PreparedStatement itemPstmt = conn.prepareStatement(itemSql)) {
                for (OrderItem item : order.getItems()) {
                    itemPstmt.setInt(1, generatedOrderId);
                    itemPstmt.setInt(2, item.getMeal().getId());
                    itemPstmt.setInt(3, item.getQuantity());
                    itemPstmt.setDouble(4, item.getSubTotal());
                    itemPstmt.addBatch(); // Performance optimization
                }
                itemPstmt.executeBatch();
            }

            conn.commit(); 
        } catch (SQLException e) {
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            e.printStackTrace();
        }
    }

    public void updateStatus(int orderId, OrderStatus status) {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status.name());
            pstmt.setInt(2, orderId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}