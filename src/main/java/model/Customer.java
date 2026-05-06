package model;

public class Customer extends Person {
    private String address;
    private int loyaltyPoints;
    private double totalSpent;

    public Customer(int id, String name, String phone, String email, String address) {
        super(id, name, phone, email);
        this.address = address;
        this.loyaltyPoints = 0;
        this.totalSpent = 0.0;
    }

    public void updateLoyaltyPoints(double amount) {
        this.totalSpent += amount;
        this.loyaltyPoints += (int) (amount / 10); // 1 point for every 10 units
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }
    public double getTotalSpent() { return totalSpent; }
}