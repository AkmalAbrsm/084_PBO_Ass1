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
public class HomePage extends JFrame implements ActionListener{
    String username;
    JLabel title;
    JLabel ucapan = new JLabel("Choose your Film");
    JButton spgbb = new JButton("SpongeBob");
    JButton fnf = new JButton("Fast n Furious");
    JButton avg = new JButton("The Avengers");
    JButton iman = new JButton("Iron Man");
    
    HomePage(String uname){
        this.username = uname;
        
        setVisible(true);
        setSize(720, 480);
        setTitle("Movie Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLayout(null);
        
        add(spgbb);
        add(fnf);
        add(avg);
        add(iman);
        
        spgbb.setBounds(20, 100, 180, 60);
        fnf.setBounds(200, 100, 180, 60);
        avg.setBounds(20, 200, 180, 60);
        iman.setBounds(200, 200, 180, 60);
        
        spgbb.addActionListener(this);
        fnf.addActionListener(this);
        avg.addActionListener(this);
        iman.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            if(e.getSource() == spgbb){
                new HalamanPembelian("SpongeBob", "25.000", 25.000f, this.username);
                dispose();
            }
            else if(e.getSource() == fnf){
                new HalamanPembelian("Fast n Furious", "45.000", 45.000f, this.username);
                dispose();
            }
            else if(e.getSource() == avg){
                new HalamanPembelian("The Avengers", "45.000", 45.000f, this.username);
                dispose();
            }
            else if(e.getSource() == iman){
                new HalamanPembelian("Iron Man", "45.000", 45.000f, this.username);
                dispose();
            }
        }
        catch (Exception error){
                    
        }
    }
}
