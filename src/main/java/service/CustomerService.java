package service;

import model.Customer;
import repository.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    public void registerNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void redeemPoints(int customerId, int points) {
        Customer c = customerRepository.findById(customerId);
        if (c != null && c.getLoyaltyPoints() >= points) {
            c.setLoyaltyPoints(c.getLoyaltyPoints() - points);
            customerRepository.updatePoints(customerId, c.getLoyaltyPoints(), c.getTotalSpent());
        }
    }
        public List<Customer> getAvailableCustomers() {
        return customerRepository.getAllMeals();
    }

    public void addNewCustomer(Meal meal) {
        customerRepository.addCustomer(customer);
    }

    public boolean deleteCustomer(int id) {
        try {
            customerRepository.deleteCustomer(id);
            return true;
        } catch (Exception e) {
            System.err.println("Error in MealService.deleteCustomer: " + e.getMessage());
            return false;
        }
    }
}