package org.example.web_app.model;

import org.example.web_app.model.en.ERole;

public class Account {
    private long id;
    private String userName;
    private String urlImage;
    private ERole role;

    public Account() {
    }

    public Account(long id, String userName, String urlImage, ERole role) {
        this.id = id;
        this.userName = userName;
        this.urlImage = urlImage;
        this.role = role;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
