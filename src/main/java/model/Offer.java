package model;

import java.util.Date;

public class Offer {
    private int offerId;
    private String title;
    private double discountPercentage;
    private Date expiryDate;

    public Offer(int offerId, String title, double discountPercentage, Date expiryDate) {
        this.offerId = offerId;
        this.title = title;
        this.discountPercentage = discountPercentage;
        this.expiryDate = expiryDate;
    }

    public boolean isValid() {
        return new Date().before(expiryDate);
    }

    public double getDiscountPercentage() { return discountPercentage; }
}