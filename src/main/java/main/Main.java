package main;

import util.DataSeeder;
import ui.LoginForm;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        initializeSystem();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Theme Error: " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
            loginForm.setLocationRelativeTo(null);
        });
    }

    private static void initializeSystem() {
        System.out.println("Initializing Chef Shaker System...");
        try {
            DataSeeder.seed();
            System.out.println("Database sync complete.");
        } catch (Exception e) {
            System.err.println("Critical Error during initialization: " + e.getMessage());
        }
    }
}