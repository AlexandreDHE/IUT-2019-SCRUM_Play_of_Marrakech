package model;

import java.util.ArrayList;
import java.util.Collections;

/** 
	*Cette class permet de gerer la distribution,
    *et le stockage des tapis. 
    *Cette class permet à la fois la gestion des tapis 
    *pour les 2, 3 ou 4 joueurs 
    */

public class PaquetTapis implements Cloneable
{
	private ArrayList<Tapis> listeTapis;
	private int curseur;

  
	public PaquetTapis()
	{
		this.listeTapis = new ArrayList<Tapis>();
		this.curseur = 0;
	}

	public void addTapis(Tapis tapis)
	{
		listeTapis.add(tapis);
	}

	public Tapis getTapis()
	{
		return this.listeTapis.get(this.curseur);
	}
	
	public void next()
	{
		if(this.curseur < this.listeTapis.size() - 1)
		{
			this.curseur++;
		}
	}

	public void melanger()
	{
		Collections.shuffle(this.listeTapis);
	}

	public int getSize()
	{
		return this.listeTapis.size();
	}

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
		PaquetTapis p = (PaquetTapis)super.clone();
		p.listeTapis = (ArrayList<Tapis>)this.listeTapis.clone();
		return (Object)p;
	}
}