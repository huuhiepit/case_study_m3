package org.example.web_app.service;

import org.example.web_app.dao.EmployeeDAO;
import org.example.web_app.dao.TourDAO;
import org.example.web_app.dao.impl.IEmployeeDAO;
import org.example.web_app.dao.impl.ITourDAO;
import org.example.web_app.model.Employee;
import org.example.web_app.model.Tour;
import org.example.web_app.model.en.EType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeService {
    protected IEmployeeDAO employeeDAO;
    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }
    public void remove(HttpServletRequest req) {
        employeeDAO.delete(Long.parseLong(req.getParameter("id")));
    }
    public void create(HttpServletRequest rq, HttpServletResponse resp) throws ServletException, IOException {
        String name = rq.getParameter("name");
        if(rq.getParameter("name").isEmpty()) {
            rq.setAttribute("error", "Vui lòng nhập tên");
//            rq.setAttribute("typeList", EType.values());
            rq.getRequestDispatcher("admin/add_employee.jsp").forward(rq, resp);
        }

        employeeDAO.add(new Employee(rq.getParameter("name"),
                rq.getParameter("phone"),
                rq.getParameter("address")));
    }

    public void update(HttpServletRequest req) {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");

        employeeDAO.update(new Employee(Long.parseLong(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("phone"),
                req.getParameter("address"),
                req.getParameter("username"),
                req.getParameter("urlImage")));
    }
}
