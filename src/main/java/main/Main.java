package main;

import util.DataSeeder;
import util.DisplayHelper;
import service.AuthService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize DB and Sample Data
        System.out.println("Initializing System...");
        DataSeeder.seed();

        DisplayHelper.printHeader("Welcome to Restaurant System");
        
        // 2. Simple Console Login (Testing before GUI)
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();

        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        if (authService.login(user, pass)) {
            System.out.println("Login Successful!");
            System.out.println("Welcome, " + AuthService.getCurrentUser().getName());
            System.out.println("Role: " + AuthService.getCurrentUser().getUserRole());
            
            // Here you would launch the GUI in the next step
            // Example: new LoginUI().setVisible(true);
        } else {
            System.out.println("Invalid credentials. Please restart.");
        }
    }
}