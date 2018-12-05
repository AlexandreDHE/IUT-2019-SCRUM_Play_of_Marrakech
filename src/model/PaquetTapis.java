package model;

import java.util.ArrayList;
import java.util.Collections;


public class PaquetTapis
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
		this.curseur++;
		return this.listeTapis.get(curseur-1);
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
}