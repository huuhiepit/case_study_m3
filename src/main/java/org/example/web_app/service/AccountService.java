package org.example.web_app.service;

import org.example.web_app.dao.AccountDAO;
import org.example.web_app.dao.EmployeeDAO;
import org.example.web_app.model.Account;
import org.example.web_app.model.Employee;
import org.example.web_app.util.PasswordEncryptionUtil;

import java.util.List;

public class AccountService {
    AccountDAO accountDao = new AccountDAO();
    EmployeeDAO employeeDao = new EmployeeDAO();

    public List<Account> getAllAccount() {
        return accountDao.getAllAccount();
    }
    
    public boolean login(String userName, String password) {
        List<Account> accountList = getAllAccount();
        for (Account account : accountList) {
            if (account.getUserName().equalsIgnoreCase(userName) && PasswordEncryptionUtil.checkPassword(password, account.getPassword())) return true;
        }
        return false;
    }

    public void register(String name, String phone, String address, String email ,String username,String password) {
        accountDao.register(name, phone, address,email,username, password);
    }
}
