/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Kucing.*;
import View.Kucing.View;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Lab Informatika
 */
public class ControllerKucing {
    private View view;
    private InterfaceDAO dao;
    private list<ModelKucing> daftarKucing;
    
    public ControllerKucing(View view){
        this.view = view;
        this.dao = new DAOKucing();
        loadTable();
        
        view.getAddButton().addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            insertKucing();
        }
    });
        
    view.getClearButton().addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            view.clearFields();
        }
    });
    
    view.getDeleteButton().addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            deleteKucing();
        }
    });
    
    view.getUpdateButton().addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            updateKucing();
        }
    });
    
    view.getTable().addMouseListener(new java.awt.event.MouseAdapter(){
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt){
            int row = view.getTable().getSelectedRow();
            if(row != -1){
                view.setPemilik(view.getTable().getValueAt(row,1).toString());
                view.setNama(view.getTable().getValueAt(row,2).toString());
                view.setNomor(view.getTable().getValueAt(row,3).toString());
                view.setDurasi(view.getTable().getValueAt(row,4).toString());
                view.setBiaya(view.getTable().getValueAt(row,5).toString());
            }
        }
    });
    }
    
    private void loadTable(){
        daftarKucing = dao.getAll();
        ModelTable modelTable = new ModelTable(daftarKucing);
        view.getTable().setModel(modelTable);
    }
    
    private void updateKucing(){
        int confirm = JOptionPane.showConfirmDialog(view,"Update Data?", "Konfirmasi Update",JOptionPane.YES_NO_OPTION);
        
        if(confirm == JOptionPane.YES_OPTION){
            int selectedRow = view.getTable().getSelectedRow();
            if(selectedRow != -1){
                try{
                    int id = (int)view.getTable().getValueAt(selectedRow,0);
                    
                    ModelKucing kucing = new ModelKucing();
                    kucing.setId(id);
                    kucing.setPemilik(view.getPemilik());
                    kucing.setNama(view.getNama());
                    kucing.setNomor(view.getNomor());
                    kucing.setDurasi(Double.parseDouble(view.getDurasi()));
                    
                    double durasiValue = Double.parseDouble(view.getDurasi());
                    
                    if(durasiValue < 0 ){
                        JOptionPane.showMessageDialog(view,"Durasi Tidak boleh kurang dari 0");
                        return;
                    }
                    
                    double biaya = (kucing.getDurasi()) * 40000;
                    kucing.setBiaya(biaya);
                    
                    dao.Update(kucing);
                    loadTable();
                    view.clearFields();
                    System.out.println("Update Berhasil");
                } catch (NumberFormatException e){
                    System.out.println("Format Angka Salah:" + e.getMessage());
                    JOptionPane.showMessageDialog(view, "Input Durasi Harus Berupa Angka", "Format Salah", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Pilih Baris pada Tabel untuk Update");
            }
        }
    }
    
    private void insertKucing(){
        try{
            ModelKucing kucing = new ModelKucing();
            kucing.setPemilik(view.getPemilik());
            kucing.setNama(view.getNama());
            kucing.setNomor(view.getNomor());
            kucing.setDurasi(Double.parseDouble(view.getDurasi()));
            
            double durasiValue = Double.parseDouble(view.getDurasi());
            
            if(durasiValue < 0){
                JOptionPane.showMessageDialog(view, "Durasi tidak boleh Minus");
                return;
            }
            
            double biayaValue = (durasiValue) * 40000;
            kucing.setBiaya(biayaValue);
            
            dao.insert(kucing);
            loadTable;
            view.clearFields();
        }catch (NumberFormatException ex){
            System.out.println("format Input salah : " + ex.getMessage());
            JOptionPane.showMessageDialog(view, "Durasi Harus berupa Angka", "Format Salah", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void deleteKucing(){
        int confirm = JOptionPane.showConfirmDialog(view, "Hapus Data ini?", "Konfrimasi Update", JOptionPane.YES_NO_OPTION);
        int row = view.getTable().getSelectedRow();
        if(row != 1){
            int id = (int) view.getTable().getValueAt(row,0);
            dao.delete(id);
            loadTable();
        }else{
            System.out.println("Pilih baris Dulu");
        }
    }
}
