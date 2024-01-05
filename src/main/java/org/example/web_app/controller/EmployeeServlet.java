package org.example.web_app.controller;

import org.example.web_app.dao.EmployeeDAO;
import org.example.web_app.dao.impl.IEmployeeDAO;
import org.example.web_app.model.Employee;
import org.example.web_app.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employeeServlet", urlPatterns = "/manager-employee")
public class EmployeeServlet extends HttpServlet {
    protected IEmployeeDAO employeeDAO;
    protected EmployeeService employeeService;
    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAO();
        employeeService = new EmployeeService();
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
                showAllEmployee(req, resp);
                break;
            }
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("admin/add_employee.jsp").forward(req, resp);
    }



    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        employeeService.remove(req);
        resp.sendRedirect("/manager-employee");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee e = employeeDAO.getBy(Long.parseLong(req.getParameter("id")));
        req.setAttribute("employee", employeeDAO.getBy(Long.parseLong(req.getParameter("id"))));
        req.getRequestDispatcher("admin/add_employee.jsp").forward(req, resp);
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
                insertEmployee(req, resp);
                break;
            }
            case "edit": {
                updateEmployee(req, resp);
                break;
            }
        }
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        employeeService.update(req);
        resp.sendRedirect("/manager-employee");
    }

    private void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        employeeService.create(req, resp);
        resp.sendRedirect("/manager-employee");
    }

//    private void updateTour(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        tourService.update(req);
//        resp.sendRedirect("/manager-tour");
//    }
//
//    private void insertTour(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        tourService.create(req, resp);
//        resp.sendRedirect("/manager-tour");
//    }

    private void showAllEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employeeList", employeeDAO.getAll());
        req.getRequestDispatcher("admin/employee.jsp").forward(req, resp);
    }

//    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("typeList", EType.values());
//        req.getRequestDispatcher("admin/add_tour.jsp").forward(req, resp);
//    }
}
