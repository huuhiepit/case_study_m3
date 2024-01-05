package org.example.web_app.service;

import org.example.web_app.dao.DescriptionTourDAO;
import org.example.web_app.dao.impl.IDescriptionTourDAO;
import org.example.web_app.model.DescriptionTour;
import org.example.web_app.model.en.EStatusTour;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class DescriptionTourService {
    protected IDescriptionTourDAO descriptionTourDAO;

    public DescriptionTourService() {
        descriptionTourDAO = new DescriptionTourDAO();
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        descriptionTourDAO.insertInto(new DescriptionTour(
                LocalDate.parse(req.getParameter("dateStart")),
                LocalDate.parse(req.getParameter("dateEnd")),
                Integer.parseInt(req.getParameter("seat")),
                Long.parseLong(req.getParameter("price")),
                req.getParameter("description"),
                Long.parseLong(req.getParameter("id"))
        ));
        resp.sendRedirect("./manager-description-tour?id=" + req.getParameter("id"));
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        descriptionTourDAO.update(new DescriptionTour(
                Long.parseLong(req.getParameter("idDescriptionTour")),
                LocalDate.parse(req.getParameter("dateStart")),
                LocalDate.parse(req.getParameter("dateEnd")),
                Integer.parseInt(req.getParameter("seat")),
                Long.parseLong(req.getParameter("price")),
                req.getParameter("description")));
        resp.sendRedirect("./manager-description-tour?id=" + req.getParameter("id"));
    }

    public void delete(long idDescriptionTour) {
        descriptionTourDAO.delete(idDescriptionTour);
    }
}
