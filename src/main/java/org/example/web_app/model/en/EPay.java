package org.example.web_app.model.en;

public enum EPay {
    //ENUM('ONLINE', 'OFFLINE')
    ONLINE("Online"), OFFLINE("Thanh toán tại quầy");
    public String pay;
    EPay(String pay) {
        this.pay = pay;
    }

    public String getPay() {
        return pay;
    }
}
