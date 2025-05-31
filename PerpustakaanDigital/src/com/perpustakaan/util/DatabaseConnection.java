/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perpustakaan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library_db"; // Nama database [cite: 5]
    private static final String USER = "root"; // Username MySQL XAMPP default
    private static final String PASSWORD = ""; // Password MySQL XAMPP default (kosong)

    public static Connection getConnection() throws SQLException {
        try {
            // Memuat driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver tidak ditemukan: " + e.getMessage());
        }
    }
}
