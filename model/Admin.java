package model;
public class Admin extends User {

    public Admin(String id, String name, String phone, String email,
                 String username, String password) {
        super(id, name, phone, email, username, password);
    }

    public void changeUsername(String newUsername) {
        setUsername(newUsername);
    }

    public void changePassword(String newPassword) {
        setPassword(newPassword);
    }

    public void manageEmployees() {
        System.out.println("Admin is managing employees.");
    }

    public void manageMeals() {
        System.out.println("Admin is managing meals.");
    }

    public void generateReports() {
        System.out.println("Admin is generating reports.");
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", username='" + getUsername() + '\'' +
                '}';
    }
}