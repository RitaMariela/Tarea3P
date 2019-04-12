/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import funtion.Graphic2;
import funtion.Graphic1;
import javafx.application.Application;
import funtion.Graphic3;
//import Obras.ventana2;
import java.awt.Color;
import javax.swing.JFrame;
/**
 *
 * @author sebas
 */
public class Tarea2P {
    
    funtion.Graphic1 ln= new Graphic1();
    
    funtion.Graphic3 vn= new Graphic3();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
       
        
    
        Application.launch(Graphic3.class, args);
        JFrame window = new JFrame("Grafico 1");
        window.setContentPane(new Graphic1());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.pack();
        
        window.setResizable(false);
        window.setLocation(500, 100);
        window.getContentPane().setBackground(Color.BLACK);
        window.setVisible(true);
    }
    }
    

