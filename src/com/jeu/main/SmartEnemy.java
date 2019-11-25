package com.jeu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{

	private Handler handler;
	private GameObject joueur;
	
	public SmartEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		for (int i = 0; i < handler.Objets.size(); i++) {
			if (handler.Objets.get(i).getID() == ID.Player) {
				joueur = handler.Objets.get(i);
			}
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += velocite_X;
		y += velocite_Y;
		
		float difference_X = x - joueur.getX() - 8;
		float difference_Y = y - joueur.getY() - 8;
		float distance = (float) Math.sqrt((x - joueur.getX()) *  (x - joueur.getX()) + (y - joueur.getY()) * (y - joueur.getY()));
		
		velocite_X = ((-1 / distance) * difference_X);
		velocite_Y = ((-1 / distance) * difference_Y);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.1f, handler));
	}

	public void render(Graphics graphique) {
		graphique.setColor(Color.green);
		graphique.fillRect((int)x, (int)y, 16, 16);
	}

}
