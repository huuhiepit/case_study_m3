package org.example.web_app.service;

import org.example.web_app.dao.AuthDAO;
import org.example.web_app.model.Account;
import org.example.web_app.model.en.ERole;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthService {
    protected AuthDAO authDAO;
    public AuthService() {
        authDAO = new AuthDAO();
    }

    public void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = "";
        if(req.getParameter("username") == null) {
            error += "Vui lòng nhập tên tài khoản. ";
        }
        if(req.getParameter("password") == null) {
            error += "Vui lòng nhập mật khẩu.";
        }
        Account account = authDAO.checkLogin(req.getParameter("username"), req.getParameter("password"));
        if(account == null) {
            error += "Tài khoản mật khẩu sai. Vui lòng nhập lại.";
        }
        if(!error.isEmpty()) {
            req.setAttribute("error", error);
            req.getRequestDispatcher("admin/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession(true);
            if(account.getRole() == ERole.ADMIN || account.getRole() == ERole.EMPLOYEE) {
                session.setAttribute("account", account);
                resp.sendRedirect("/manager-tour");
            }
            if(account.getRole() == ERole.CUSTOMER) {
                session.setAttribute("accountCustomer", account);
                resp.sendRedirect("/customer");
            }
        }

    }

    public void registerAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String customerName,
//        String customerPhone,
//        String customerAddress,
//        String customerEmail,
//        String accountUsername,
//        String accountPassword

        authDAO.register(
                req.getParameter("name"),
                req.getParameter("phone"),
                req.getParameter("address"),
                req.getParameter("email"),
                req.getParameter("username"),
                req.getParameter("password")
        );
        resp.sendRedirect("/auth");
    }
}
