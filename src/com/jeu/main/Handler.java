package com.jeu.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	
	LinkedList<GameObject> Objets = new LinkedList<GameObject>();
	
	public void tick() {
		for (int i = 0; i < Objets.size(); i++) {
			GameObject tempObject = Objets.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics graphique) {
		for (int i = 0; i < Objets.size(); i++) {
			GameObject tempObject = Objets.get(i);
			
			tempObject.render(graphique);
		}
	}
	
	public void clearEnemy() {
		for (int i = 0; i < Objets.size(); i++) {
			GameObject tempObject = Objets.get(i);
			
			//if (tempObject.getID() != ID.Player) removeObject(tempObject);
		
			if (tempObject.getID() == ID.Player) {
				Objets.clear();
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
			}
		
		}
	}
	
	public void addObject(GameObject objet) {
		this.Objets.add(objet);
	}
	
	public void removeObject(GameObject objet) {
		this.Objets.remove(objet);
	}
	
}
