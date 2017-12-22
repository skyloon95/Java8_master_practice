package net.skhu.graphics.lecture01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

 public class Example01 {
     
     static class MyView extends JPanel {
         
         @Override
         public void paint(Graphics graphics) {
             super.paint(graphics);
             Graphics2D g = (Graphics2D)graphics;
             
             float x1 = 50, x2 = 150, width = 100;
             float y1 = 50, y2 = 150, height = 100;
             
             Rectangle2D.Float rect = new Rectangle2D.Float(x1, y1, width, height);
             Line2D.Float line1 = new Line2D.Float(x1, y1, x2, y2);
             Line2D.Float line2 = new Line2D.Float(x1, y2, x2, y1); 
             g.draw(rect);        
             g.draw(line1);
             g.draw(line2);
         }    
     }
     
     public static void main(String[] args) {         
         MyView myView = new MyView();
         myView.setBackground(Color.WHITE);

         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(400, 300);
         frame.add(myView);
         frame.setVisible(true);
     }
} 
