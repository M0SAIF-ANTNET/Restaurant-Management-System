package main; // أو اسم الباكيدج اللي فيها ملف التشغيل عندك

public class Main{ // اسم الكلاس بتاعك
    public static void main(String[] args) {
        
        // دي أهم خطوة: بتعمل ملف الداتا بيز لو مش موجود وتكريت الجداول
        util.DataSeeder.seed();
        
        // دي بتفتح أول شاشة هيشوفها المستخدم (اللوجن)
        java.awt.EventQueue.invokeLater(() -> {
            new ui.LoginForm().setVisible(true);
        });
    }
}