package org.example.web_app.controller;

import org.example.web_app.dao.TourDAO;
import org.example.web_app.dao.impl.ITourDAO;
import org.example.web_app.model.Tour;
import org.example.web_app.model.en.EType;
import org.example.web_app.service.TourService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "tourServlet", urlPatterns = "/manager-tour")
public class TourServlet extends HttpServlet {
    protected ITourDAO tourDAO;
    protected TourService tourService;
    @Override
    public void init() throws ServletException {
        tourDAO = new TourDAO();
        tourService = new TourService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showAddForm(req, resp);
                break;
            }
            case "edit": {
                showEditForm(req, resp);
                break;
            }
            case "delete": {
                delete(req, resp);
                break;
            }
            case "": {
                showAllTour(req, resp);
                break;
            }
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        tourService.remove(req);
        resp.sendRedirect("/manager-tour");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("typeList", EType.values());
        Tour t = tourDAO.getBy(Long.parseLong(req.getParameter("id")));
        req.setAttribute("tour", tourDAO.getBy(Long.parseLong(req.getParameter("id"))));
        req.getRequestDispatcher("admin/add_tour.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                insertTour(req, resp);
                break;
            }
            case "edit": {
                updateTour(req, resp);
                break;
            }
        }
    }

    private void updateTour(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        tourService.update(req);
        resp.sendRedirect("/manager-tour");
    }

    private void insertTour(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        tourService.create(req, resp);
        resp.sendRedirect("/manager-tour");
    }

    private void showAllTour(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tourList", tourDAO.getAll());
        req.getRequestDispatcher("admin/tour.jsp").forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("typeList", EType.values());
        req.getRequestDispatcher("admin/add_tour.jsp").forward(req, resp);
    }
}
