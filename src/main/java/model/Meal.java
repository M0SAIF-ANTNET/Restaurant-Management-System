package model;

import enums.MealCategory;

public class Meal {
    private int id;
    private String name;
    private String description;
    private double price;
    private MealCategory category;
    private boolean isAvailable;

    public Meal(int id, String name, String description, double price, MealCategory category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.isAvailable = true;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public MealCategory getCategory() { return category; }
    public void setCategory(MealCategory category) { this.category = category; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public String getDescription() { return description; }
    
}