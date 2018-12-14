package model;

/**
		* Cette class permet de:
        * - déplacer Assan
        * - orienter Assan
        * - connaitre son orientation actuelle        
        */


public class Assam implements Cloneable
{
  
 /**
 	* Création d'un singleton.
    * Le singleton est de type Assam
    * IL n'est créé qu'une seule fois.
    */
	private static Assam assam = null;

	public static final int NORD = 0;
	public static final int EST = 1;
	public static final int SUD = 2;
	public static final int OUEST = 3;

	private int orientation;

	private Position coord;

/** 
	*En debut de partie, Assam est orienté au NORD
    *IL se situe aussi au centre du plateau (x=3, y=3)
    */
	private Assam()
	{
		this.orientation = NORD;
		this.coord = new Position(3,3);
	}

/** 
	*Cette méthode permet de diriger assam d'un quart de tour 
    *dans le sens des aiguilles d'une montre, 
    * en incrémentant la variable orientation
    */ 
	public void tournerHorraire()
	{
		if(this.orientation == OUEST)
			this.orientation = NORD;

		else
			this.orientation++;
	}

/** 
	*Cette méthode permet de diriger assam d'un quart de tour 
    *dans le sens inverse des aiguilles d'une montre, 
    * en décrémentant la variable orientation
    */ 
	public void tournerAntiHorraire()
	{
		if(this.orientation == NORD)
			this.orientation = OUEST;
		else
			this.orientation--;
	}
  
/** 
	*Cette méthode permet de connaitre l'orientation d'Assam
    @return la valeur de la variable orientation
    */
	public int getOrientation()
	{
		return this.orientation;
	}

/**
	*Cette méthode permet de faire avancer Assam
   	*en prenant en compte l'orientation d'Assam 
    */
	public void avancer(int babouche)
	{
		switch(orientation)
		{
			case NORD : this.coord.setY(this.coord.getY() - babouche); break;
			case EST : this.coord.setX(this.coord.getX() + babouche); break;
			case SUD : this.coord.setY(this.coord.getY() + babouche); break;
			case OUEST : this.coord.setX(this.coord.getX() - babouche); break;
		}

		if(this.coord.getX() < 0)
		{
			this.coord.setX(0);
		}

		if(this.coord.getX() > 6)
		{
			this.coord.setX(6);
		}

		if(this.coord.getY() < 0)
		{
			this.coord.setY(0);
		}

		if(this.coord.getY() > 6)
		{
			this.coord.setY(6);
		}
	}
  
/**
	*Méthode qui permet de récuperer le singleton Assam 
    */
	public static Assam getAssam()
	{
		if(assam == null)
			assam = new Assam();

		return assam;
	}
  
	/**
	 * @return les coord d'Assam
	 */
	public Position getCoord() {
		return coord;
	}

	/**
	 * @param coord les coord
	 */
	public void setCoord(Position coord) {
		this.coord = coord;
	}

	/**
	 * @param orientation l'orientation
	 */
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Assam a = (Assam) super.clone();
		a.coord = (Position) this.coord.clone();
		return a;
	}
}