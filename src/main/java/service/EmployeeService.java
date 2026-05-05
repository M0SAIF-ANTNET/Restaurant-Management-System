package service;
import java.util.ArrayList;
import model.Employee;
public class EmployeeService {
    private ArrayList<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<>();
    }

    public boolean addEmployee(Employee e) {
        if (e == null || searchEmployeeById(e.getId()) != null) {
            return false;
        }
        employees.add(e);
        return true;
    }

    public boolean removeEmployee(String id) {
        Employee employee = searchEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            return true;
        }
        return false;
    }

    public boolean updateEmployee(String id, Employee newData) {
        Employee employee = searchEmployeeById(id);
        if (employee == null || newData == null) {
            return false;
        }

        employee.setName(newData.getName());
        employee.setPhone(newData.getPhone());
        employee.setEmail(newData.getEmail());
        employee.setUsername(newData.getUsername());
        employee.setPassword(newData.getPassword());
        employee.setRole(newData.getRole());
        employee.setSalary(newData.getSalary());
        return true;
    }

    public ArrayList<Employee> listEmployees() {
        return employees;
    }

    public Employee searchEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> searchEmployeeByName(String name) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(employee);
            }
        }
        return result;
    }
}