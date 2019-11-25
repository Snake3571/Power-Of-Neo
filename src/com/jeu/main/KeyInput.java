package com.jeu.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		for (int i = 0; i < 4; i++) {
			keyDown[i] = false;
		}
	}

	public void keyPressed(KeyEvent touche) {
		int key = touche.getKeyCode();
		
		for(int i = 0; i < handler.Objets.size(); i++) {
			GameObject tempObject = handler.Objets.get(i);
			
			if (tempObject.getID() == ID.Player) {
				//key event J1
				if(key == KeyEvent.VK_UP) { tempObject.setVelociteY(-5); keyDown[0] = true; }
				if(key == KeyEvent.VK_DOWN) { tempObject.setVelociteY(5); keyDown[1] = true; }
				if(key == KeyEvent.VK_LEFT) { tempObject.setVelociteX(-5); keyDown[2] = true; }
				if(key == KeyEvent.VK_RIGHT) { tempObject.setVelociteX(5); keyDown[3] = true; }
			}
			
			/*if (tempObject.getID() == ID.Player2) {
				//key event J2
			}*/
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	
	public void keyReleased(KeyEvent touche) {
		int key = touche.getKeyCode();
		
		for(int i = 0; i < handler.Objets.size(); i++) {
			GameObject tempObject = handler.Objets.get(i);
			
			if (tempObject.getID() == ID.Player) {
				//key event J1
				if(key == KeyEvent.VK_UP) keyDown[0] = false;
				if(key == KeyEvent.VK_DOWN) keyDown[1] = false;
				if(key == KeyEvent.VK_LEFT) keyDown[2] = false;
				if(key == KeyEvent.VK_RIGHT) keyDown[3] = false;
				
				//Mouvement vertical
				if (!keyDown[0] && !keyDown[1]) tempObject.setVelociteY(0);
				//Mouvement horizontale
				if (!keyDown[2] && !keyDown[3]) tempObject.setVelociteX(0);
			}
			
			/*if (tempObject.getID() == ID.Player2) {
				//key event J2
			}*/
		}
	}
	
}
