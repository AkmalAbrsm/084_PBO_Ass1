/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import Controller.ControllerKucing;
import View.Kucing.View;

/**
 *
 * @author Lab Informatika
 */
public class Main {
    public static void main(String[] args){
        View view = new View();
        ControllerKucing controller = new ControllerKucing(view);
        view.setVisible(true);
    }
}
