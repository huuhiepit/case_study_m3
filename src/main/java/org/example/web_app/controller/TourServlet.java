package org.example.web_app.controller;

import org.example.web_app.dao.TourDao;
import org.example.web_app.dao.impl.ITourDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "tourServlet", urlPatterns = "/manager-tour")
public class TourServlet extends HttpServlet {
    protected ITourDAO tourDAO;
    @Override
    public void init() throws ServletException {
        tourDAO = new TourDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tourList", tourDAO.getAll());
        req.getRequestDispatcher("admin/tour.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
