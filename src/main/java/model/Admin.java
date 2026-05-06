package model;

public class Admin extends User {

    public Admin(int id, String name, String phone, String email, String username, String password) {
        super(id, name, phone, email, username, password, "ADMIN");
    }

    @Override
    public String toString() {
        return String.format("Admin Profile: [ID: %d | Name: %s | Username: %s]", 
                             getId(), getName(), getUsername());
    }
}