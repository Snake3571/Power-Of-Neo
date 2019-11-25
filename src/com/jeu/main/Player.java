package com.jeu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random random = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		x += velocite_X;
		y += velocite_Y;
		
		x = Game.clamp(x, 0, Game.LARGEUR - 37);
		y = Game.clamp(y, 0, Game.LONGUEUR - 60);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.1f, handler));
		
		collision();
	}
	
	private void collision() {
		for(int i = 0 ; i < handler.Objets.size(); i++) {
			
			GameObject tempObject = handler.Objets.get(i);
			
			if (tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy) { //TempObject est un BasicEnemy
				
				if (getBounds().intersects(tempObject.getBounds())) {
					//Collision Code
					HUD.PV -= 2;
				}
				
			}
			
		}
	}

	public void render(Graphics graphique) {
		graphique.setColor(Color.white);
		graphique.fillRect(x, y, 32, 32);
	}


}
