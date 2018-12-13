package model;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class De
{
	protected static De de = null;
	private ArrayList<Integer> values;
	protected  static Random aleatoire;

	protected int[] valeurs;
	
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

		med = size / 2 + 1;

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
		int nombre = De.aleatoire.nextInt(this.values.size()) + 1;
		return this.values.get(nombre);
	}
}