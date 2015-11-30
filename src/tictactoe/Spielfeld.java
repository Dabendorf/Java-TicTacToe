package tictactoe;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Diese Klasse generiert ein GridLayout mit 3x3 Flaeche aus Spielzellen und stellt das TicTacToe-Feld dar.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Spielfeld extends JPanel {
	
	private static Spielzelle zelle[][] = new Spielzelle[3][3];
	
	public Spielfeld() {
		setLayout(new GridLayout(3,3));
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				zelle[x][y] = new Spielzelle(x,y);
				zelle[x][y].setOpaque(true);
				add(zelle[x][y]);
			}
		}
	}

	public static Spielzelle getZelle(int x, int y) {
		return zelle[x][y];
	}
}