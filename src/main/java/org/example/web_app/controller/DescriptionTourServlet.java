package org.example.web_app.controller;

import org.example.web_app.dao.DescriptionTourDAO;
import org.example.web_app.dao.TourDAO;
import org.example.web_app.dao.impl.IDescriptionTourDAO;
import org.example.web_app.dao.impl.ITourDAO;
import org.example.web_app.service.DescriptionTourService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "descriptionTourServlet", urlPatterns = "/manager-description-tour")
public class DescriptionTourServlet extends HttpServlet {
    protected IDescriptionTourDAO descriptionTourDAO;
    protected ITourDAO tourDAO;
    protected DescriptionTourService descriptionTourService;
    @Override
    public void init() throws ServletException {
        descriptionTourDAO = new DescriptionTourDAO();
        tourDAO = new TourDAO();
        descriptionTourService = new DescriptionTourService();
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
                deleteDescription(req, resp);
                break;
            }
            case "": {
                showAllDescription(req, resp);
                break;
            }
        }
    }

    private void deleteDescription(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        descriptionTourService.delete(Long.parseLong(req.getParameter("idDescriptionTour")));
        resp.sendRedirect("./manager-description-tour?id=" + req.getParameter("id"));
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("descriptionTour", descriptionTourDAO.getBy(Long.parseLong(req.getParameter("idDescriptionTour"))));
        req.setAttribute("tour", tourDAO.getBy(Long.parseLong(req.getParameter("id"))));
        req.getRequestDispatcher("admin/add_description.jsp").forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tour", tourDAO.getBy(Long.parseLong(req.getParameter("id"))));
        req.getRequestDispatcher("admin/add_description.jsp").forward(req, resp);
    }

    private void showAllDescription(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tour", tourDAO.getBy(Long.parseLong(req.getParameter("id"))));
        req.setAttribute("descriptionTourList", descriptionTourDAO.getAll(Long.parseLong(req.getParameter("id"))));
        req.getRequestDispatcher("admin/description_tour.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action) {
            case "create": {
                descriptionTourService.add(req, resp);
                break;
            }
            case "edit": {
                descriptionTourService.update(req, resp);
                break;
            }
        }
    }
}
