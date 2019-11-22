package com.jeu.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected int velocite_X, velocite_Y;
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics graphique);
	public abstract Rectangle getBounds();
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public ID getID() {
		return id;
	}
	
	public void setVelociteX(int velocite_X) {
		this.velocite_X = velocite_X;
	}
	
	public void setVelociteY(int velocite_Y) {
		this.velocite_Y = velocite_Y;
	}
	
	public int getVelociteX() {
		return velocite_X;
	}

	public int getVelociteY() {
		return velocite_Y;
	}
	
}
