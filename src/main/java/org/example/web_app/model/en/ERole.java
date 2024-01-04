package org.example.web_app.model.en;

public enum ERole {
    ADMIN("ADMIN"), EMPLOYEE("Nhân viên"), CUSTOMER("Khách hàng");
    public String role;
    ERole(String role) {
        this.role = role;
    }
}
