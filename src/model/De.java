package model;
import java.util.Random;

public class De
{
	protected static De de = null;
	protected  static Random aleatoire;
	
	private De()
	{
		aleatoire = new Random();
	}

	public static De getDe()
	{
		if(de == null)
		{
			de = new De();
		}
		return de;
	}

	public int getValeur()
	{
		int[] valeurs = {1,2,2,3,3,4};
		int nombre = De.aleatoire.nextInt(5) + 1;
		return valeurs[nombre];
	}
}