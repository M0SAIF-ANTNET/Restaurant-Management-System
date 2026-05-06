package model;

import enums.OrderStatus;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int orderId;
    private int customerId;
    private ArrayList<OrderItem> items;
    private double totalAmount;
    private OrderStatus status;
    private Date orderDate;

    public Order(int orderId, int customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.orderDate = new Date();
    }

    public void addItem(OrderItem item) {
        items.add(item);
        calculateTotal();
    }

    private void calculateTotal() {
        this.totalAmount = items.stream().mapToDouble(OrderItem::getSubTotal).sum();
    }

    // Getters
    public int getOrderId() { return orderId; }
    public ArrayList<OrderItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}