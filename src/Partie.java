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

	public void orienterAssam(boolean horaire)
	{
		this.assam.tournerHoraire();

		if(this.assam.getOrientation() == Assam.NORD)
			this.updateIHM("Le joueur " + this.joueur + " oriente Assam vers le nord");
		else if(this.assam.getOrientation() == Assam.EST)
			this.updateIHM("Le joueur " + this.joueur + " oriente Assam vers l'est'");
		else if(this.assam.getOrientation() == Assam.SUD)
			this.updateIHM("Le joueur " + this.joueur + " oriente Assam vers le sud");
		else if(this.assam.getOrientation() == Assam.OUEST)
			this.updateIHM("Le joueur " + this.joueur + " oriente Assam vers l'ouest");

		this.joueur++;
		if(this.joueur == this.joueurs.length)
			this.joueur = 0;
	}

	public void choisirOrientation()
	{
		this.updateIHM("Le joueur " + this.joueur + " choisit une orientation d'Assam");
	}

	public void lancerDe()
	{
		this.updateIHM("Le joueur " + this.joueur + " lance le dé");
		this.de.getValeur();
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