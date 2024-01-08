package org.example.web_app.service;

import org.example.web_app.dao.BookingDAO;
import org.example.web_app.dao.impl.IBookingDAO;
import org.example.web_app.model.Booking;
import org.example.web_app.model.en.EPay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerService {
    public IBookingDAO bookingDAO;
    public CustomerService() {
        bookingDAO = new BookingDAO();
    }
    public void addBooking(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bookingDAO.createBooking( new Booking(
                Integer.parseInt(req.getParameter("seat")),
                Long.parseLong(req.getParameter("price")),
                EPay.valueOf(req.getParameter("pay")),
                1,
                Long.parseLong(req.getParameter("id"))
        ));
        resp.sendRedirect("/customer");
    }
}
