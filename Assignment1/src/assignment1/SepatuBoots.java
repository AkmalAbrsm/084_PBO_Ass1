/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

/**
 *
 * @author HP
 */
public class SepatuBoots extends Sepatu implements Kenyamanan{
    
    private String upper;
    
    public SepatuBoots(int harga, String merk, int ukuran, String jenis, String upper){
        super(harga, merk, ukuran, jenis);
        this.upper = upper;
    }
    
    @Override
    public void getInfoSepatu() {
        System.out.println("Sepatu Boots");
        super.getInfoSepatu();
        System.out.println("Upper : " + upper);
    }
    
    
    @Override
    public void felksibilitas(){
        System.out.println("Fleksibilitas : Kaku");
    }
    
    
    @Override
    public void keempukan(){
        System.out.println("Keempukan : Keras");
    }
}
