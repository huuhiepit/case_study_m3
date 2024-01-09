package org.example.web_app.service;

import org.example.web_app.dao.AuthDAO;
import org.example.web_app.dao.BookingDAO;
import org.example.web_app.dao.impl.IBookingDAO;
import org.example.web_app.model.Account;
import org.example.web_app.model.Booking;
import org.example.web_app.model.en.EPay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomerService {
    public IBookingDAO bookingDAO;
    protected AuthDAO authDAO;
    public CustomerService() {
        bookingDAO = new BookingDAO();
        authDAO = new AuthDAO();
    }
    public void addBooking(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        Account account = (Account) session.getAttribute("accountCustomer");

        bookingDAO.createBooking( new Booking(
                Integer.parseInt(req.getParameter("seat")),
                Long.parseLong(req.getParameter("price")),
                EPay.valueOf(req.getParameter("pay")),
                authDAO.getCustomerBy(account.getId()).getId(),
                Long.parseLong(req.getParameter("id"))
        ));
        resp.sendRedirect("/customer");
    }
}
