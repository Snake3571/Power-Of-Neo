package com.jeu.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 7675194036398776689L;
	
	public static final int LARGEUR = 640, LONGUEUR = LARGEUR /12 * 9;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private Random random;
	private HUD hud;
	private Spawn spawner;
	
	public Game() {
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		
		new Fenetre(LARGEUR, LONGUEUR, "POWER OF NEO", this);
		
		hud = new HUD();
		spawner = new Spawn(handler, hud);
		random = new Random();
		
		handler.addObject(new Player(LARGEUR/2-32, LONGUEUR/2-32, ID.Player, handler));
		handler.addObject(new BasicEnemy(random.nextInt(LARGEUR), random.nextInt(LONGUEUR), ID.BasicEnemy, handler));
		handler.addObject(new BasicEnemy(random.nextInt(LARGEUR), random.nextInt(LONGUEUR), ID.BasicEnemy, handler));
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try{
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS : " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
		spawner.tick();
	}
	
	private void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		if (buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics graphique = buffer.getDrawGraphics();
		
		graphique.setColor(Color.black);
		graphique.fillRect(0, 0, LARGEUR, LONGUEUR);
		
		handler.render(graphique);
		
		hud.render(graphique);
		
		graphique.dispose();
		buffer.show();
	}
	
	public static float clamp(float var, float min, float max) {
		if(var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main(String args[]){
		new Game();
		try {
			URL url = Game.class.getResource("/neo.wav");
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();
			Thread.sleep(1000000000);
		} catch (Exception e) {
		  System.out.println(e);
		}
		
	}
	
}
