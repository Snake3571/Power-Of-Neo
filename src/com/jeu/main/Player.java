package com.jeu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{

	Random random = new Random();
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		velocite_X = random.nextInt(5) + 1;
		velocite_Y = random.nextInt(5);
	}

	public void tick() {
		x += velocite_X;
		y += velocite_Y;
		
	}

	public void render(Graphics graphique) {
		graphique.setColor(Color.white);
		graphique.fillRect(x, y, 32, 32);
	}
	
	

}
