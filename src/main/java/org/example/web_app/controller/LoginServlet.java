package org.example.web_app.controller;

import org.example.web_app.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
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

    private void showLogin(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession session = req.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee !=null){
            if(employee.getRole().getRoleName().equalsIgnoreCase("Admin")){
                resp.sendRedirect("/admin?action=Manager");
            }else if(employee.getRole().getRoleName().equalsIgnoreCase("Employee")){
                req.getRequestDispatcher("/user/staff/productTotal.jsp").forward(req, resp);
            }else req.getRequestDispatcher("/user/client_undefine/shopping.jsp").forward(req,resp);
        }else req.getRequestDispatcher("login/login.jsp").forward(req, resp);
    }
        }
    }

//    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("login/register.jsp").forward(req, resp);
//    }
//
//    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.invalidate();
//        req.getRequestDispatcher("login/login.jsp").forward(req, resp);
//    }

}
