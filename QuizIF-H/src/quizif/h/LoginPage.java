/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizif.h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Lab Informatika
 */
public class LoginPage extends JFrame implements ActionListener{
    JLabel title = new JLabel("LOGIN");
    JLabel usernameLabel = new JLabel("Username : ");
    JLabel passwordLabel = new JLabel("Password : ");
    
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    
    JButton Login = new JButton("LOGIN");
    
    LoginPage(){
        setVisible(true);
        setSize(720, 480);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setLayout(null);
        
        add(usernameLabel);
        add(passwordLabel);
        add(title);
        add(username);
        add(password);
        add(Login);
        
        title.setBounds(210, 20, 150, 24);
        usernameLabel.setBounds(20, 84, 440, 12);
        passwordLabel.setBounds(20,152, 440, 12);
        
        username.setBounds(18, 100, 440, 32);
        password.setBounds(18, 170, 440, 32);
        
        Login.setBounds(125, 220, 200, 32);
        Login.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == Login){
                String username = this.username.getText();
                char[] passChar = this.password.getPassword();
                String password = new String(passChar);
                
                if(username.equals("user") && password.equals("user")) {
                    new HomePage(username);
                    System.out.println(username);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Username or Password isnt Correct!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception error){
            
        }
    }
}
