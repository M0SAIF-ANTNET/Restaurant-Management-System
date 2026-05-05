package model;

import java.util.ArrayList;

public class Customer extends Person {
    private String address;
    private double totalPayments;
    private int loyaltyPoints;
    private ArrayList<String> ordersHistory;
    private ArrayList<Double> paymentsHistory;
    private ArrayList<String> giftsReceived;
    private ArrayList<String> offersReceived;

    public Customer(String id, String name, String phone, String email, String address) {
        super(id, name, phone, email);
        this.address = address;
        this.totalPayments = 0.0;
        this.loyaltyPoints = 0;
        this.ordersHistory = new ArrayList<>();
        this.paymentsHistory = new ArrayList<>();
        this.giftsReceived = new ArrayList<>();
        this.offersReceived = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public ArrayList<String> getOrdersHistory() {
        return ordersHistory;
    }

    public void setOrdersHistory(ArrayList<String> ordersHistory) {
        this.ordersHistory = ordersHistory;
    }

    public ArrayList<Double> getPaymentsHistory() {
        return paymentsHistory;
    }

    public void setPaymentsHistory(ArrayList<Double> paymentsHistory) {
        this.paymentsHistory = paymentsHistory;
    }

    public ArrayList<String> getGiftsReceived() {
        return giftsReceived;
    }

    public void setGiftsReceived(ArrayList<String> giftsReceived) {
        this.giftsReceived = giftsReceived;
    }

    public ArrayList<String> getOffersReceived() {
        return offersReceived;
    }

    public void setOffersReceived(ArrayList<String> offersReceived) {
        this.offersReceived = offersReceived;
    }

    public void addOrder(String order) {
        ordersHistory.add(order);
    }

    public void addPayment(double amount) {
        paymentsHistory.add(amount);
        totalPayments += amount;
        loyaltyPoints += (int) (amount / 10);
    }

    public void addGift(String gift) {
        giftsReceived.add(gift);
    }

    public void addOffer(String offer) {
        offersReceived.add(offer);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + address + '\'' +
                ", totalPayments=" + totalPayments +
                ", loyaltyPoints=" + loyaltyPoints +
                ", ordersHistory=" + ordersHistory +
                ", paymentsHistory=" + paymentsHistory +
                ", giftsReceived=" + giftsReceived +
                ", offersReceived=" + offersReceived +
                '}';
    }
}