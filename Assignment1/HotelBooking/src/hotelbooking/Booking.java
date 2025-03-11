/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author HP
 */
public class Booking implements BookingProcess {
    private String name, gender;
    private int guests, nights;
    private Room room;

    public Booking(String name, String gender, int guests, int nights, Room room) {
        this.name = name;
        this.gender = gender;
        this.guests = guests;
        this.nights = nights;
        this.room = room;
    }

    @Override
    public void displayBookingDetails() {
        int totalPrice = room.calculatePrice(nights);
        System.out.println("=== Booking Details ===");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Guests: " + guests);
        System.out.println("Nights: " + nights);
        System.out.println("Room Type: " + room.getType());
        System.out.println("Total Price: $" + totalPrice);
    }

    public String getDetails() {
        return "<html>Name: " + name + "<br>Gender: " + gender + "<br>Guests: " + guests +
               "<br>Nights: " + nights + "<br>Room Type: " + room.getType() + 
               "<br>Total Price: $" + room.calculatePrice(nights) + "</html>";
    }
}
