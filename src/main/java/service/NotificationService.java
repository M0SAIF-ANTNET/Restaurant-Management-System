package service;

import model.Notification;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<Notification> activeNotifications = new ArrayList<>();

    public void sendNotification(String message) {
        Notification note = new Notification(0, message);
        activeNotifications.add(note);
        System.out.println("ALERT: " + message);
    }

    public List<Notification> getUnreadNotifications() {
        return activeNotifications;
    }
}