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
		return this.aleatoire.nextInt(6) + 1;
	}
}