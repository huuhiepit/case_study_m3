package org.example.web_app.service;

import org.example.web_app.dao.DescriptionTourDAO;
import org.example.web_app.dao.TourDAO;
import org.example.web_app.dao.impl.IDescriptionTourDAO;
import org.example.web_app.dao.impl.ITourDAO;
import org.example.web_app.model.DescriptionTour;
import org.example.web_app.model.en.EStatusTour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class DescriptionTourService {
    protected IDescriptionTourDAO descriptionTourDAO;
    protected ITourDAO tourDAO;

    public DescriptionTourService() {
        descriptionTourDAO = new DescriptionTourDAO();
        tourDAO = new TourDAO();
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String error = "";
        if(req.getParameter("dateStart").isEmpty() || req.getParameter("dateEnd").isEmpty()) {
            error += "Vui lòng chọn ngày khởi hành và kết thúc. ";
        } else {
            LocalDate dateNow = LocalDate.now();
            LocalDate dateStart = LocalDate.parse(req.getParameter("dateStart"));
            LocalDate dateEnd = LocalDate.parse(req.getParameter("dateEnd"));
            if(dateStart.isBefore(dateNow)) {
                error += "Vui lòng chọn ngày lớn hơn hoặc bằng ngày hiện tại. ";
            }
            if(dateEnd.isBefore(dateStart)) {
                error += "Vui lòng chọn ngày lớn hơn hoặc bằng ngày khởi hành. ";
            }
        }
        if(req.getParameter("seat").isEmpty() || req.getParameter("seat").equals("0")) {
            error += "Vui lòng nhập số chỗ lớn hơn 0. ";
        }
        if(req.getParameter("price").isEmpty() || req.getParameter("price").equals("0")) {
            error += "Vui lòng nhập số chỗ lớn hơn 1000. ";
        }
        if(req.getParameter("description").isEmpty()) {
            error += "Vui lòng nhập mô tả hành trình của tour.";
        }
        if(!error.isEmpty()) {
            req.setAttribute("error", error);
            req.setAttribute("tour", tourDAO.getBy(Long.parseLong(req.getParameter("id"))));
            req.getRequestDispatcher("admin/add_description.jsp").forward(req, resp);
        } else {
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
