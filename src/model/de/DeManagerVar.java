package model.de;

import model.*;

public class DeManagerVar implements DeManager{
	public int getSize(int median)
	{
		if(median == 2)
		{
			return 2;
		}
		return median + getSize(median-1);
	}

	public int[] face(int lignes) {
		int dmax = (lignes / 2) + 1;
		int dmed = dmax / 2;

		int tab[] = new int[dmax];
		tab[0] = 1;
		tab[lignes-1] = dmax;
		int value = 2;
		for (int i = 1; i < dmax / 2; i++) 
		{
			for(int j = 0; j < value; j++)
			{
				tab[i+j] = value;
			}
			value++;
		}

		for (int i = dmed; i < dmax; i++) 
		{
			for(int j = 0; j < value; j++)
			{
				tab[i+j] = value;
			}
			value++;
		}

		int[] faces = {1,2,2,3,3,4};
		//System.out.println(getSize(6));


		return faces;
	}
}