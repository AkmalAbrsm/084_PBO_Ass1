/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

/**
 *
 * @author HP
 */
public class SepatuRunning extends Sepatu implements Kenyamanan{
    
     private String plate;
    
     public SepatuRunning(int harga, String merk, int ukuran, String jenis, String plate){
        super(harga, merk, ukuran, jenis);
        this.plate = plate;
    }
     @Override
     public void getInfoSepatu(){
        System.out.println("Sepatu Running");
        super.getInfoSepatu();
        System.out.println("Plate : " + plate);
     }
     
    
    @Override
    public void felksibilitas(){
        System.out.println("Fleksibilitas : Sangat lentur");
    }
    
    
    @Override
    public void keempukan(){
        System.out.println("Keempukan : Cukup Empuk");
    }
}
