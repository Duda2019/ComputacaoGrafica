/**
 *@ Eduarda do Carmo David - 819163784 
 */
package Curva;

import javax.swing.*;
import java.awt.*;


public class curva  extends JPanel{

	public void curva(Graphics g, Point p1, Point p2) {
	
			int x1, y1;
			int x2, y2;
			int inclinex, incliney;
			int p = 0;
	
			
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
		
		y2 = Math.abs(p2.y - p1.y);
		incliney = -1;
	}
	
		while (x1 != p2.x) {
			draw (g, new Point(x1, y1));
			
			if (p >= 0) {
				y1 += incliney;
				p -= x2;
			}
			
			p += y2;
			x1 += inclinex;
		}
		
		draw (g, new Point (x1, y1));
		
			}

private void draw (Graphics g, Point place) {
	g.fillOval(place.x, place.y,4,4);	
}
	

public void paint(Graphics g) {

    int increment = 0;
    while(increment <= 450){
        curva(g, new Point(1, increment), new Point(increment, 450));
        increment = increment + 7;
    }

}


public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(600, 600);
    frame.getContentPane().add(new curva());
    frame.setLocationRelativeTo(null);
    frame.setBackground(Color.red);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setTitle("Bresenham: Curva");
}
}
