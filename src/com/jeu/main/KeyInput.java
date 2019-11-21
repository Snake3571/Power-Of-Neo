package com.jeu.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent touche) {
		int key = touche.getKeyCode();
		
		for(int i = 0; i < handler.Objets.size(); i++) {
			GameObject tempObject = handler.Objets.get(i);
			
			if (tempObject.getID() == ID.Player) {
				//key event J1
				if(key == KeyEvent.VK_UP) tempObject.setVelociteY(-5);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelociteY(5);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelociteX(-5);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelociteX(5);
			}
			
			/*if (tempObject.getID() == ID.Player2) {
				//key event J2
			}*/
		}
	}
	
	public void keyReleased(KeyEvent touche) {
		int key = touche.getKeyCode();
		
		for(int i = 0; i < handler.Objets.size(); i++) {
			GameObject tempObject = handler.Objets.get(i);
			
			if (tempObject.getID() == ID.Player) {
				//key event J1
				if(key == KeyEvent.VK_UP) tempObject.setVelociteY(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelociteY(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelociteX(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelociteX(0);
			}
			
			/*if (tempObject.getID() == ID.Player2) {
				//key event J2
			}*/
		}
	}
	
}
