package model;

import enums.MealCategory;

public class Meal {
    private int mealId;
    private String name;
    private String description;
    private double price;
    private MealCategory category;
    private boolean available;

    public Meal(int mealId, String name, String description, double price, MealCategory category, boolean available) {
        this.mealId = mealId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    public Meal(int mealId, String name, String description, double price, MealCategory category) {
        this(mealId, name, description, price, category, true);
    }

    public int getMealId() { return mealId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public MealCategory getCategory() { return category; }
    public boolean isAvailable() { return available; }
}