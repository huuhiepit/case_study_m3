package org.example.web_app.controller;

import org.example.web_app.dao.BookingDAO;
import org.example.web_app.dao.impl.IBookingDAO;
import org.example.web_app.model.en.EStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "bookingServlet", urlPatterns = "/manager-booking")
public class BookingServlet extends HttpServlet {
    protected IBookingDAO bookingDAO;
    @Override
    public void init() throws ServletException {
        bookingDAO = new BookingDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(true);

        // Kiểm tra xem có giá trị "account" trong session không
        if (session.getAttribute("account") == null) {
            resp.sendRedirect("/auth");
            return; // Kết thúc xử lý servlet sau khi chuyển hướng
        }
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "update": {
                updateBooking(req, resp);
                break;
            }
            case "": {
                showListBooking(req, resp);
                break;
            }
        }
    }

    private void updateBooking(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bookingDAO.handleTourBooking(Long.parseLong(req.getParameter("id")), 1,EStatus.valueOf(req.getParameter("status")));
        resp.sendRedirect("/manager-booking");
    }

    private void showListBooking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookingList", bookingDAO.getAll());
        req.getRequestDispatcher("admin/booking.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
