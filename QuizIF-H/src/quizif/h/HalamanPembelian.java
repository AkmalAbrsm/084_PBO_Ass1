/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizif.h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Lab Informatika
 */
public class HalamanPembelian extends JFrame implements ActionListener{
    String Username;
    String namaFilm, hargaFilm;
    
    float hargaFilm1, ppn, hargaPpn;
    JLabel title = new JLabel("Booking Page");
    JLabel title2 = new JLabel("Total Price");
    JLabel kategoriFilm;
    JLabel jumlahFilm = new JLabel("Many Tickets");
    JLabel labelHarga;
    JLabel labelSatuan;
    JButton beli = new JButton("Buy");
    JButton kembali = new JButton("Back");
    JTextField jumlah = new JTextField();
    JLabel jumlahFilm2;
    JLabel ppnLabel;
    JLabel hargaPpnLabel;
    
    HalamanPembelian(String namaFilm, String hargaFilm, float hargaFilm1, String username){
        this.Username = username;
        this.namaFilm = namaFilm;
        this.hargaFilm = hargaFilm;
        this.hargaFilm1 = hargaFilm1;
        
        kategoriFilm = new JLabel("Movie Selection " +this.namaFilm);
        labelHarga = new JLabel("Price " + "Rp" + this.hargaFilm + " / Tickets");
        labelSatuan = new JLabel("Price each Ticket " + "Rp" + this.hargaFilm);
        jumlahFilm2 = new JLabel("Many " + 0 + " Tickets");
        ppnLabel = new JLabel("Tax (10%) Rp" + String.format("%.3f", (10.0 * this.hargaFilm1 / 100)));
        hargaPpnLabel = new JLabel("Total Price Rp" + 0);
        
        setVisible(true);
        setSize(720, 480);
        setTitle("Booking Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        add(title);
        add(kategoriFilm);
        add(labelHarga);
        add(jumlahFilm);
        add(jumlah);
        add(beli);
        add(title2);
        add(labelSatuan);
        add(jumlahFilm2);
        add(ppnLabel);
        add(hargaPpnLabel);
        add(kembali);
        
        title.setBounds(20, 20, 150, 24);
        kategoriFilm.setBounds(20, 50, 200, 24);
        labelHarga.setBounds(20, 80, 150, 24);
        jumlahFilm.setBounds(20, 110, 150, 24);
        jumlah.setBounds(105, 110, 140, 24);
        beli.setBounds(20, 140, 226, 24);
        /*title2.setBounds(20, 170, 150, 24);
        labelSatuan.setBounds(20, 200, 180, 24);
        jumlahFilm2.setBounds(20, 230, 180, 24);
        ppnLabel.setBounds(20, 260, 180, 24);
        hargaPpnLabel.setBounds(20, 290, 180, 24);
        kembali.setBounds(20, 320, 226, 24);*/
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            if(e.getSource() == beli){
                int jumlah = Integer.parseInt(this.jumlah.getText());
                if(jumlah < 0) {
                    JOptionPane.showMessageDialog(this, "Ticket Cant be Negative!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                jumlahFilm2.setText("Many Ticket " + jumlah);
                hargaPpnLabel.setText("Total Price Rp" + String.format("%.3f", this.hargaFilm1 * jumlah + (11.0 * (this.hargaFilm1 * jumlah) / 100)));
            }
            else if(e.getSource() == kembali) {
                new HomePage(this.Username);
                dispose();
            }    
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Input the Right Number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
