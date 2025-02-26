/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

/**
 *
 * @author HP
 */
public class SepatuWalkOn extends Sepatu implements Kenyamanan{
    
    private String laces;
    
    public SepatuWalkOn(int harga, String merk, int ukuran, String jenis, String laces){
        super(harga, merk, ukuran, jenis);
        this.laces = laces;
    }
    
    @Override
    public void getInfoSepatu(){
        System.out.println("Sepatu Walk-On");
        super.getInfoSepatu();
        System.out.println("Laces : " +laces);
     }
    
    
    @Override
    public void felksibilitas(){
        System.out.println("Fleksibilitas : Lentur");
    }
    
    
    @Override
    public void keempukan(){
        System.out.println("Keempukan : Sangat Empuk");
    }
}
