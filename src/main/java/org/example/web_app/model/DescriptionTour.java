package org.example.web_app.model;

import org.example.web_app.model.en.EStatus;

import java.time.LocalDate;

public class DescriptionTour {
    private long id;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int seat;
    private long price;
    private EStatus status;
    private String description;

    public DescriptionTour(long id, LocalDate dateStart, LocalDate dateEnd, int seat, long price, EStatus status, String description) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.seat = seat;
        this.price = price;
        this.status = status;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DescriptionTour{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", seat=" + seat +
                ", price=" + price +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
