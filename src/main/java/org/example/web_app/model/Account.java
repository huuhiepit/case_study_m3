package org.example.web_app.model;

import org.example.web_app.model.en.ERole;

public class Account {
    private long id;
    private String userName;
    private String password;
    private String urlImage;
    private ERole role;

    public Account() {
    }

    public Account(long id, String userName, String password, String urlImage, ERole role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.urlImage = urlImage;
        this.role = role;
    }
}
