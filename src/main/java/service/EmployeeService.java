package service;

import model.Employee;
import repository.UserRepository; // Since employees are users

public class EmployeeService {
    private final UserRepository userRepository;

    public EmployeeService() {
        this.userRepository = new UserRepository();
    }

    public void updateSalary(int employeeId, double newSalary) {
        // SQL Logic to update salary in users/employees table
        System.out.println("Salary updated for employee ID: " + employeeId);
    }
}