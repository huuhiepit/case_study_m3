//package org.example.web_app.service;
//
//import org.example.web_app.dao.CustomerDAO;
//import org.example.web_app.dao.impl.ICustomerDAO;
//import org.example.web_app.model.Customer;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class CustomerService {
//    protected ICustomerDAO customerDAO;
//    public CustomerService() {
//        customerDAO = new CustomerDAO();
//    }
//
//    public void remove(HttpServletRequest req) {
//        customerDAO.delete(Long.parseLong(req.getParameter("id")));
//    }
//    public void create(HttpServletRequest rq, HttpServletResponse resp) throws ServletException, IOException {
//        String name = rq.getParameter("name");
//        if(rq.getParameter("name").isEmpty()) {
//            rq.setAttribute("error", "Vui lòng nhập tên");
////            rq.setAttribute("typeList", EType.values());
//            rq.getRequestDispatcher("admin/add_customer.jsp").forward(rq, resp);
//        }
//
//        customerDAO.add(new Customer(rq.getParameter("name"),
//                rq.getParameter("phone"),
//                rq.getParameter("address"),
//                rq.getParameter("email"),
//                rq.getParameter("userName")));
//    }
//
//    public void update(HttpServletRequest req) {
//        long id = Long.parseLong(req.getParameter("id"));
//        String name = req.getParameter("name");
//
//        customerDAO.update(new Customer(Long.parseLong(req.getParameter("id")),
//                req.getParameter("name"),
//                req.getParameter("phone"),
//                req.getParameter("address"),
//                req.getParameter("email"),
//                req.getParameter("username")));
//    }
//}
