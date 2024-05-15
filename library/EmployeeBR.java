/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.library;

/**
 *
 * @author marce
 */
public class EmployeeBR {
    private Employee emp = new Employee();
    private EmployeeDAO empDAO = new EmployeeDAO();
    public boolean validationLogin(String username, String password){
        emp = empDAO.getLogin(username, password);
        if (emp.getEmail().equals(username) && emp.getPassword().equals(password)) {
                    return true;
                }else{
                    return false;
                }
    }
}
