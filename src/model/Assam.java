package model;

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

	public void avancer(int babouche)
	{
		switch(orientation)
		{
			case NORD : this.coord.setY(this.coord.getY() + babouche); break;
			case EST : this.coord.setX(this.coord.getX() + babouche); break;
			case SUD : this.coord.setY(this.coord.getY() - babouche); break;
			case OUEST : this.coord.setX(this.coord.getX() - babouche); break;
		}
	}

	public static Assam getAssam()
	{
		if(assam == null)
			assam = new Assam();

		return assam;
	}

	/**
	 * @return les coord
	 */
	public Coord getCoord() {
		return coord;
	}
}