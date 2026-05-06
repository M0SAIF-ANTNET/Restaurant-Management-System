package model;

import java.util.Date;

public class Notification {
    private int id;
    private String message;
    private Date timestamp;
    private boolean isRead;

    public Notification(int id, String message) {
        this.id = id;
        this.message = message;
        this.timestamp = new Date();
        this.isRead = false;
    }

    public void markAsRead() { this.isRead = true; }
}