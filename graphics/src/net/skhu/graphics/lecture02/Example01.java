package net.skhu.graphics.lecture02;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example01 {

	static class MyView extends JPanel {

		@Override
		public void paint(Graphics graphics) {
			super.paint(graphics);
			Graphics2D g = (Graphics2D)graphics;
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			float x1 = 50, x2 = 150, width = 100;
			float y1 = 50, y2 = 150, height = 100;

			Rectangle2D.Float rect = new Rectangle2D.Float(x1, y1, width, height);
			g.setPaint(new GradientPaint(x1, 0, Color.CYAN, x2, 0, Color.BLUE));
			g.fill(rect);

			x1 = 200; x2 = x1 + width;
			rect = new Rectangle2D.Float(x1, y1, width, height);
			g.setPaint(new GradientPaint(0, y1, Color.YELLOW, 0, y2, Color.GREEN));
			g.fill(rect);

			x1 = 350; x2 = x1 + width;
			Ellipse2D.Float ellipse = new Ellipse2D.Float(x1, y1, width, height);
			g.setPaint(new GradientPaint(x1, y1, Color.WHITE, x2, y2, Color.RED));
			g.fill(ellipse);

			x1 = 500; x2 = x1 + width;
			float arcWidth = 40, arcHeight = 40;
			RoundRectangle2D.Float roundRect = 
					new RoundRectangle2D.Float(x1, y1, width, height, arcWidth, arcHeight);
			g.setPaint(new GradientPaint(x2, y1, Color.WHITE, x1, y2, Color.BLACK));
			g.fill(roundRect);

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
