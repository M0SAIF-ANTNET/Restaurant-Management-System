package model;

import enums.PaymentMethod;
import enums.PaymentStatus;
import java.util.Date;

public class Bill {
    private int billId;
    private int orderId;
    private double amount;
    private double tax;
    private double discount;
    private double finalAmount;
    private PaymentStatus status;
    private Date billDate;

    public Bill(int billId, int orderId, double amount, double discount) {
        this.billId = billId;
        this.orderId = orderId;
        this.amount = amount;
        this.discount = discount;
        this.tax = amount * 0.14; // 14% VAT example
        this.finalAmount = (amount + tax) - discount;
        this.status = PaymentStatus.UNPAID;
        this.billDate = new Date();
    }

    // Getters and Setters
    public int getBillId() { return billId; }
    public double getFinalAmount() { return finalAmount; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
}