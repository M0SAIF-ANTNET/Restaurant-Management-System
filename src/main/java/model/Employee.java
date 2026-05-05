package model;

public class Employee extends User {
    private String role;
    private double salary;

    public Employee(String id, String name, String phone, String email,
                    String username, String password, String role, double salary) {
        super(id, name, phone, email, username, password);
        this.role = role;
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void displayEmployeeInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Username: " + getUsername());
        System.out.println("Role: " + role);
        System.out.println("Salary: " + salary);
    }
}