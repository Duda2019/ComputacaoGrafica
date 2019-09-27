/**
 *@ Eduarda do Carmo David - 819163784 
 */
package Bresenham;

import javax.swing.*;
import java.awt.*;

public class Bresenham extends JPanel{
	
	private void BresenhamAllSquad(Graphics g, Point p1, Point p2) {
		
		int x1, y1;
		int x2, y2;
		int inclinex, incliney;
		int p;
		
		x1 = p1.x;
		y1 = p1.y;
		
	if (p2.x >= p1.x) {
		x2 = Math.abs(p2.x - p1.x);
		inclinex = 1;
	}else {
		x2 = Math.abs(p1.x - p2.x);
		inclinex = -1;
	}
	
		
	if (p2.y >= p1.y) {
		y2 = Math.abs(p2.y - p1.y);
		incliney = 1;
	}else {
		y2 = Math.abs(p1.y - p2.y);
		incliney = -1;
	}
	
		
	if (x2 >= y2) {
		y2 <<= 1;
		p = y2 - x2;
		x2 <<= 1;
		
			while (x1 != p2.x) {
				draw(g, new Point(x1,y1));
				
			if (p >= 0) {
					y1 += incliney;
					p -= x2;
				}
				
				p += y2;
				x1 += inclinex;
			}
			
			draw (g, new Point(x1,y1));
	} else {
		
		x2 <<= 1;
		p = x2 - y2;
		y2 <<= 1;
		
			while (y1 != p2.y) {
				draw (g, new Point(x1,y1));
				
			if (p >= 0) {
					x1 += inclinex;
					p -= y2;
				}
				
				p += x2;
				y1 += incliney;
			}
			
			draw (g, new Point(x1,y1));
	}
	}
private void draw(Graphics g, Point place) {
	g.fillOval(place.x, place.y, 5, 5);
}	
	

public void paint(Graphics g) {
	BresenhamAllSquad(g, new Point(200, 200), new Point(350,50));
	BresenhamAllSquad(g, new Point(200, 200), new Point(50, 50));
	BresenhamAllSquad(g, new Point(200, 200), new Point(50, 350));
	BresenhamAllSquad(g, new Point(200, 200), new Point(350, 350));
}

public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(600, 600);
    frame.getContentPane().add(new Bresenham());
    frame.setLocationRelativeTo(null);
    frame.setBackground(Color.LIGHT_GRAY);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setTitle("Algoritmo Bresenham");
}
}

	


	

	
	
	
	
	
	
	
	
	
	
	