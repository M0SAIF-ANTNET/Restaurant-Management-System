package main;

public class Main{
    public static void main(String[] args) {
        
        util.DataSeeder.seed();
        
        java.awt.EventQueue.invokeLater(() -> {
            new ui.LoginForm().setVisible(true);
        });
    }
}