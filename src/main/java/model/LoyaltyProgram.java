package model;

import java.util.Date;

public class LoyaltyProgram extends Program {
    private int pointsRequired;

    public LoyaltyProgram(int id, String name, double discountRate, Date start, Date end, int pointsRequired) {
        super(id, name, discountRate, start, end);
        this.pointsRequired = pointsRequired;
    }

    public int getPointsRequired() { return pointsRequired; }
}