/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment1;

/**
 *
 * @author HP
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SepatuBoots Sepatu1 = new SepatuBoots(300, "Portee", 46, "Sepatu Boots", "Kulit Sintesis");
        Sepatu1.getInfoSepatu();
        Sepatu1.felksibilitas();
        Sepatu1.keempukan();
        System.out.println("");
        SepatuRunning Sepatu2 = new SepatuRunning(600, "Ortuseight", 46, "Sepatu Running", "Carbon Plate");
        Sepatu2.getInfoSepatu();
        Sepatu2.felksibilitas();
        Sepatu2.keempukan();
        System.out.println("");
        SepatuWalkOn Sepatu3 = new SepatuWalkOn(800, "Skechers", 46, "Sepatu Walk-On", "No Laces, Slip-On");
        Sepatu3.getInfoSepatu();
        Sepatu3.felksibilitas();
        Sepatu3.keempukan();
    }
    
}
