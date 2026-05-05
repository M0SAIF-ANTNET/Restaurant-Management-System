package service;
import java.util.ArrayList;
import model.Customer;

public class CustomerService {
    private ArrayList<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
    }

    public boolean addCustomer(Customer c) {
        if (c == null || searchCustomerById(c.getId()) != null) {
            return false;
        }
        customers.add(c);
        return true;
    }

    public boolean removeCustomer(String id) {
        Customer customer = searchCustomerById(id);
        if (customer != null) {
            customers.remove(customer);
            return true;
        }
        return false;
    }

    public boolean updateCustomer(String id, Customer newData) {
        Customer customer = searchCustomerById(id);
        if (customer == null || newData == null) {
            return false;
        }

        customer.setName(newData.getName());
        customer.setPhone(newData.getPhone());
        customer.setEmail(newData.getEmail());
        customer.setAddress(newData.getAddress());
        customer.setTotalPayments(newData.getTotalPayments());
        customer.setLoyaltyPoints(newData.getLoyaltyPoints());
        customer.setOrdersHistory(newData.getOrdersHistory());
        customer.setPaymentsHistory(newData.getPaymentsHistory());
        customer.setGiftsReceived(newData.getGiftsReceived());
        customer.setOffersReceived(newData.getOffersReceived());
        return true;
    }

    public ArrayList<Customer> listCustomers() {
        return customers;
    }

    public Customer searchCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(id)) {
                return customer;
            }
        }
        return null;
    }

    public ArrayList<Customer> searchCustomerByName(String name) {
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customer);
            }
        }
        return result;
    }

    public boolean addPaymentToCustomer(String id, double amount) {
        Customer customer = searchCustomerById(id);
        if (customer != null) {
            customer.addPayment(amount);
            return true;
        }
        return false;
    }

    public boolean addOrderToCustomer(String id, String order) {
        Customer customer = searchCustomerById(id);
        if (customer != null) {
            customer.addOrder(order);
            return true;
        }
        return false;
    }
}