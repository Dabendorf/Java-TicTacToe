package tictactoe;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Dies ist die Hauptklasse des Spiels. Sie generiert das graphische Fenster und steuert die interne Spiellogik.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class TicTacToe {

	private JFrame frame1 = new JFrame("Tic Tac Toe");
	private static int spieler = 1;
	private static int runde = 0;
	
	public TicTacToe() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setPreferredSize(new Dimension(400,400));
        frame1.setMinimumSize(new Dimension(200,200));
		frame1.setResizable(true);
		
		Container cp = frame1.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		
		frame1.add(new Spielfeld());
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}

	/**
	 * Diese Methode wechselt nach einem Spielzug den Spieler.
	 */
	private static void spielerwechsel() {
		if(spieler == 1) {
			spieler = 2;
		} else {
			spieler = 1;
		}
	}
	
	/**
	 * Diese Methode ueberprueft, ob ein Spieler bereits gewonnen hat oder ob alle 9 Felder ergebnislos belegt wurden.
	 * @param x Nimmt den x-Wert des angeklickten Feldes entgegen.
	 * @param y Nimmt den y-Wert des angeklickten Feldes entgegen.
	 */
	public static void pruefung(int x, int y) {
		if(Spielfeld.getZelle(x, 0).getAktiv() == Spielfeld.getZelle(x, 1).getAktiv() && Spielfeld.getZelle(x, 0).getAktiv() == Spielfeld.getZelle(x, 2).getAktiv()) {
			for(int i=0;i<3;i++) {
				Spielfeld.getZelle(x, i).setBackground(Color.red);
			}
			auswertung(spieler);
		} else if(Spielfeld.getZelle(0, y).getAktiv() == Spielfeld.getZelle(1, y).getAktiv() && Spielfeld.getZelle(0, y).getAktiv() == Spielfeld.getZelle(2, y).getAktiv()) {
			for(int i=0;i<3;i++) {
				Spielfeld.getZelle(i, y).setBackground(Color.red);
			}
			auswertung(spieler);
		} else if(Spielfeld.getZelle(0, 0).getAktiv() == Spielfeld.getZelle(1, 1).getAktiv() && Spielfeld.getZelle(0, 0).getAktiv() == Spielfeld.getZelle(2, 2).getAktiv() && Spielfeld.getZelle(1, 1).getAktiv() != -1) {
			for(int i=0;i<3;i++) {
				Spielfeld.getZelle(i, i).setBackground(Color.red);
			}
			auswertung(spieler);
		} else if(Spielfeld.getZelle(0, 2).getAktiv() == Spielfeld.getZelle(1, 1).getAktiv() && Spielfeld.getZelle(0, 2).getAktiv() == Spielfeld.getZelle(2, 0).getAktiv() && Spielfeld.getZelle(1, 1).getAktiv() != -1) {
			for(int i=0;i<3;i++) {
				Spielfeld.getZelle(i, 2-i).setBackground(Color.red);
			}
			auswertung(spieler);
		} else if(runde == 9) {
			unentschieden();
		} else {
			spielerwechsel();
		}
	}
	
	/**
	 * Diese Methode gibt den Sieger aus.
	 * @param sieger Nimmt die Nummer des siegreichen Spielers entgegen.
	 */
	private static void auswertung(int sieger) {
		String farbe;
		if(spieler == 1) {
			farbe = "Grün";
		} else {
			farbe = "Orange";
		}
		JOptionPane.showMessageDialog(null, "Der Spieler mit der Farbe "+farbe+" hat gewonnen!\nEin neues Spiel wird gestartet.", farbe+" gewinnt!", JOptionPane.PLAIN_MESSAGE);
		neuesspiel();
	}
	
	/**
	 * Diese Methode sagt, dass das Spiel unentschieden ausging.
	 */
	private static void unentschieden() {
		JOptionPane.showMessageDialog(null, "Kein Spieler hat eine Reihe aus 3 Feldern erreicht.\nDas Spiel endet unentschieden.\nEin neues Spiel wird gestartet.", "Unentschieden", JOptionPane.PLAIN_MESSAGE);
		neuesspiel();
	}
	
	/**
	 * Diese Methode resettet das Spielfeld und startet das Spiel neu.
	 */
	private static void neuesspiel() {
		for(int x=0;x<3;x++) {
			for(int y=0;y<3;y++) {
				Spielfeld.getZelle(x,y).setBackground(new Color(0xEEEEEE));
				Spielfeld.getZelle(x,y).setAktiv(-1);
			}
		}
		runde = 0;
		spieler = 1;
	}

	public static void main(String[] args) {
		new TicTacToe();
	}
	
	public static int getSpieler() {
		return spieler;
	}
	
	public static void setRunde(int runde) {
		TicTacToe.runde = runde;
	}

	public static int getRunde() {
		return runde;
	}
}