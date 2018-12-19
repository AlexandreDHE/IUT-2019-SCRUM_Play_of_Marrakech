package model;

import model.dirham.*;

/**
	* Cette class permet de constituer le patrimoine de chaque joueur.
    * A chaque joeurs seront associé les informations suivantes: 
    * La couleur du joueur, son paquet de tapis, et le gestionnaire de dirham
    */

public class Player implements Cloneable
{
	public final static int PIECEUN = 0;
	public final static int PIECECINQ = 1;

	protected int couleur;
	protected int[] argent;
	protected CarpetList paquet;

	public Player(int couleur, CarpetList paquet, DirhamManager dir)
	{
		this.couleur = couleur;
		this.paquet = paquet;

		argent = new int[2];
		dir.deal(this);
	}

/** 
	* Connaitre la couleur du joeur
    *@return couleur
    */
	public int getCouleur()
	{
		return this.couleur;
	}

	public int[] getArgent() {
		return argent;
	}

/** 
	*Connaitre le paquet du joueur 
    *@return paquet 
    */
	public CarpetList getPaquet() {
		return paquet;
	}

/**
	*
*/
	public void setArgent(int[] argent) {
		this.argent = argent;
	}

	public void setPaquet(CarpetList paquet) {
		this.paquet = paquet;
	}

	public int getArgent(int typePiece)
	{
		return this.argent[typePiece];
	}

	public int lancerDe(Dice de)
	{
		return de.getValeur();
	}

/** 
	*Connaitre le patrimoine financier du joeur 
    *@return argent
    */

	public int getArgentTotal()
	{
		return argent[PIECEUN] * 1 + argent[PIECECINQ] * 5;
	}

/** 
	*Méthode qui permet d'ajouter des pièces au "portefeuille"
    *du joueur 
    */
	public void ajouterPiece(int nombrePieceUn, int nombrePieceCinq)
	{
		this.argent[PIECEUN] = this.argent[PIECEUN] + nombrePieceUn;
		this.argent[PIECECINQ] = this.argent[PIECECINQ] + nombrePieceCinq;
	}

/** 
	*Méthode qui permet de retirer des pièces au "portefeuille"
    *du joueur 
    */
	public void retirerPiece(int nombrePieceUn, int nombrePieceCinq)
	{
		this.argent[PIECEUN] = this.argent[PIECEUN] - nombrePieceUn;
		this.argent[PIECECINQ] = this.argent[PIECECINQ] - nombrePieceCinq;
	}


/** 
	*Méthode qui permet de payer et d'effectuer des transactions entre les joeurs
    */
   
	public void payerDime(int cout, Player adversaire)
	{
		if(this.getArgentTotal() <= cout)
		{
			adversaire.ajouterPiece(this.argent[PIECEUN], this.argent[PIECECINQ]);
			this.retirerPiece(this.argent[PIECEUN], this.argent[PIECECINQ]);
		}
		else
		{
			int nombrePieceUn = 0;
			int nombrePieceCinq = 0;

			do
			{
				nombrePieceCinq++;
			} while((nombrePieceCinq * 5) < cout);

			nombrePieceCinq--;

			do
			{
				nombrePieceUn++;
			} while(((nombrePieceCinq * 5) + (nombrePieceUn)) != cout);

			adversaire.ajouterPiece(nombrePieceUn, nombrePieceCinq);
			this.retirerPiece(nombrePieceUn, nombrePieceCinq);
		}
	}

	public int getCarpetsLeft()
	{
		return this.paquet.getCarpetsLeft();
	}

	public Carpet getTapis()
	{
		return this.paquet.getTapis();
	}

	public int getNombreTapis()
	{
		return this.paquet.getSize();
	}
	
	public CarpetList getCarpets()
	{
		return this.paquet;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		Player j = (Player)super.clone();
		j.argent = this.argent.clone();
		j.paquet = (CarpetList)this.paquet.clone();

		return (Object)j;
		
	}

}