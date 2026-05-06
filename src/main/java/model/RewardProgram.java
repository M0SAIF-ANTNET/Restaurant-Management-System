package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class RewardProgram extends Program {
    private List<Gift> availableGifts;

    public RewardProgram(int id, String name, double discountRate, Date start, Date end) {
        super(id, name, discountRate, start, end);
        this.availableGifts = new ArrayList<>();
    }

    public void addGift(Gift gift) {
        availableGifts.add(gift);
    }

    public List<Gift> getAvailableGifts() { return availableGifts; }
}