package model;
import enums.UserRole;

public class User extends Person {
    private String username;
    private String password;
    private String userRole; // ADMIN, WAITER, CHEF, etc.

    public User(int id, String name, String phone, String email, String username, String password, String userRole) {
        super(id, name, phone, email);
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getUserRole() { return userRole; }
    public void setUserRole(String userRole) { this.userRole = userRole; }
}