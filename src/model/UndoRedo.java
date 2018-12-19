package model;

import java.util.*;

/**
 * UndoRedo
 */
public class UndoRedo {

	private class JoueurDonne{
		public int[] argent;
		public CarpetList paquet;
	}

	private class Donne {

		public JoueurDonne[] joueur;
		public int orientation;
		public Case[][] cases;
		public Position coord;

	}

	private Player[] joueur;
	private Grid plateau;
	private Assam assam;

	private int nbsave;
	private int nbundo;

	private Stack<Donne> undo;
	private Stack<Donne> redo;

	public UndoRedo(Player[] j, Grid p, Assam a) {
		joueur = j;
		plateau = p;
		assam = a;
		nbsave = 0;
		nbundo = 0;

		undo = new Stack<Donne>();
		redo = new Stack<Donne>();
	}

	public boolean undo() {

		if (nbsave == 0) {
			return false;
		}

		Donne donne;
		donne = undo.pop();
		redo.push(donne);
		assam.setCoord(donne.coord);
		assam.setOrientation(donne.orientation);
		plateau.setCases(donne.cases);
		
		JoueurDonne joueurs[] = donne.joueur;

		for (int i = 0; i < joueur.length; i++) {

			joueur[i].setPaquet(joueurs[i].paquet);
			joueur[i].setArgent(joueurs[i].argent);
		}

		nbundo++;
		nbsave--;

		return true;
	}

	public boolean redo() {
		
		if (nbundo == 0) {
			return false;
		}

		Donne donne;
		donne = redo.pop();
		undo.push(donne);
		assam.setCoord(donne.coord);
		assam.setOrientation(donne.orientation);
		plateau.setCases(donne.cases);
		
		JoueurDonne joueurs[] = donne.joueur;

		for (int i = 0; i < joueur.length; i++) {

			joueur[i].setPaquet(joueurs[i].paquet);
			joueur[i].setArgent(joueurs[i].argent);
		}

		nbundo++;

		return true;
	}

	public void save() {
		nbsave++;

		Donne donne = new Donne();

		JoueurDonne[] joueurs = new JoueurDonne[joueur.length];

		try {
			Player j;
			for (int i = 0; i < joueur.length; i++) {
				joueurs[i] = new JoueurDonne();
				j = (Player)joueur[i].clone();
				joueurs[i].argent = j.getArgent();
				joueurs[i].paquet = j.getPaquet();
			}
	
			donne.joueur = joueurs;
	
			Grid p = (Grid)plateau.clone();
			donne.cases = p.getCases();

			Assam a = (Assam)assam.clone();

			donne.orientation = a.getOrientation();
			donne.coord = (Position)a.getCoord();
		} catch (CloneNotSupportedException e) {
			System.err.println("erreur clone " + e);
		}
		

		undo.push(donne);
		redo.empty();
		nbundo = 0;

	}
}