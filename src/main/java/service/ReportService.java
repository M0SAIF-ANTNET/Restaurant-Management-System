package service;

import repository.OrderRepository;
import model.Order;
import java.util.List;

public class ReportService {
    private final OrderRepository orderRepository;

    public ReportService() {
        this.orderRepository = new OrderRepository();
    }

    public double calculateDailyRevenue() {
        return 0.0;
    }

    public void printTopSellingMeals() {
        System.out.println("Generating Top Selling Meals Report...");
    }
}