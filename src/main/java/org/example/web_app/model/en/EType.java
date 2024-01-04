package org.example.web_app.model.en;

public enum EType {
    //ENUM('DOMESTIC', 'FOREIGN')
    DOMESTIC("Trong nước"), FOREIGN("Nước ngoài");
    public String type;
    EType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
