/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.library;

import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author marce
 */
public class EmployeeDAO {

    private String myDriver = "com.mysql.cj.jdbc.Driver";
    private String myUrl = "jdbc:mysql://localhost:3306/library";

    public Employee getLogin(String username, String password) {
        String sql = "SELECT email,password FROM employee WHERE email = ? AND password = ?";
        Employee emp = new Employee();
        try {
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                rs.first();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                emp.setPassword(rs.getString("password"));
                return emp;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Connection database error!");
            System.err.println(e.getMessage());
        }
        return null;

    }
}
