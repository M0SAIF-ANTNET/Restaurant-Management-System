package model;

import enums.PaymentMethod;
import java.util.Date;

public class Payment {
    private int paymentId;
    private int billId;
    private double amountPaid;
    private PaymentMethod method;
    private Date paymentDate;

    public Payment(int paymentId, int billId, double amountPaid, PaymentMethod method) {
        this.paymentId = paymentId;
        this.billId = billId;
        this.amountPaid = amountPaid;
        this.method = method;
        this.paymentDate = new Date();
    }
}