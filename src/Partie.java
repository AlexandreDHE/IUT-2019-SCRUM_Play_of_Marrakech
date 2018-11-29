import javax.swing.event.EventListenerList;

public class Partie
{
	protected Assam assam;
	protected De de;
	protected Joueur[] joueurs;

	protected final EventListenerList listeners;

	public Partie(int nombreJoueurs)
	{
		this.listeners = new EventListenerList();
		this.joueurs = new Joueur[nombreJoueurs];

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

	public void run()
	{
		this.updateIHM("Le joueur " + 1 + " choisit une orientation d'Assam");
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