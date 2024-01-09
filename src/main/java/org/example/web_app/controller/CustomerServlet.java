package org.example.web_app.controller;

import org.example.web_app.dao.DescriptionTourDAO;
import org.example.web_app.dao.TourDAO;
import org.example.web_app.dao.impl.IDescriptionTourDAO;
import org.example.web_app.dao.impl.ITourDAO;
import org.example.web_app.model.Tour;
import org.example.web_app.service.CustomerService;
import org.example.web_app.model.TourDescriptionPair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    protected TourDescriptionPair tourDescriptionPair;
    protected ITourDAO tourDAO;
    protected IDescriptionTourDAO descriptionTourDAO;
    protected CustomerService customerService;
    @Override
    public void init() throws ServletException {
        tourDescriptionPair = new TourDescriptionPair();
        tourDAO = new TourDAO();
        descriptionTourDAO = new DescriptionTourDAO();
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "booking": {
                customerService.addBooking(req, resp);
                break;
            }
            case "": {
                showListTourAndDescription(req, resp);
                break;
            }
        }
    }

    private void showListTourAndDescription(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TourDescriptionPair> descriptionPairList = new ArrayList<>();
        for (Tour tour : tourDAO.getAll()) {
            descriptionPairList.add( new TourDescriptionPair(tour, descriptionTourDAO.getBookingDescriptionTourBy(tour.getId())));
        }
        req.setAttribute("tourDescriptionPair", descriptionPairList);
        req.getRequestDispatcher("customer/index.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
