package model;

import java.util.Date;

public abstract class Program {
    protected int id;
    protected String name;
    protected double discountRate;
    protected Date startDate;
    protected Date endDate;

    public Program(int id, String name, double discountRate, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.discountRate = discountRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isActive() {
        Date now = new Date();
        return now.after(startDate) && now.before(endDate);
    }

    // Getters
    public String getName() { return name; }
    public double getDiscountRate() { return discountRate; }
}