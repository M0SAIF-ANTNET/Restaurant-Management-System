package service;

import model.Order;
import model.Bill;
import model.Payment;
import enums.PaymentMethod;
import enums.PaymentStatus;

public class BillingService {
    private static final double TAX_RATE = 0.14; // 14% VAT

    public Bill createBill(Order order, double discount) {
        double subtotal = order.getTotalAmount();
        Bill bill = new Bill(0, order.getOrderId(), subtotal, discount);
        return bill;
    }

    public void processPayment(Bill bill, PaymentMethod method) {
        Payment payment = new Payment(0, bill.getBillId(), bill.getFinalAmount(), method);
        bill.setStatus(PaymentStatus.PAID);
        System.out.println("Payment processed successfully via " + method);
    }
}