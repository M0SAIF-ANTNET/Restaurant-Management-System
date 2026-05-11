package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerUtil {
    public static void log(String action) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("system_logs.txt", true)))) {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            out.println("[" + time + "] - " + action);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}