package main;
import model.User;
import service.AuthService;
import util.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = DataSeeder.seedUsers();
        AuthService authService = new AuthService(users);

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Restaurant Management System ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User loggedInUser = authService.login(username, password);

        if (loggedInUser != null) {
            System.out.println("Welcome, " + loggedInUser.getName());

            authService.logout(loggedInUser);
        } else {
            System.out.println("Login failed.");
        }

        scanner.close();
    }
}
//Mohamed HAmouda 16-4-26