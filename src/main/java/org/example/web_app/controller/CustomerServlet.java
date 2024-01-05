//package org.example.web_app.controller;
//
//import org.example.web_app.dao.CustomerDAO;
//import org.example.web_app.dao.EmployeeDAO;
//import org.example.web_app.dao.impl.ICustomerDAO;
//import org.example.web_app.dao.impl.IEmployeeDAO;
//import org.example.web_app.model.Customer;
//import org.example.web_app.model.Employee;
//import org.example.web_app.service.CustomerService;
//import org.example.web_app.service.EmployeeService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "customerServlet", urlPatterns = "/manager-customer")
//public class CustomerServlet extends HttpServlet {
//    protected ICustomerDAO customerDAO;
//    protected CustomerService customerService;
//    @Override
//    public void init() throws ServletException {
//        customerDAO = new CustomerDAO();
//        customerService = new CustomerService();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        String action = req.getParameter("action");
//        if(action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create": {
//                showAddForm(req, resp);
//                break;
//            }
//            case "edit": {
//                showEditForm(req, resp);
//                break;
//            }
//            case "delete": {
//                delete(req, resp);
//                break;
//            }
//            case "": {
//                showAllCustomer(req, resp);
//                break;
//            }
//        }
//    }
//
//    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("admin/add_customer.jsp").forward(req, resp);
//    }
//
//
//
//    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        customerService.remove(req);
//        resp.sendRedirect("/manager-customer");
//    }
//
//    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Customer c = customerDAO.getBy(Long.parseLong(req.getParameter("id")));
//        req.setAttribute("customer", customerDAO.getBy(Long.parseLong(req.getParameter("id"))));
//        req.getRequestDispatcher("admin/add_customer.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        String action = req.getParameter("action");
//        if(action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create": {
//                insertCustomer(req, resp);
//                break;
//            }
//            case "edit": {
//                updateCustomer(req, resp);
//                break;
//            }
//        }
//    }
//
//    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        customerService.update(req);
//        resp.sendRedirect("/manager-customer");
//    }
//
//    private void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        customerService.create(req, resp);
//        resp.sendRedirect("/manager-customer");
//    }
//
////    private void updateTour(HttpServletRequest req, HttpServletResponse resp) throws IOException {
////        tourService.update(req);
////        resp.sendRedirect("/manager-tour");
////    }
////
////    private void insertTour(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
////        tourService.create(req, resp);
////        resp.sendRedirect("/manager-tour");
////    }
//
//    private void showAllCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("customerList", customerDAO.getAll());
//        req.getRequestDispatcher("admin/customer.jsp").forward(req, resp);
//    }
//
////    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        req.setAttribute("typeList", EType.values());
////        req.getRequestDispatcher("admin/add_tour.jsp").forward(req, resp);
////    }
//}
