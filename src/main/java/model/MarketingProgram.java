package model;

import java.util.Date;

public class MarketingProgram extends Program {
    private String targetAudience;

    public MarketingProgram(int id, String name, double discountRate, Date start, Date end, String targetAudience) {
        super(id, name, discountRate, start, end);
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience() { return targetAudience; }
}