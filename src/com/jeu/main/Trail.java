package com.jeu.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private float alpha = 1;
	
	private Handler handler;
	private Color color;
	private int LARGEUR;
	private int LONGUEUR;
	private float vie; // vie peut être compris entre 0.001 et 0.1
	
	public Trail(int x, int y, ID id, Color color, int LARGEUR, int LONGUEUR, float vie, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.LARGEUR = LARGEUR;
		this.LONGUEUR = LONGUEUR;
		this.vie = vie;
	}

	public void tick() {
		if (alpha > vie) {
			alpha -= vie - 0.0001f;
		} else handler.removeObject(this);
	}

	public void render(Graphics graphique) {
		Graphics2D graphique2D = (Graphics2D) graphique;
		graphique2D.setComposite(makeTransparent(alpha));
		
		graphique.setColor(color);
		graphique.fillRect(x, y, LARGEUR, LONGUEUR);
		
		graphique2D.setComposite(makeTransparent(1));
		
	}
	
	private AlphaComposite makeTransparent (float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	public Rectangle getBounds() {
		return null;
	}
	
}
