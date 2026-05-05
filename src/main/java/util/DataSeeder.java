package util;
import model.*;

import java.util.ArrayList;

public class DataSeeder {

    public static ArrayList<User> seedUsers() {
        ArrayList<User> users = new ArrayList<>();

        Admin admin = new Admin(
                IdGenerator.generatePersonId(),
                "System Admin",
                "01000000000",
                "admin@restaurant.com",
                "admin",
                "admin123"
        );

        users.add(admin);

        return users;
    }

    public static ArrayList<Person> seedCustomers() {
        ArrayList<Person> customers = new ArrayList<>();
        return customers;
    }

    public static ArrayList<Object> seedMeals() {
        ArrayList<Object> meals = new ArrayList<>();
        return meals;
    }
}
