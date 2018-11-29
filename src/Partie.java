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

	public void deroulement(Interface ihm)
	{
		for(int i = 0; i < this.joueurs.length; i++)
		{
			ihm.setMessage("Le joueur " + (i+1) + " choisit une orientation d'Assam");
			ihm.setMessage("1 - Sens horraire\n2 - Sens trigo\nAutre - Ne pas changer l'orientation\n");


			StrategieOrientationTerminal str = new StrategieOrientationTerminal();
			str.orienter(this.assam);
			this.assam.tournerHorraire();
			int babouche = this.joueurs[i].lancerDe(this.de);
			this.assam.avancer(babouche);
		}
	}

	public Joueur[] getJoueurs()
	{
		return this.joueurs;
	}

}