package com.jeu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{

	private Handler handler;
	Random random = new Random();
	
	private int timer = 80;
	private int timer2 = 50;
	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velocite_X = 0;
		velocite_Y = 2;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 96, 96);
	}
	
	public void tick() {
		x += velocite_X;
		y += velocite_Y;
		
		if (timer <= 0) velocite_Y = 0;
		else timer--;
		
		if (timer <= 0) timer2--;
		if (timer2 <= 0) {
			if (velocite_X == 0) velocite_X = 2;
			
			if (velocite_X > 0) velocite_X += 0.005f;
			else if (velocite_X < 0) velocite_X -= 0.005f;
			
			velocite_X = Game.clamp(velocite_X, -10, 10);
			
			int spawn = random.nextInt(10);
			if (spawn == 0) handler.addObject(new EnemyBossBullet((int) x + 48, (int) y + 48, ID.BasicEnemy, handler));
		}
		
		//if(y <= 0 || y >= Game.LONGUEUR - 32) velocite_Y *= -1;
		if(x <= 0 || x >= Game.LARGEUR - 96) velocite_X *= -1;
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.1f, handler));
	}

	public void render(Graphics graphique) {
		graphique.setColor(Color.red);
		graphique.fillRect((int)x, (int)y, 96, 96);
	}

}
