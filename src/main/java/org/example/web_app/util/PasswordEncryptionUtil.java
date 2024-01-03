package org.example.web_app.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryptionUtil {
    // Mã hóa mật khẩu
    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
