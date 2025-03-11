/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author HP
 */
public abstract class Room {
    protected String type;
    protected int pricePerNight;

    public Room(String type, int pricePerNight) {
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public String getType() {
        return type;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public abstract int calculatePrice(int nights);
}