package model;

import enums.OrderStatus;
import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private List<Meal> meals;
    private double totalPrice;
    private OrderStatus status;

    public Order(int orderId, String customerName, List<Meal> meals, double totalPrice, OrderStatus status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.meals = meals;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public List<Meal> getMeals() { return meals; }
    public List<Meal> getItems() { return meals; } 
    public double getTotalPrice() { return totalPrice; }
    public double getTotalAmount() { return totalPrice; } 
    public OrderStatus getStatus() { return status; }
}