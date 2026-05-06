package service;

import model.Meal;
import repository.MealRepository;
import java.util.List;

public class MealService {
    private final MealRepository mealRepository;

    public MealService() {
        this.mealRepository = new MealRepository();
    }

    public List<Meal> getAvailableMenu() {
        // Business Rule: We can filter only available meals here
        return mealRepository.getAllMeals();
    }

    public void addNewMeal(Meal meal) {
        // Logic: Check if meal name already exists before adding
        mealRepository.addMeal(meal);
    }
}