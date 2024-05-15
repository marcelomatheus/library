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
public class BookDAO {
    private String myDriver = "com.mysql.cj.jdbc.Driver";
    private String myUrl = "jdbc:mysql://localhost:3306/library";
    public void ConnectBook(Book book) {
    try {
            // create a mysql database connection
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            // create a sql date object so we can use it in our INSERT statement
            // the mysql insert statement
            String query = "INSERT INTO book(Name,Publisher,Author)"+ " VALUES(?,?,?)";
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, book.getName());
            preparedStmt.setString(2, book.getPublisher());
            preparedStmt.setString(3, book.getAuthor());
            // execute the preparedstatement
            preparedStmt.execute();
            conn.close();
        }
        catch(
        Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }    
}

