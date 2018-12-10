package model.game;

import javax.swing.event.EventListenerList;

import event.*;
import model.*;
import listener.*;

public class Game
{
	public static final int NOTSTARTED = 0;
	public static final int START = 1;
	public static final int ONGOING = 2;
	public static final int OVER = 3;
	
	protected int state;
	
	protected Assam assam;
	protected De de;
	protected Joueur[] joueurs;
	protected int currentPlayer;
	protected int valeurDe;
	protected PlateauJeu plateau;

	protected final EventListenerList listeners;

	public Game(int nombreJoueurs)
	{
		this.listeners = new EventListenerList();
		this.joueurs = new Joueur[nombreJoueurs];
		this.currentPlayer = 0;
		this.plateau = new PlateauJeu();

		if (nombreJoueurs == 2)
		{
			PaquetTapis paquet = new PaquetTapis();
			for(int i = 0; i < nombreJoueurs; i++)
			{
				joueurs[i] = new Joueur(i, paquet, new DirhamManagerClassic());
				for(int j = 0; j < 24; j++)
				{
					paquet.addTapis(new Tapis(joueurs[i].getCouleur()));
				}
			}
			paquet.melanger();
		}

		else if (nombreJoueurs == 3)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				PaquetTapis paquet = new PaquetTapis();
				joueurs[i] = new Joueur(i, paquet, new DirhamManagerClassic());
				for(int j = 0; j < 15; j++)
				{
					paquet.addTapis(new Tapis(joueurs[i].getCouleur()));
				}
			}
		}

		else if (nombreJoueurs == 4)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				PaquetTapis paquet = new PaquetTapis();
				joueurs[i] = new Joueur(i, paquet, new DirhamManagerClassic());
				for(int j = 0; j < 12; j++)
				{
					paquet.addTapis(new Tapis(joueurs[i].getCouleur()));
				}
			}
		}

		assam = Assam.getAssam();
		de = De.getDe();
		this.state = NOTSTARTED;
	}

 	// surcharge paramétrer taille du jeu
	public Game(int nombreJoueurs, int taille)
	{
		this.listeners = new EventListenerList();
		this.joueurs = new Joueur[nombreJoueurs];
		this.currentPlayer = 0;
		this.plateau = new PlateauJeu(taille);

		if (nombreJoueurs == 2)
		{
			PaquetTapis paquet = new PaquetTapis();
			for(int i = 0; i < nombreJoueurs; i++)
			{
				joueurs[i] = new Joueur(i, paquet, new DirhamManagerVar());
				for(int j = 0; j < ((taille * taille)/nombreJoueurs); j++)
				{
					paquet.addTapis(new Tapis(joueurs[i].getCouleur()));
				}
			}
			paquet.melanger();
		}

		else if (nombreJoueurs == 3)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				PaquetTapis paquet = new PaquetTapis();
				joueurs[i] = new Joueur(i, paquet, new DirhamManagerVar());
				for(int j = 0; j < ((taille * taille)/nombreJoueurs); j++)
				{
					paquet.addTapis(new Tapis(joueurs[i].getCouleur()));
				}
			}
		}

		else if (nombreJoueurs == 4)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				PaquetTapis paquet = new PaquetTapis();
				joueurs[i] = new Joueur(i, paquet, new DirhamManagerVar());
				for(int j = 0; j < ((taille * taille)/nombreJoueurs); j++)
				{
					paquet.addTapis(new Tapis(joueurs[i].getCouleur()));
				}
			}
		}

		assam = Assam.getAssam();
		de = De.getDe();
		this.state = NOTSTARTED;
	}
	
	public void start()
	{
		int oldState = this.state;
		this.state = START;
		for(GameListener listener : this.getGameListeners()) 
		{
            listener.gameStateChanged(new GameEvent(oldState, this.state));
        }
	}

	public void addAssamListener(AssamListener listener)
	{
		this.listeners.add(AssamListener.class, listener);
	}

	public void addGameListener(GameListener listener)
	{
		this.listeners.add(GameListener.class, listener);
	}

	public void addDiceListener(DiceListener listener)
	{
		this.listeners.add(DiceListener.class, listener);
	}

	public void addCarpetListener(CarpetListener listener)
	{
		this.listeners.add(CarpetListener.class, listener);
	}

	public GameListener[] getGameListeners() 
	{
        return listeners.getListeners(GameListener.class);
    }

    public AssamListener[] getAssamListeners() 
	{
        return listeners.getListeners(AssamListener.class);
    }

    public DiceListener[] getDiceListeners() 
	{
        return listeners.getListeners(DiceListener.class);
    }

    public CarpetListener[] getCarpetListeners() 
	 {
        return listeners.getListeners(CarpetListener.class);
    }

    public void fireAssamOriented(AssamEvent event)
	{
		for(AssamListener listener : this.getAssamListeners()) 
		{
            listener.assamOriented(event);
        }
	}

	public void fireAssamMoved(AssamEvent event)
	{
		for(AssamListener listener : this.getAssamListeners()) 
		{
            listener.assamMoved(event);
        }
	}

	public void fireDiceThrown(DiceEvent event)
	{
		for(DiceListener listener : this.getDiceListeners()) 
		{
            listener.diceThrown(event);
        }
	}

	public void fireCarpetPut(CarpetEvent event)
	{
		for(CarpetListener listener : this.getCarpetListeners()) 
		{
            listener.carpetPut(event);
        }
	}


	public Joueur[] getJoueurs()
	{
		return this.joueurs;
	}

	public De getDe()
	{
		return this.de;
	}

	public void moveAssam()
	{
		this.assam.avancer(this.valeurDe);
		this.fireAssamMoved(new AssamEvent(this.valeurDe, this.currentPlayer));
	}
  
	public void rotateAssamCounterClockwise()
	{
		this.assam.tournerAntiHorraire();
		this.fireAssamOriented(new AssamEvent(this.assam.getOrientation(), this.currentPlayer));
	}

	public void rotateAssamClockwise()
	{
		this.assam.tournerHorraire();
		this.fireAssamOriented(new AssamEvent(this.assam.getOrientation(), this.currentPlayer));
	}


	public void throwDice()
	{
		this.valeurDe = this.de.getValeur();
		this.fireDiceThrown(new DiceEvent(this.valeurDe));
		this.moveAssam();
	}

	public void putCarpet(Coord coord1, Coord coord2)
	{
		Tapis carpet = new Tapis(this.currentPlayer, coord1, coord2);
		if(this.plateau.peutPlacerTapis(carpet))
		{
			carpet = this.joueurs[this.currentPlayer].getTapis();
			carpet.setPosition(coord1, coord2);
			this.plateau.placerTapis(carpet);
			this.fireCarpetPut(new CarpetEvent(true));
		}
		else
		{
			this.fireCarpetPut(new CarpetEvent(false));
		}
	}

	public Coord getAssamCoord()
	{
		return this.assam.getCoord();
	}

	public Assam getAssam()
	{
		return this.assam;
	}


}
