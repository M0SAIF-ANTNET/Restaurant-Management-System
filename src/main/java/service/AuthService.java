package service;

import model.User;
import repository.UserRepository;

public class AuthService {
    private final UserRepository userRepository;
    private static User currentUser; // To keep track of the logged-in user

    public AuthService() {
        this.userRepository = new UserRepository();
    }

    public boolean login(String username, String password) {
        User user = userRepository.login(username, password);
        if (user != null) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public static void logout() {
        currentUser = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isAdmin() {
        return currentUser != null && "ADMIN".equalsIgnoreCase(currentUser.getUserRole());
    }
    // أضف هذه الميثود داخل كلاس AuthService
public boolean register(User user) {
    try {
        // ندهنا ميثود save اللي موجودة فعلاً في الـ UserRepository بتاعك
        userRepository.save(user); 
        return true;
    } catch (Exception e) {
        System.err.println("Registration Error: " + e.getMessage());
        return false;
    }
}
}