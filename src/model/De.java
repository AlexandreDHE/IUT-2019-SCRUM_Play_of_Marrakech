package model;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class De
{
	protected static De de = null;
	private ArrayList<Integer> values;
	protected  static Random aleatoire;
	
	private De(int size)
	{
		aleatoire = new Random();
		this.values = new ArrayList<Integer>();
		this.setValues(size);
	}

	private void setValues(int size)
	{
		int value = 1;

		int med = 0;
		if((size%2) == 0)
		{
			med = size / 2;
		}
		else
		{
			med = size / 2 + 1;
		}
		int cpt = 1;
		while(cpt < med)
		{
			for(int i = 0; i < cpt; i++)
			{
				System.out.println(value);
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
				System.out.println(value);
				this.values.add(Integer.valueOf(value));
			} 
			value++;
			cpt--;
		};
	}

	public static De getDe(int size)
	{
		if(de == null)
		{
			de = new De(size);
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