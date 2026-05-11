package repository;

import model.Order;
import model.Meal;
import enums.OrderStatus;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    // Constructor عشان أول ما نستخدم الريبوزتري يتأكد إن الجداول موجودة
    public OrderRepository() {
        createTablesIfNotExist();
    }

    private void createTablesIfNotExist() {
        String sqlOrders = "CREATE TABLE IF NOT EXISTS orders (" +
                           "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                           "customer_name TEXT, " +
                           "total_price REAL, " +
                           "status TEXT);";
        
        String sqlOrderItems = "CREATE TABLE IF NOT EXISTS order_items (" +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                               "order_id INTEGER, " +
                               "meal_id INTEGER, " +
                               "quantity INTEGER, " +
                               "FOREIGN KEY (order_id) REFERENCES orders(id));";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlOrders);
            stmt.execute(sqlOrderItems);
        } catch (SQLException e) {
            System.err.println("Error initializing tables: " + e.getMessage());
        }
    }

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

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Order order = new Order(
                    rs.getInt("id"),
                    rs.getString("customer_name"),
                    new ArrayList<>(),
                    rs.getDouble("total_price"),
                    OrderStatus.valueOf(rs.getString("status"))
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}