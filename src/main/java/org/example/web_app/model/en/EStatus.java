package org.example.web_app.model.en;

public enum EStatus {
    //ENUM('PROCESSING', 'PROCESSED', 'CANCEL')
    PROCESSING("Đã xử lý"), PROCESSED("Đang chờ xử lý"), CANCEL("Hủy");
    public String status;
    EStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
