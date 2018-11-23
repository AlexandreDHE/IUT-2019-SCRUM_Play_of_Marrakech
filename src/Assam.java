public class Assam
{
	private static Assam assam = null;

	private static final int NORD = 0;
	private static final int EST = 1;
	private static final int SUD = 2;
	private static final int OUEST = 3;

	private int orientation;

	private Coord coord;

	private Assam()
	{
		this.orientation = NORD;
		this.coord = new Coord(3,3);
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

	public void setCoord(int x, int y)
	{
		this.coord.setX(x);
		this.coord.setY(y);
	}

	public static Assam getAssam()
	{
		if(assam == null)
			assam = new Assam();

		return assam;
	}
}