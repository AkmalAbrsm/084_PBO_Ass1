/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author HP
 */
public class SmallRoom extends Room {
    public SmallRoom() {
        super("Small Room", 50);
    }

    @Override
    public int calculatePrice(int nights) {
        return pricePerNight * nights;
    }
}
