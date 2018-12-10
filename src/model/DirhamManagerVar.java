package model;

public class DirhamManagerVar implements DirhamManager{
	
	public void deal(Joueur player) 
	{
		int dirham = player.getNombreTapis()*2;
		player.ajouterPiece(dirham % 5, dirham / 5);
	} 
}