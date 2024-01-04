package org.example.web_app.model;

import org.example.web_app.model.en.ERole;

public class Employee {

    private long id;
    private String name;
    private String phone;
    private String address;
    private String userName;
    private String urlImage;
    private ERole role;

    public Employee () {}
    public Employee(long id, String name, String phone, String address, String userName, String urlImage, ERole role) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.userName = userName;
        this.urlImage = urlImage;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", role=" + role +
                '}';
    }
}
