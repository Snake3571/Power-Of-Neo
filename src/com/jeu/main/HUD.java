package com.jeu.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int PV = 100;
	private int greenValue = 255;
	
	private int score = 0;
	private int niveau = 1;

	public void tick() {		
		PV = Game.clamp(PV, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		greenValue = PV * 2;
		score++;
	}
	
	public void render(Graphics graphique) {
		graphique.setColor(Color.gray);
		graphique.fillRect(15, 15, 200, 32);
		graphique.setColor(new Color(75, greenValue, 0));
		graphique.fillRect(15, 15, PV * 2, 32);
		graphique.setColor(Color.white);
		graphique.drawRect(15, 15, 200, 32);
		
		graphique.drawString("Score : " + score, 15, 64);
		graphique.drawString("Niveau : " + niveau, 15, 80);
	}
	
	public void score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getNiveau() {
		return niveau;
	}
	
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
}
