//package org.example.web_app.service;
//
//import org.example.web_app.model.Employee;
//
//import java.util.List;
//
//public class EmployeeService {
//    EmployeeDao employeeDaoDao = new EmployeeDao();
//    public boolean login(String userName, String password) {
//        List<Employee> employeeList = getAllEmployee();
//        for (Employee employee : employeeList) {
//            if (employee.getUserName().equalsIgnoreCase(userName) && PasswordUltis.checkPassword(password, employee.getPassword())) return true;
//        }
//        return false;
//    }
//
//    public void register(String fullName, String userName, String email, String password) {
//        employeeDao.register(fullName, userName, email, password);
//    }
//}
