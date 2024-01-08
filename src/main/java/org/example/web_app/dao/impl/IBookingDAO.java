package org.example.web_app.dao.impl;

import org.example.web_app.model.Booking;
import org.example.web_app.model.en.EStatus;

import java.util.List;

public interface IBookingDAO {
    List<Booking> getAll();

    void handleTourBooking(long id, EStatus status);

    void createBooking(Booking booking);
}
