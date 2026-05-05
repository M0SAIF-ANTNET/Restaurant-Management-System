package service;
import model.User;

import java.util.ArrayList;

public class AuthService {
    private ArrayList<User> users;

    public AuthService(ArrayList<User> users) {
        this.users = users;
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User login(String username, String password) {
        User user = findUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            user.login();
            return user;
        }

        System.out.println("Invalid username or password.");
        return null;
    }

    public void logout(User user) {
        if (user != null) {
            user.logout();
        }
    }
}
