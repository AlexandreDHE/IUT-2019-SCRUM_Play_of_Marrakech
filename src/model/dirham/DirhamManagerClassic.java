package model.dirham;

import model.*;

public class DirhamManagerClassic implements DirhamManager 
{
	public void deal(Joueur player) 
	{
		player.ajouterPiece(5, 5);
	}
}