package model;

public class Gift {
    private int giftId;
    private String giftName;
    private int requiredPoints;

    public Gift(int giftId, String giftName, int requiredPoints) {
        this.giftId = giftId;
        this.giftName = giftName;
        this.requiredPoints = requiredPoints;
    }

    public int getRequiredPoints() { return requiredPoints; }
    public String getGiftName() { return giftName; }
}