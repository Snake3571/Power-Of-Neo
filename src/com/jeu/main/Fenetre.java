package com.jeu.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Fenetre extends Canvas {

	private static final long serialVersionUID = 6069269933876760334L;
	
	public Fenetre(int largeur, int longueur, String titre, Game game) {
		JFrame frame = new JFrame(titre);
		
		frame.setPreferredSize(new Dimension(largeur, longueur));
		frame.setMaximumSize(new Dimension(largeur, longueur));
		frame.setMinimumSize(new Dimension(largeur, longueur));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}

}
