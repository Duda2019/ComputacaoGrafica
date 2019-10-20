/** Eduarda do Carmo David - RA: 819163784 - Professor Celso
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Poligono extends JPanel {
	
	public void cor (Graphics g) {
		
		int [][] pontos = {{200, 350}, {300, 350}, {250, 300}, {200,300}};
		drawPoligono(pontos, g);	
		
	}

	private void drawPoligono(int[][] pontos, Graphics g) {
		for(int lado = 0; lado < pontos.length; lado++) {
			if(lado < pontos.length -1) {
				
				vertices(pontos[lado][0], pontos[lado][1], pontos[lado+1][0], pontos[lado+1][1],g);
			}else {
				vertices(pontos[lado][0], pontos [lado][1], pontos[0][0], pontos[0][lado], g);
			}
		}
		
		drawCentro(pontos,g);
		
	}

	private void drawCentro(int[][] pontos, Graphics g) {
		int x = 0;
		int y = 0;
		
		for (int lado = 0; lado < pontos.length; lado++) {
			x += pontos [lado][0];
			y += pontos [lado][1];
		}
		
		g.fillRect((int) x/pontos.length, (int) y/pontos.length, 4,4);
		
	}
	
		private void vertices(int x1, int y1, int x2, int y2, Graphics g) {
	
				int vx = x2 - x1;
				int vy = y2 - y1;
				
				int distance = Math.abs(vx) > Math.abs(vy) ? Math.abs(vx) : Math.abs(vy);
				
				float Xinc = vx / (float) distance;
				float Yinc = vy / (float) distance;
				
				float x = x1;
				float y = y1;
				for (int lado = 0; lado <= distance; lado++) {
					
					g.fillRect((int) x, (int) y, 2, 2);
					
						x += Xinc;
						y += Yinc;
				}
	}
		
		public static void main (String[] args) {
			
			JFrame frame = new JFrame();
			frame.setSize(600, 600);
			frame.setLocationRelativeTo(null);
			frame.setBackground(Color.LIGHT_GRAY);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setTitle("Transformações Geométricas de Polígonos com Interação");
		}
		
}
		





