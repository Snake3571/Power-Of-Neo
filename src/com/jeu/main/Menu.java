package com.jeu.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.jeu.main.Game.ETAT;

public class Menu extends MouseAdapter{
	
	Game game;
	Handler handler;
	private Random random = new Random();
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}

	public void mousePressed(MouseEvent souris) {
		int mx = souris.getX();
		int my = souris.getY();
		
		if(game.EtatJeu == ETAT.Menu) {
			//Bouton "Jouer"
			if (mouseOver(mx, my, 175, 150, 300, 64)) {
				game.EtatJeu = ETAT.Jeu;
				handler.addObject(new Player(Game.LARGEUR/2-32, Game.LONGUEUR/2-32, ID.Player, handler));
				handler.addObject(new BasicEnemy(random.nextInt(Game.LARGEUR - 50), random.nextInt(Game.LONGUEUR - 50), ID.BasicEnemy, handler));
			}
			
			//Bouton "Aide"
			if (mouseOver(mx, my, 175, 250, 300, 64)) {
				game.EtatJeu = ETAT.Aide;
			}
			
			//Bouton "Quitter"
			if (mouseOver(mx, my, 175, 350, 300, 64)) {
				System.exit(1);
			}
		}
		
		if (game.EtatJeu == ETAT.Aide) {
			if (mouseOver(mx, my, 175, 350, 300, 64)) {
				game.EtatJeu = ETAT.Menu;
				return;
			}
		}
	}
	
	public void mouseReleased(MouseEvent souris) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int LARGEUR, int LONGUEUR) {
		if (mx > x && mx < x + LARGEUR) {
			if(my > y && my < y + LONGUEUR) {
				return true;
			} else return false;
		} else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics graphique) {
		
		if(game.EtatJeu == ETAT.Menu) {
			Font police_ecriture = new Font("arial", 1, 50);
			Font police_ecriture_2 = new Font("arial", 1, 30);
			
			graphique.setFont(police_ecriture);
			graphique.setColor(Color.white);
			graphique.drawString("POWER OF NEO", 125, 70);
			
			graphique.setFont(police_ecriture_2);
			graphique.drawRect(175, 150, 300, 64);
			graphique.drawString("JOUER", 270, 195);
			
			graphique.drawRect(175, 250, 300, 64);
			graphique.drawString("AIDE", 290, 295);
			
			graphique.drawRect(175, 350, 300, 64);
			graphique.drawString("QUITTER", 260, 395);
		} else if (game.EtatJeu == ETAT.Aide) {
			Font police_ecriture = new Font("arial", 1, 50);
			Font police_ecriture_2 = new Font("arial", 1, 30);
			Font police_ecriture_3 = new Font("arial", 1, 20);
			
			graphique.setFont(police_ecriture);
			graphique.setColor(Color.white);
			graphique.drawString("AIDE", 260, 70);
			
			graphique.setFont(police_ecriture_3);
			graphique.drawString("Utilisez les fléches directionnels pour", 150, 200);
			graphique.drawString("éviter les attaques de Mettaton", 150, 220);
			
			graphique.setFont(police_ecriture_2);
			graphique.drawRect(175, 350, 300, 64);
			graphique.drawString("RETOUR", 260, 395);
		}
		
		
	}
	
}
