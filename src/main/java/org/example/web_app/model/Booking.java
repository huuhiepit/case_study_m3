package org.example.web_app.model;

import org.example.web_app.model.en.EPay;
import org.example.web_app.model.en.EStatus;
import org.example.web_app.model.en.EStatusTour;

import java.time.LocalDate;

public class Booking {
    private long id;
    private int seat;
    private long totalPrice;
    private LocalDate dateBooking;
    private EStatus status;
    private EPay pay;
    private long idCustomer;
    private String customerName;
    private String customerPhone;
    private String tourName;
    private long idDescriptionTour;
    private LocalDate dateStat;
    private LocalDate dateEnd;
    private String idEmployee;
    private String employeeName;
    private String employeePhone;

    public Booking() {}
    public Booking(long id, int seat, long totalPrice, LocalDate dateBooking, EStatus status, EPay pay, String customerName, String customerPhone, String tourName, long idDescriptionTour, LocalDate dateStat, LocalDate dateEnd, String employeeName, String employeePhone) {
        this.id = id;
        this.seat = seat;
        this.totalPrice = totalPrice;
        this.dateBooking = dateBooking;
        this.status = status;
        this.pay = pay;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.tourName = tourName;
        this.idDescriptionTour = idDescriptionTour;
        this.dateStat = dateStat;
        this.dateEnd = dateEnd;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
    }

    public Booking(int seat, long totalPrice, EPay pay, long idCustomer, long idDescriptionTour) {
        this.seat = seat;
        this.totalPrice = totalPrice;
        this.pay = pay;
        this.idCustomer = idCustomer;
        this.idDescriptionTour = idDescriptionTour;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
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

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
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

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public long getIdDescriptionTour() {
        return idDescriptionTour;
    }

    public void setIdDescriptionTour(long idDescriptionTour) {
        this.idDescriptionTour = idDescriptionTour;
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
                ", status=" + status +
                ", pay=" + pay +
                ", customerName='" + customerName + '\'' +
                ", phone='" + customerPhone + '\'' +
                ", tourName='" + tourName + '\'' +
                ", idDescriptionTour=" + idDescriptionTour +
                ", dateStat=" + dateStat +
                ", dateEnd=" + dateEnd +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
