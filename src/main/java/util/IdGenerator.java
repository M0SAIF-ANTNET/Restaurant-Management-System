package util;

public class IdGenerator {
    private static int personCounter = 1;
    private static int customerCounter = 1;
    private static int mealCounter = 1;
    private static int orderCounter = 1;
    private static int billCounter = 1;
    private static int paymentCounter = 1;
    private static int offerCounter = 1;
    private static int giftCounter = 1;
    private static int notificationCounter = 1;

    public static String generatePersonId() {
        return "P" + personCounter++;
    }

    public static String generateCustomerId() {
        return "C" + customerCounter++;
    }

    public static String generateMealId() {
        return "M" + mealCounter++;
    }

    public static String generateOrderId() {
        return "O" + orderCounter++;
    }

    public static String generateBillId() {
        return "B" + billCounter++;
    }

    public static String generatePaymentId() {
        return "PAY" + paymentCounter++;
    }

    public static String generateOfferId() {
        return "OFF" + offerCounter++;
    }

    public static String generateGiftId() {
        return "G" + giftCounter++;
    }

    public static String generateNotificationId() {
        return "N" + notificationCounter++;
    }
}
