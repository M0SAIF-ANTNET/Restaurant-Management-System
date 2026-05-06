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
}