/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author HP
 */
public class LargeRoom extends Room {
    public LargeRoom() {
        super("Large Room", 100);
    }

    @Override
    public int calculatePrice(int nights) {
        return pricePerNight * nights;
    }
}