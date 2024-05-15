/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.library;

/**
 *
 * @author marcelo
 */
public class BookBR {
    BookDAO bookDAO = new BookDAO();
    public void RegisterBook(Book book) {
        book.setID(1);
        bookDAO.ConnectBook(book);
    }
}
