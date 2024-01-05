package org.example.web_app.service;

import org.example.web_app.dao.TourDAO;
import org.example.web_app.dao.impl.ITourDAO;
import org.example.web_app.model.Tour;
import org.example.web_app.model.en.ERole;
import org.example.web_app.model.en.EType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TourService {
    protected ITourDAO tourDAO;
    public TourService() {
        tourDAO = new TourDAO();
    }
    public void create(HttpServletRequest rq, HttpServletResponse resp) throws ServletException, IOException {
        String name = rq.getParameter("name");
        if(rq.getParameter("name").isEmpty()) {
            rq.setAttribute("error", "Vui lòng nhập tên tour");
            rq.setAttribute("typeList", EType.values());
            rq.getRequestDispatcher("admin/add_tour.jsp").forward(rq, resp);
        }

        tourDAO.add(new Tour(rq.getParameter("name"),
                rq.getParameter("urlImage"),
                EType.valueOf(rq.getParameter("type"))));
    }

    public void update(HttpServletRequest req) {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");

        tourDAO.update(new Tour(Long.parseLong(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("urlImage"),
                EType.valueOf(req.getParameter("type"))));
    }

    public void remove(HttpServletRequest req) {
        tourDAO.delete(Long.parseLong(req.getParameter("id")));
    }
}
