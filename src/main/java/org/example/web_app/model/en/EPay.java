package org.example.web_app.model.en;

public enum EPay {
    //ENUM('ONLINE', 'OFFLINE')
    ONLINE("Online"), OFFLINE("Nhận tại quầy");
    public String pay;
    EPay(String pay) {
        this.pay = pay;
    }
}
