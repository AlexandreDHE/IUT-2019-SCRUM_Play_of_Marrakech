import javax.swing.event.EventListenerList;

public class Partie
{
	protected Assam assam;
	protected De de;
	protected Joueur[] joueurs;
	protected int joueur;

	protected final EventListenerList listeners;

	public Partie(int nombreJoueurs)
	{
		this.listeners = new EventListenerList();
		this.joueurs = new Joueur[nombreJoueurs];
		this.joueur = 0;

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

	public void addInterfaceListener(InterfaceListener listener)
	{
		this.listeners.add(InterfaceListener.class, listener);
	}

	 public InterfaceListener[] getInterfaceListeners() 
	 {
        return listeners.getListeners(InterfaceListener.class);
    }

	public void updateIHM(String message)
	{
		for(InterfaceListener listener : this.getInterfaceListeners()) 
		{
            listener.messageChanged(message);
        }
	}

	private void passerJoueurSuivant()
	{
		this.joueur++;
		if(this.joueur == this.joueurs.length)
			this.joueur = 0;
	}

	public void choisirOrientation()
	{
		this.updateIHM("Au tour du joueur " + this.joueur + " de choisir l'orientation d'Assam");
	}

	public void tournerAssamHoraire()
	{
		this.assam.tournerHoraire();

		if(this.assam.getOrientation() == Assam.NORD)
			this.updateIHM("Le joueur " + this.joueur + " a orienté Assam vers le nord");
		else if(this.assam.getOrientation() == Assam.EST)
			this.updateIHM("Le joueur " + this.joueur + " a orienté Assam vers l'est'");
		else if(this.assam.getOrientation() == Assam.SUD)
			this.updateIHM("Le joueur " + this.joueur + " a orienté Assam vers le sud");
		else if(this.assam.getOrientation() == Assam.OUEST)
			this.updateIHM("Le joueur " + this.joueur + " a orienté Assam vers l'ouest");
	}

	public void tournerAssamAntiHoraire()
	{
		this.assam.tournerAntiHoraire();

		if(this.assam.getOrientation() == Assam.NORD)
			this.updateIHM("Le joueur " + this.joueur + " a orienté Assam vers le nord");
		else if(this.assam.getOrientation() == Assam.EST)
			this.updateIHM("Le joueur " + this.joueur + " a orienté Assam vers l'est'");
		else if(this.assam.getOrientation() == Assam.SUD)
			this.updateIHM("Le joueur " + this.joueur + " a orienté Assam vers le sud");
		else if(this.assam.getOrientation() == Assam.OUEST)
			this.updateIHM("Le joueur " + this.joueur + " a orienté Assam vers l'ouest");
	}

	public void pasTournerAssam()
	{
		if(this.assam.getOrientation() == Assam.NORD)
			this.updateIHM("Assam est encore orienté vers le nord");
		else if(this.assam.getOrientation() == Assam.EST)
			this.updateIHM("Assam est encore orienté vers l'est'");
		else if(this.assam.getOrientation() == Assam.SUD)
			this.updateIHM("Assam est encore orienté vers le sud");
		else if(this.assam.getOrientation() == Assam.OUEST)
			this.updateIHM("Assam est encore orienté vers l'ouest");
	}

	public void saisirDe()
	{
		this.updateIHM("Au tour du joueur " + this.joueur + " de lancer le dé");
	}

	public void lancerDe()
	{
		int valeur = this.de.getValeur();
		this.updateIHM("Le joueur " + this.joueur + " lance le dé et obtient " + valeur);
	}

	public Joueur getCurrentJoueur()
	{
		return this.joueurs[this.joueur];
	}

	public Joueur[] getJoueurs()
	{
		return this.joueurs;
	}

	public De getDe()
	{
		return this.de;
	}
}