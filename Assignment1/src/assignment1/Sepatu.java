/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment1;

/**
 *
 * @author HP
 */
abstract class Sepatu {
    private int harga;
    private String merk;
    private int ukuran;
    private String jenis;
    
    public Sepatu (int harga, String merk, int ukuran, String jenis){
        this.harga = harga;
        this.merk = merk;
        this.ukuran = ukuran;
        this.jenis = jenis;
    }
    
    protected void getInfoSepatu(){
        System.out.println("Merk Sepatu : " + merk );
        System.out.println("Jenis Sepatu : " + jenis);
        System.out.println("Harga : " + harga);
        System.out.println("Ukuran : " + ukuran);
    }
  
    
}
