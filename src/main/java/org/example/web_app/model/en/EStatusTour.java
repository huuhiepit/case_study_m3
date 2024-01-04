package org.example.web_app.model.en;

public enum EStatusTour {
    //ENUM('START', 'PROCESSING', 'END')
    START("Đã khởi hành"), PROCESSING("Chưa khởi hành"), END("Đã kết thúc");
    public String status;
    EStatusTour(String status) {
        this.status = status;
    }
}
