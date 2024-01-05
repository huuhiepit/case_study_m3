package org.example.web_app.controller;

import org.example.web_app.model.Employee;
import org.example.web_app.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private EmployeeService employeeService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       if (action == null) {
           action = "";
       }
       switch (action){
           case "logout":
              logout(req, resp);
              break;
           case "register":
               register(req, resp);
               break;
           default:
               showLogin(req,resp);
       }
    }

//    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    }

    private void showLogin(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession session = req.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee !=null){
            if(employee.getRole().role.equalsIgnoreCase("Admin")){
                resp.sendRedirect("/admin");
            }else if(employee.getRole().role.equalsIgnoreCase("Nhân viên")){
                req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
            }else req.getRequestDispatcher("/admin").forward(req,resp);
        }else req.getRequestDispatcher("admin/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "login":
                login(req, resp);
                break;
            case "register":
                register(req, resp);
                break;
        }
    }
    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address =req.getParameter("address");
        String email =req.getParameter("email");
        String username =req.getParameter("username");
        String password =req.getParameter("password");
        employeeService.register( name, phone, address, email, username, password);
        resp.sendRedirect("/login");
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        if(employeeService.login(userName, password)){
            String employeeRole = employeeService.getEmployeeByName(userName).getRole().role;
            HttpSession session = req.getSession();
            session.setAttribute("account", employeeService.getEmployeeByName(userName));
            if(employeeRole.equalsIgnoreCase("Customer")){
                resp.sendRedirect("/main?message=Login Successfull");
            }else  resp.sendRedirect("/total?message=Login Successfull");
        } else resp.sendRedirect("/login?message=Password or username is invalid");
    }
    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeService();
    }
}
