package util;

import java.util.regex.Pattern;

public class InputValidator {

    public static boolean isNotEmpty(String text) {
        return text != null && !text.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^01[0125]\\d{8}$");
    }

    public static boolean isPositive(double value) {
        return value > 0;
    }

    public static boolean isStrongPassword(String password) {
        return password != null && password.length() >= 6;
    }
}