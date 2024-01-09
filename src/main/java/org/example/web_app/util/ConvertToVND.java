package org.example.web_app.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class ConvertToVND {
    public static String convertToVND(long amount) {
        // Sử dụng Locale với ngôn ngữ là tiếng Việt và quốc gia là Việt Nam
        Locale locale = new Locale("vi", "VN");

        // Tạo một DecimalFormat với dấu phẩy thay vì dấu chấm
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0", symbols);

        String amountInVND = decimalFormat.format(amount);

        // Thêm đơn vị tiền tệ (VND)
        amountInVND += " VND";

        return amountInVND;
    }
}
