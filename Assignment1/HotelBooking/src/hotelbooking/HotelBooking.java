/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelbooking;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;

public class HotelBooking extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel;
    private JTextField usernameField, nameField, stayField;
    private JPasswordField passwordField;
    private JRadioButton maleButton, femaleButton, smallRoom, largeRoom;
    private JComboBox<String> guestsDropdown;

    public HotelBooking() {
        setTitle("Hotel Room Booking");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(cardLayout);
        add(mainPanel);

        createLoginPage();
        createMainMenuPage();
        createBookingPage();

        setVisible(true);
    }

    private void createLoginPage() {
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginPanel.add(new JLabel("Username: "));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password: "));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("adm") && password.equals("adm")) {
                cardLayout.show(mainPanel, "MainMenu");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        });

        mainPanel.add(loginPanel, "Login");
    }

    private void createMainMenuPage() {
        JPanel menuPanel = new JPanel(new GridLayout(3, 1));
        smallRoom = new JRadioButton("Small Room - $50 per night");
        largeRoom = new JRadioButton("Large Room - $100 per night");
        ButtonGroup group = new ButtonGroup();
        group.add(smallRoom);
        group.add(largeRoom);
        JButton nextButton = new JButton("Next");

        menuPanel.add(smallRoom);
        menuPanel.add(largeRoom);
        menuPanel.add(nextButton);

        nextButton.addActionListener(e -> cardLayout.show(mainPanel, "Booking"));

        mainPanel.add(menuPanel, "MainMenu");
    }

    private void createBookingPage() {
        JPanel bookingPanel = new JPanel(new GridLayout(6, 2));
        nameField = new JTextField();
        stayField = new JTextField();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        String[] guests = {"1", "2", "3", "4"};
        guestsDropdown = new JComboBox<>(guests);
        JButton bookButton = new JButton("Book");

        bookingPanel.add(new JLabel("Name: "));
        bookingPanel.add(nameField);
        bookingPanel.add(new JLabel("Gender: "));
        bookingPanel.add(maleButton);
        bookingPanel.add(femaleButton);
        bookingPanel.add(new JLabel("Guests: "));
        bookingPanel.add(guestsDropdown);
        bookingPanel.add(new JLabel("Nights: "));
        bookingPanel.add(stayField);
        bookingPanel.add(bookButton);

        bookButton.addActionListener(e -> processBooking());

        mainPanel.add(bookingPanel, "Booking");
    }

    private void processBooking() {
        String name = nameField.getText();
        String gender = maleButton.isSelected() ? "Male" : "Female";
        int guests = Integer.parseInt((String) guestsDropdown.getSelectedItem());
        int nights = Integer.parseInt(stayField.getText());

        Room room = smallRoom.isSelected() ? new SmallRoom() : new LargeRoom();
        Booking booking = new Booking(name, gender, guests, nights, room);

        JOptionPane.showMessageDialog(this, booking.getDetails(), "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new HotelBooking();
    }
}
