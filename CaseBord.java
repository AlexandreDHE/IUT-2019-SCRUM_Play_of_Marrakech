package model;

public class CaseBord extends Case
{
	public static final int NORD = 0;
	public static final int EST = 1;
	public static final int SUD = 2;
	public static final int OUEST = 3;
	public static final int CORNERRIGHTTOP = 4;
	public static final int CORNERTOPRIGHT = 5;
	public static final int CORNERBOTLEFT = 6;
	public static final int CORNERLEFTBOT = 7;


	private int orientation;

	public CaseBord(int pos)
	{
		this.orientation = pos;
	}

	public int getOrientation()
	{
		return this.orientation;
	}
}