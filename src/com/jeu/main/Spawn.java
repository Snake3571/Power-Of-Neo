package com.jeu.main;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random random = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if (scoreKeep >= 250) {
			scoreKeep = 0;
			hud.setNiveau(hud.getNiveau() + 1);
			
			if(hud.getNiveau() == 2) {
				handler.addObject(new BasicEnemy(random.nextInt(Game.LARGEUR - 50), random.nextInt(Game.LONGUEUR - 50), ID.BasicEnemy, handler));
			} else if(hud.getNiveau() == 3) {
				handler.addObject(new FastEnemy(random.nextInt(Game.LARGEUR - 50), random.nextInt(Game.LONGUEUR - 50), ID.FastEnemy, handler));
			} else if(hud.getNiveau() == 4) {
				handler.addObject(new FastEnemy(random.nextInt(Game.LARGEUR - 50), random.nextInt(Game.LONGUEUR - 50), ID.FastEnemy, handler));
				handler.addObject(new BasicEnemy(random.nextInt(Game.LARGEUR - 50), random.nextInt(Game.LONGUEUR - 50), ID.BasicEnemy, handler));
			}
			
		}
	}
	
}
