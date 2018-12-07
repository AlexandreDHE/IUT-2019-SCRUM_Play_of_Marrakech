public class DirhamManagerVar implements DirhamManager{
	
	public void deal(Joueur player) 
	{
		int dirham = player.getNombreTapis()*2;
		argent = new int[2];
		argent[PIECEUN] = dirham % 5;
		argent[PIECECINQ] = dirham / 5;
	} 
}