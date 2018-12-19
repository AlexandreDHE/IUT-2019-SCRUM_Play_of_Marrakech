package model.dirham;

import model.*;

public class DirhamManagerClassic implements DirhamManager 
{
	public void deal(Player player) 
	{
		player.ajouterPiece(5, 5);
	}
}