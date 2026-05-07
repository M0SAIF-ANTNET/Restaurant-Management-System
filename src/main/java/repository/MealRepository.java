package repository;

import model.Meal;
import enums.MealCategory;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealRepository {

    public List<Meal> getAllMeals() {
        List<Meal> meals = new ArrayList<>();
        String sql = "SELECT * FROM meals";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                meals.add(new Meal(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    MealCategory.valueOf(rs.getString("category"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meals;
    }

    public void addMeal(Meal meal) {
        String sql = "INSERT INTO meals (name, description, price, category) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, meal.getName());
            pstmt.setString(2, meal.getDescription());
            pstmt.setDouble(3, meal.getPrice());
            pstmt.setString(4, meal.getCategory().name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMeal(int id) {
        String sql = "DELETE FROM meals WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Meal with ID " + id + " deleted from DB.");
            
        } catch (SQLException e) {
            System.err.println("Error in deleteMeal: " + e.getMessage());
        }
    }
    
}