/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perpustakaan.model;

public class Book {
    private int id; // ID buku, biasanya auto-increment di DB
    private String judulBuku; // Judul Buku
    private String penulis; // Penulis
    private int tahunTerbit; // Tahun Terbit
    private double nilaiAlurCerita; // Nilai Alur Cerita (0-5)
    private double nilaiGayaBahasa; // Nilai Gaya Bahasa (0-5)
    private double nilaiOrisinalitas; // Nilai Orisinalitas (0-5)
    private double nilaiRating; // Nilai Rating [cite: 2]

    // Konstruktor
    public Book() {
    }

    public Book(String judulBuku, String penulis, int tahunTerbit,
                double nilaiAlurCerita, double nilaiGayaBahasa, double nilaiOrisinalitas) {
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.nilaiAlurCerita = nilaiAlurCerita;
        this.nilaiGayaBahasa = nilaiGayaBahasa;
        this.nilaiOrisinalitas = nilaiOrisinalitas;
        calculateRating(); // Hitung rating saat objek dibuat [cite: 3]
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public double getNilaiAlurCerita() {
        return nilaiAlurCerita;
    }

    public void setNilaiAlurCerita(double nilaiAlurCerita) {
        this.nilaiAlurCerita = nilaiAlurCerita;
        calculateRating(); // Hitung ulang rating jika nilai berubah
    }

    public double getNilaiGayaBahasa() {
        return nilaiGayaBahasa;
    }

    public void setNilaiGayaBahasa(double nilaiGayaBahasa) {
        this.nilaiGayaBahasa = nilaiGayaBahasa;
        calculateRating(); // Hitung ulang rating jika nilai berubah
    }

    public double getNilaiOrisinalitas() {
        return nilaiOrisinalitas;
    }

    public void setNilaiOrisinalitas(double nilaiOrisinalitas) {
        this.nilaiOrisinalitas = nilaiOrisinalitas;
        calculateRating(); // Hitung ulang rating jika nilai berubah
    }

    public double getNilaiRating() {
        return nilaiRating;
    }
    
    public void setNilaiRating(double nilaiRating) {
        this.nilaiRating = nilaiRating;
    }
    
    // Metode untuk menghitung rating [cite: 3]
    private void calculateRating() {
        this.nilaiRating = (nilaiAlurCerita + nilaiGayaBahasa + nilaiOrisinalitas) / 3.0;
    }
}