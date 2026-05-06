package util;

import model.User;
import model.Meal;
import enums.MealCategory;
import repository.UserRepository;
import repository.MealRepository;
import java.sql.Connection;
import java.sql.Statement;

public class DataSeeder {

    public static void seed() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE IF NOT EXISTS meals (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, description TEXT, price REAL, category TEXT)");

            UserRepository userRepo = new UserRepository();
            if (userRepo.login("admin", "admin123") == null) {
                userRepo.save(new User(0, "System Admin", "01234567890", "admin@restaurant.com", "admin", "admin123", "ADMIN"));
                System.out.println("Default admin created: admin/admin123");
            }

            MealRepository mealRepo = new MealRepository();
            if (mealRepo.getAllMeals().isEmpty()) {
                mealRepo.addMeal(new Meal(0, "Margherita Pizza", "Classic tomato and mozzarella", 120.0, MealCategory.MAIN_COURSE));
                mealRepo.addMeal(new Meal(0, "Beef Burger", "Grilled beef with special sauce", 150.0, MealCategory.MAIN_COURSE));
                mealRepo.addMeal(new Meal(0, "Caesar Salad", "Fresh lettuce with parmesan", 80.0, MealCategory.APPETIZER));
                mealRepo.addMeal(new Meal(0, "Molten Cake", "Chocolate lava cake", 90.0, MealCategory.DESSERT));
                mealRepo.addMeal(new Meal(0, "Fresh Orange Juice", "100% natural", 40.0, MealCategory.BEVERAGE));
                System.out.println("Sample menu items added.");
            }

        } catch (Exception e) {
            System.err.println("Seeding Error: " + e.getMessage());
        }
    }
}