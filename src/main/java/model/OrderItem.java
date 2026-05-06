package model;

public class OrderItem {
    private Meal meal;
    private int quantity;
    private double subTotal;

    public OrderItem(Meal meal, int quantity) {
        this.meal = meal;
        this.quantity = quantity;
        this.subTotal = meal.getPrice() * quantity;
    }

    public Meal getMeal() { return meal; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        this.quantity = quantity;
        this.subTotal = meal.getPrice() * quantity; // Recalculate
    }
    public double getSubTotal() { return subTotal; }
}