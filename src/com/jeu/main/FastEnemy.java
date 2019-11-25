package com.jeu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{

	private Handler handler;
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velocite_X = 2;
		velocite_Y = 9;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}
	
	public void tick() {
		x += velocite_X;
		y += velocite_Y;
		
		if(y <= 0 || y >= Game.LONGUEUR - 32) velocite_Y *= -1;
		if(x <= 0 || x >= Game.LARGEUR - 16) velocite_X *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.1f, handler));
	}

	public void render(Graphics graphique) {
		graphique.setColor(Color.cyan);
		graphique.fillRect(x, y, 16, 16);
	}

}
