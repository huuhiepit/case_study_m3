package org.example.web_app.model;

import org.example.web_app.model.en.EPay;
import org.example.web_app.model.en.EStatusTour;

import java.time.LocalDate;

public class Booking {
    private long id;
    private int seat;
    private long totalPrice;
    private LocalDate dateBooking;
    private EStatusTour statusTour;
    private EPay pay;
    private String customerName;
    private String phone;
    private String tourName;
    private LocalDate dateStat;
    private LocalDate dateEnd;
    private String employeeName;

    public Booking(long id, int seat, long totalPrice, LocalDate dateBooking, EStatusTour statusTour, EPay pay, String customerName, String phone, String tourName, LocalDate dateStat, LocalDate dateEnd, String employeeName) {
        this.id = id;
        this.seat = seat;
        this.totalPrice = totalPrice;
        this.dateBooking = dateBooking;
        this.statusTour = statusTour;
        this.pay = pay;
        this.customerName = customerName;
        this.phone = phone;
        this.tourName = tourName;
        this.dateStat = dateStat;
        this.dateEnd = dateEnd;
        this.employeeName = employeeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(LocalDate dateBooking) {
        this.dateBooking = dateBooking;
    }

    public EStatusTour getStatusTour() {
        return statusTour;
    }

    public void setStatusTour(EStatusTour statusTour) {
        this.statusTour = statusTour;
    }

    public EPay getPay() {
        return pay;
    }

    public void setPay(EPay pay) {
        this.pay = pay;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public LocalDate getDateStat() {
        return dateStat;
    }

    public void setDateStat(LocalDate dateStat) {
        this.dateStat = dateStat;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", seat=" + seat +
                ", totalPrice=" + totalPrice +
                ", dateBooking=" + dateBooking +
                ", statusTour=" + statusTour +
                ", pay=" + pay +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", tourName='" + tourName + '\'' +
                ", dateStat=" + dateStat +
                ", dateEnd=" + dateEnd +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
