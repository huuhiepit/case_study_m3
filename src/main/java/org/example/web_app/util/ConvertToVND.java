package org.example.web_app.util;

import java.text.NumberFormat;
import java.util.Locale;

public class ConvertToVND {
    public static String convertToVND(int amount) {
        // Chuyển đổi kiểu int thành định dạng tiền tệ VND
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String amountInVND = currencyFormatter.format(amount);

        return amountInVND;
    }
}
