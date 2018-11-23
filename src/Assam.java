public class Assam
{
	private static Assam assam = null;

	private static final int NORD = 0;
	private static final int EST = 1;
	private static final int SUD = 2;
	private static final int OUEST = 3;

	private int orientation;

	private Assam()
	{
		this.orientation = NORD;
	}

	public void tournerHorraire()
	{
		if(this.orientation == OUEST)
			this.orientation = NORD;

		else
			this.orientation++;
	}

	public void tournerAntiHorraire()
	{
		if(this.orientation == NORD)
			this.orientation = OUEST;

		else
			this.orientation--;
	}

	public int getOrientation()
	{
		return this.orientation;
	}

	public static Assam getAssam()
	{
		if(assam == null)
			assam = new Assam();

		return assam;
	}
}