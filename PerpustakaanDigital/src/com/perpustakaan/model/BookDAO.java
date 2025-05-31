/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perpustakaan.model;

import java.util.List;

public interface BookDAO {
    void addBook(Book book); // Create [cite: 4]
    List<Book> getAllBooks(); // Read [cite: 4]
    void updateBook(Book book); // Update [cite: 4]
    void deleteBook(int id); // Delete [cite: 4]
}