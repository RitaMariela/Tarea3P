/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funtion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphic1 extends JPanel {

    public Graphic1() {
        this.setPreferredSize(new Dimension(600, 600));
    } // constructor

    private void draw(Graphics g) {
        // dibujar los ejes del plano cartesiano
        Random random = new Random(System.currentTimeMillis());
        g.setColor(Color.BLACK);
       
        g.setColor(Color.CYAN);//color de lineas 
        double a, c;
        a = (int) (Math.random() * 480) + 1;
        c = (int) (Math.random() * 380) + 1;
        int n = 1;
        while (n <= 150) {
             
            a = (int) (Math.random() * 480) + 1;
            c = (int) (Math.random() * 380) + 1;
            linearFunction(g, c, c, a, a);
            n++;
        }

    }

    // funcion lineal f(x) = m x + b
    
    private void linearFunction(Graphics g, double x0, double y0, double x1, double y1) {

        double y;
        //cálculo de pendiente y del término b (intersección con eje y)
        double m = (y0 - y1) / (x0 - x1);
        double b = -1 * m * x0;

        //for(double x = x0; x <= x1; x += 1){
        for (double x = x0; x <= x1; x += 0.1) {
            
            y = (m * x + b);

            //transforme el y
            y = this.getHeight() - y;

            //dibujo
           
            g.drawLine((int) x, (int) y, (int) x, (int) y);
            g.drawLine((int) x, (int) y1, (int) x, (int) y1);
            g.drawLine((int) x1, (int) y, (int) x1, (int) y);
            g.drawLine((int) y, (int) y1, (int) y, (int) y1);
            g.drawLine((int) y1, (int) y, (int) y1, (int) y);
            g.drawLine((int) y, (int) x, (int) x, (int) y);
            g.drawLine((int) x, (int) y, (int) y, (int) x);
            g.drawLine((int) y0, (int) x1, (int) x1, (int) y0);
            g.drawLine((int) x1, (int) y0, (int) y0, (int) x1);
            g.drawLine((int) x, (int) y0, (int) x, (int) y0);
            g.drawLine((int) y0, (int) y1, (int) y1, (int) y0);
            g.drawLine((int) y0, (int) x, (int) y0, (int) x);

        }
    }//method

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        draw(g);

    }



   
}
