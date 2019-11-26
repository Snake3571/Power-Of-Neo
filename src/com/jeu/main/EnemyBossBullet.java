package com.jeu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

	private Handler handler;
	Random random = new Random();
	
	public EnemyBossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velocite_X = (random.nextInt(5 - -5) + -5);
		velocite_Y = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += velocite_X;
		y += velocite_Y;
		
		//if(y <= 0 || y >= Game.LONGUEUR - 32) velocite_Y *= -1;
		//if(x <= 0 || x >= Game.LARGEUR - 16) velocite_X *= -1;
		
		if (y >= Game.LONGUEUR) handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 16, 16, 0.1f, handler));
	}

	public void render(Graphics graphique) {
		graphique.setColor(Color.white);
		graphique.fillRect((int)x, (int)y, 16, 16);
	}

}
