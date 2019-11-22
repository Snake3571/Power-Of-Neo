package com.jeu.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int PV = 100;

	public void tick() {		
		PV = Game.clamp(PV, 0, 100);
	}
	
	public void render(Graphics graphique) {
		graphique.setColor(Color.gray);
		graphique.fillRect(15, 15, 200, 32);
		graphique.setColor(Color.green);
		graphique.fillRect(15, 15, PV * 2, 32);
		graphique.setColor(Color.white);
		graphique.drawRect(15, 15, 200, 32);
	}
	
}
