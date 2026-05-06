package util;

import enums.MealCategory;
import java.util.Arrays;

public class MenuUtil {
    
    public static void displayCategories() {
        System.out.println("Available Categories:");
        Arrays.stream(MealCategory.values())
              .forEach(category -> System.out.println("- " + category));
    }

    public static String getCategoryDescription(MealCategory category) {
        switch (category) {
            case APPETIZER: return "Start your meal with something light.";
            case MAIN_COURSE: return "Our heavy and delicious signature dishes.";
            case DESSERT: return "Sweet treats to end your experience.";
            case BEVERAGE: return "Refreshing drinks and juices.";
            default: return "Delicious restaurant selection.";
        }
    }
}