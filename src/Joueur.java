/**
 * Représente un joueur
 *  
 * @author Faïza BOUMALLOUK et Rabah DJADI.
 */
public class Joueur
{
	/**
     * les différents types de pieces
     * PIECEUN   correspond aux pièces de 1 Dirham
     * PIECECINQ correspond aux pièces de 5 Dirhams
     */
	public final static int PIECEUN = 0;
	public final static int PIECECINQ = 1;

	protected int couleur;
	protected int[] argent;
	protected int tapis;

	public Joueur(int couleur, int nombreTapis)
	{
		this.couleur = couleur;
		this.tapis = nombreTapis;

		argent = new int[2];
		argent[PIECEUN] = 5;
		argent[PIECECINQ] = 5;
	}

	public int getCouleur()
	{
		return this.couleur;
	}

	public int getArgent(int typePiece)
	{
		return this.argent[typePiece];
	}

	public int getTapis()
	{
		return this.tapis;
	}
}