package model;

public class Employee extends User {
    private double salary;
    private String shift;

    public Employee(int id, String name, String phone, String email, String username, String password, String role, double salary) {
        super(id, name, phone, email, username, password, role);
        this.salary = salary;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
}