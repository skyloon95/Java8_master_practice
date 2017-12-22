package net.skhu.graphics.lecture02;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example02 {

	static class MyView extends JPanel {

		@Override
		public void paint(Graphics graphics) {
			super.paint(graphics);
			Graphics2D g = (Graphics2D)graphics;
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			float x = 50, y = 150;
            String text = "¾È³ç Java 2D ±×·¡ÇÈ";

            Font font = new Font("±Ã¼­Ã¼", Font.BOLD, 60);
            TextLayout textLayout = new TextLayout(text, font, g.getFontRenderContext());
            Rectangle2D rect = textLayout.getBounds();
            
            float x1 = x + (float)rect.getMinX();
            float x2 = x + (float)rect.getMaxX();
            float y1 = y + (float)rect.getMinY();
			float y2 = y + (float)rect.getMaxY();
			

            g.setPaint(Color.LIGHT_GRAY);
            textLayout.draw(g, x + 2f, y + 2f);

            g.setPaint(new GradientPaint(y1, x1,new Color(0, 200, 0), y2, x2, new Color(200, 250, 0), true));
            textLayout.draw(g, x, y);

		}    
	}

	public static void main(String[] args) {

		MyView myView = new MyView();
		myView.setBackground(Color.WHITE);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 300);
		frame.add(myView);
		frame.setVisible(true);
	} 

}
