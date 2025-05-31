/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perpustakaan.model;

import com.perpustakaan.util.DatabaseConnection; // Import kelas koneksi
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public void addBook(Book book) { // Create [cite: 4]
        String sql = "INSERT INTO books (judul_buku, penulis, tahun_terbit, nilai_alur_cerita, nilai_gaya_bahasa, nilai_orisinalitas, nilai_rating) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getJudulBuku());
            pstmt.setString(2, book.getPenulis());
            pstmt.setInt(3, book.getTahunTerbit());
            pstmt.setDouble(4, book.getNilaiAlurCerita());
            pstmt.setDouble(5, book.getNilaiGayaBahasa());
            pstmt.setDouble(6, book.getNilaiOrisinalitas());
            pstmt.setDouble(7, book.getNilaiRating()); // Rating sudah dihitung di objek Book
            pstmt.executeUpdate();
            System.out.println("Buku berhasil ditambahkan: " + book.getJudulBuku());
        } catch (SQLException e) {
            System.err.println("Gagal menambahkan buku: " + e.getMessage());
        }
    }

    @Override
    public List<Book> getAllBooks() { // Read [cite: 4]
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setJudulBuku(rs.getString("judul_buku"));
                book.setPenulis(rs.getString("penulis"));
                book.setTahunTerbit(rs.getInt("tahun_terbit"));
                book.setNilaiAlurCerita(rs.getDouble("nilai_alur_cerita"));
                book.setNilaiGayaBahasa(rs.getDouble("nilai_gaya_bahasa"));
                book.setNilaiOrisinalitas(rs.getDouble("nilai_orisinalitas"));
                book.setNilaiRating(rs.getDouble("nilai_rating")); // Set langsung dari DB
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println("Gagal mendapatkan semua buku: " + e.getMessage());
        }
        return books;
    }

    @Override
    public void updateBook(Book book) { // Update [cite: 4]
        String sql = "UPDATE books SET judul_buku=?, penulis=?, tahun_terbit=?, nilai_alur_cerita=?, nilai_gaya_bahasa=?, nilai_orisinalitas=?, nilai_rating=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getJudulBuku());
            pstmt.setString(2, book.getPenulis());
            pstmt.setInt(3, book.getTahunTerbit());
            pstmt.setDouble(4, book.getNilaiAlurCerita());
            pstmt.setDouble(5, book.getNilaiGayaBahasa());
            pstmt.setDouble(6, book.getNilaiOrisinalitas());
            pstmt.setDouble(7, book.getNilaiRating());
            pstmt.setInt(8, book.getId());
            pstmt.executeUpdate();
            System.out.println("Buku berhasil diupdate: " + book.getJudulBuku());
        } catch (SQLException e) {
            System.err.println("Gagal mengupdate buku: " + e.getMessage());
        }
    }

    @Override
    public void deleteBook(int id) { // Delete [cite: 4]
        String sql = "DELETE FROM books WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Buku berhasil dihapus dengan ID: " + id);
        } catch (SQLException e) {
            System.err.println("Gagal menghapus buku: " + e.getMessage());
        }
    }
}
