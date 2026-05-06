package util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DisplayHelper {
    
    public static String formatCurrency(double amount) {
        return String.format(Locale.US, "%,.2f EGP", amount);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMM yyyy");
        return formatter.format(date);
    }

    public static void printHeader(String title) {
        System.out.println("\n================ " + title.toUpperCase() + " ================");
    }
}