package service;

import model.Order;
import model.Customer;
import repository.OrderRepository;
import repository.CustomerRepository;
import enums.OrderStatus;

public class OrderService {
    private final OrderRepository orderRepository;
    
    public OrderService() {
        this.orderRepository = new OrderRepository();
    }

    public void placeOrder(Order order) {
        if (order.getItems().isEmpty()) {
            System.out.println("Cannot place an empty order.");
            return;
        }

        orderRepository.saveOrder(order);
        
        System.out.println("Order placed successfully. Total: " + order.getTotalAmount());
    }

    public void cancelOrder(int orderId) {
        orderRepository.updateStatus(orderId, OrderStatus.CANCELLED);
    }

    public void completeOrder(int orderId) {
        orderRepository.updateStatus(orderId, OrderStatus.SERVED);
    }
}