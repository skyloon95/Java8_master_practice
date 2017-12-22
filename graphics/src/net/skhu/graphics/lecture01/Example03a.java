package net.skhu.graphics.lecture01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

 public class Example03a {
     
     static class MyView extends JPanel {
         
         @Override
         public void paint(Graphics graphics) {
             super.paint(graphics);
             Graphics2D g = (Graphics2D)graphics;
             g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

             float blue = 0.2f;
             float y = 10;
             for (float red = 0; red <= 1; red += 0.002) {
                 float x = 10;
                 for (float green = 0; green <= 1.0; green += 0.002) {
                     Rectangle2D.Float rect = new Rectangle2D.Float(x, y, 1f, 1f);
                     Color color = new Color(red, green, blue, 0.8f);
                     g.setColor(color);                     
                     g.fill(rect);
                     x += 1;
                 }
                 y += 1;
             }
         }    
     }
     
     public static void main(String[] args) {
         
         MyView myView = new MyView();
         myView.setBackground(Color.WHITE);

         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(700, 720);
         frame.add(myView);
         frame.setVisible(true);
     }
}
