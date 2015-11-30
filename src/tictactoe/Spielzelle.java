package tictactoe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Diese Klasse stellt eine einzelne graphische Zelle dar. Sie enthaelt einen MouseListener, falls ein Spieler auf selbige klickt.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Spielzelle extends JPanel {
	
	private int aktiv;
	private int x,y;
	
	public Spielzelle(int x, int y) {
		this.aktiv = -1;
		this.x = x;
		this.y = y;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		klick();
        	}
        });
	}

	@Override
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
	}
	
	/**
	 * Diese Methode wird aufgerufen, wenn ein Spieler auf die Zelle klickt. Sie faerbt das Feld, wenn es unbelegt ist in die Farbe des aktiven Spielers.
	 */
	private void klick() {
		if(TicTacToe.getSpieler() == 1 && this.aktiv == -1) {
			TicTacToe.setRunde(TicTacToe.getRunde()+1);
			this.aktiv = 1;
			this.setBackground(Color.green);
			TicTacToe.pruefung(x,y);
		} else if(TicTacToe.getSpieler() == 2 && this.aktiv == -1) {
			TicTacToe.setRunde(TicTacToe.getRunde()+1);
			this.aktiv = 2;
			this.setBackground(Color.orange);
			TicTacToe.pruefung(x,y);
		}
	}
	
	public int getAktiv() {
		return aktiv;
	}

	public void setAktiv(int aktiv) {
		this.aktiv = aktiv;
	}
}