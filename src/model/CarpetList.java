package model;

import java.util.ArrayList;
import java.util.Collections;

/** 
	*Cette class permet de gerer la distribution,
    *et le stockage des tapis. 
    *Cette class permet à la fois la gestion des tapis 
    *pour les 2, 3 ou 4 joueurs 
    */

public class CarpetList implements Cloneable
{
	private ArrayList<Carpet> listeTapis;
	private int curseur;

	public CarpetList()
	{
		this.listeTapis = new ArrayList<Carpet>();
		this.curseur = 0;
	}

/**
	Cette méthode permet à l'utilisateur de poser un tapis contenu dans 
    *sa liste de tapis
    */
	public void addTapis(Carpet tapis)
	{
		listeTapis.add(tapis);
	}
    
/**
	Permet de recuperer le tapis designé par le curseur 
    */
    
	public Carpet getTapis()
	{
		return this.listeTapis.get(this.curseur);
	}
	
/**
	Pour prendre la tapis d'apres, le curseur change de position dans le tableau de tapis
    */    
	public void next()
	{
		if(this.curseur < this.listeTapis.size() - 1)
		{
			this.curseur++;
		}
	}

/** 
	Pour le mode deux joueur, cette méthode mélange les tapis du meme paquet
    */ 
	public void melanger()
	{
		Collections.shuffle(this.listeTapis);
	}

/**
	*Cette méthode permet de connaitre la taille du paquet de tapis.
    *Autrement dit on souhaite connaitre le nombre de tapis dans le paquet
    */
	public int getSize()
	{
		return this.listeTapis.size();
	}

	public int getCarpetsLeft()
	{
		return this.listeTapis.size() - this.curseur - 1;
	}



/**
	*Cette méthode permet d'actualiser le patrimoine que possède le joueur
    * On converti ens tring les information du tableau du joueur 
    */
	public String toString()
	{
		
		String str = new String();
		for(int i = 0; i < this.listeTapis.size(); i++)
		{
			str = str + this.listeTapis.get(i).getCouleur();
		}
		return str;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		CarpetList p = (CarpetList)super.clone();
		p.listeTapis = (ArrayList<Carpet>)this.listeTapis.clone();
		return (Object)p;
	}
}