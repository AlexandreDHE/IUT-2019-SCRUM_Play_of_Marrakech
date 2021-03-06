package model;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

import model.de.*;

/** 
	* Class qui permer d'utiliser un dé.
    * Ce dé a certaines caractéristiques imposées par le jeu
    */

public class Dice
{
	protected static Dice de = null;
	private ArrayList<Integer> values;
	protected  static Random aleatoire;

	protected int[] valeurs;
	
	private Dice(int size)
	{
		aleatoire = new Random();
		this.values = new ArrayList<Integer>();
		this.setValues(size);
	}

  
/**	
	*méthode qui permet d'adapter le dé en fonction des options
	* choisies au début de la partie (Taille du plateau)
    */
  
	private void setValues(int size)
	{
		int value = 1;

		int med = size / 2 + 1;

		int cpt = 1;
		while(cpt < med)
		{
			for(int i = 0; i < cpt; i++)
			{
				this.values.add(Integer.valueOf(value));
			} 
			value++;
			cpt++;
		};
		cpt--;
		while(cpt > 0)
		{
			for(int i = 0; i < cpt; i++)
			{
				this.values.add(Integer.valueOf(value));
			} 
			value++;
			cpt--;
		};
	}

	public static Dice getDe(int size)
	{
		if(de == null)
		{
			de = new Dice(size);
		}
		return de;
	}

/**
	* Méthode qui renvoie la valeur random du dé 
    *@return nombre
    */

	public int getValeur()
	{
		int nombre = Dice.aleatoire.nextInt(this.values.size());
		return this.values.get(nombre);
	}
}