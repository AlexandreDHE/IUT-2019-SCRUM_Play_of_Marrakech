package model;
import java.util.Random;

import model.de.*;

public class De
{
	protected static De de = null;
	protected  static Random aleatoire;

	protected int[] valeurs;
	
	private De(DeManager manager)
	{
		aleatoire = new Random();

		valeurs = manager.face(6);
		for(int i = 0; i< valeurs.length; i++)
		{
			System.out.println(valeurs[i] + " ");
		}
	}

	public static De getDe()
	{
		if(de == null)
		{
			de = new De(new DeManagerClassic());
		}
		return de;
	}



	public int getValeur()
	{
		int nombre = De.aleatoire.nextInt(5) + 1;
		return valeurs[nombre];
	}
}