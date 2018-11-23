public class Partie
{
	protected Assam assam;
	protected De de;
	protected Joueur[] joueurs;

	public Partie(int nombreJoueurs)
	{
		joueurs = new Joueur[nombreJoueurs];

		if (nombreJoueurs == 2)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				joueurs[i] = new Joueur(i, 24);
			}
		}

		else if (nombreJoueurs == 3)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				joueurs[i] = new Joueur(i, 15);
			}
		}

		else if (nombreJoueurs == 4)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				joueurs[i] = new Joueur(i, 12);
			}
		}

		assam = Assam.getAssam();
		de = De.getDe();
	}

	public void deroulement()
	{
		for(int i = 0; i < this.joueurs.length; i++)
		{
			OrientationListener o = new OrientationTerminal();
			o.orienter(this.assam);
			System.out.println(this.assam.getOrientation());
		}
	}
}