/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perpustakaan.controller;

import com.perpustakaan.model.Book;
import com.perpustakaan.model.BookDAO;
import com.perpustakaan.model.BookDAOImpl;
import com.perpustakaan.view.BookView;
import java.util.List;
import javax.swing.JOptionPane;

public class BookController {
    private BookView view;
    private BookDAO model;

    public BookController(BookView view) {
        this.view = view;
        this.model = new BookDAOImpl(); // Inisialisasi model DAO
    }

    public void loadBooks() { // Read operation [cite: 4]
        List<Book> books = model.getAllBooks();
        view.displayBooks(books);
    }

    public void addBook() { // Create operation [cite: 4]
        try {
            String judul = view.getJudulBuku();
            String penulis = view.getPenulis();
            int tahun = Integer.parseInt(view.getTahunTerbit());
            double alur = Double.parseDouble(view.getAlurCerita());
            double bahasa = Double.parseDouble(view.getGayaBahasa());
            double orisinalitas = Double.parseDouble(view.getOrisinalitas());

            // Validasi nilai 0-5
            if (alur < 0 || alur > 5 || bahasa < 0 || bahasa > 5 || orisinalitas < 0 || orisinalitas > 5) {
                view.showMessage("Nilai Alur Cerita, Gaya Bahasa, dan Orisinalitas harus antara 0 dan 5.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Book book = new Book(judul, penulis, tahun, alur, bahasa, orisinalitas);
            model.addBook(book);
            view.showMessage("Data Buku Berhasil Ditambahkan", "Sukses", JOptionPane.INFORMATION_MESSAGE); // [cite: 1]
            view.clearFields();
            loadBooks(); // Muat ulang data setelah penambahan
        } catch (NumberFormatException e) {
            view.showMessage("Pastikan input Tahun Terbit, Alur Cerita, Gaya Bahasa, dan Orisinalitas adalah angka.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateBook() { // Update operation [cite: 4]
        int selectedRow = view.tblBooks.getSelectedRow();
        if (selectedRow == -1) {
            view.showMessage("Pilih buku yang ingin diupdate dari tabel.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Ambil ID dari tabel (kolom pertama)
            int bookId = (int) view.tblBooks.getValueAt(selectedRow, 0);

            String judul = view.getJudulBuku();
            String penulis = view.getPenulis();
            int tahun = Integer.parseInt(view.getTahunTerbit());
            double alur = Double.parseDouble(view.getAlurCerita());
            double bahasa = Double.parseDouble(view.getGayaBahasa());
            double orisinalitas = Double.parseDouble(view.getOrisinalitas());

            // Validasi nilai 0-5
            if (alur < 0 || alur > 5 || bahasa < 0 || bahasa > 5 || orisinalitas < 0 || orisinalitas > 5) {
                view.showMessage("Nilai Alur Cerita, Gaya Bahasa, dan Orisinalitas harus antara 0 dan 5.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Book book = new Book(judul, penulis, tahun, alur, bahasa, orisinalitas);
            book.setId(bookId); // Set ID untuk update
            model.updateBook(book);
            view.showMessage("Data Buku Berhasil Diupdate", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            view.clearFields();
            loadBooks(); // Muat ulang data setelah update
        } catch (NumberFormatException e) {
            view.showMessage("Pastikan input Tahun Terbit, Alur Cerita, Gaya Bahasa, dan Orisinalitas adalah angka.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteBook() { // Delete operation [cite: 4]
        int selectedRow = view.tblBooks.getSelectedRow();
        if (selectedRow == -1) {
            view.showMessage("Pilih buku yang ingin dihapus dari tabel.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(view, "Apakah Anda yakin ingin menghapus buku ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int bookId = (int) view.tblBooks.getValueAt(selectedRow, 0); // Ambil ID buku dari tabel
            model.deleteBook(bookId);
            view.showMessage("Data Buku Berhasil Dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            view.clearFields();
            loadBooks(); // Muat ulang data setelah penghapusan
        }
    }
}