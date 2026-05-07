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
        return mealRepository.getAllMeals();
    }

    public void addNewMeal(Meal meal) {
        mealRepository.addMeal(meal);
    }

    public boolean deleteMeal(int id) {
        try {
            mealRepository.deleteMeal(id);
            return true;
        } catch (Exception e) {
            System.err.println("Error in MealService.deleteMeal: " + e.getMessage());
            return false;
        }
    }
}