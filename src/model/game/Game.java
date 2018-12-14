package model.game;

import javax.swing.event.EventListenerList;

import event.*;
import model.*;
import model.dirham.*;
import listener.modeltoview.*;

/**
	* Cette classe est responsable du bon fonctionnement de la partie 
    */
    

public class Game
{
	protected GameState state;
	
	protected Assam assam;
	protected De de;
	protected Joueur[] joueurs;
	protected int currentPlayer;
	protected int valeurDe;
	protected PlateauJeu plateau;
	protected Position carpetPosition;
	protected Position carpetOrientation;

	protected final EventListenerList listeners;

	public Game(int nombreJoueurs, int size, DirhamManager dirhamManager)
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
				joueurs[i] = new Joueur(i, paquet, dirhamManager);
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
				joueurs[i] = new Joueur(i, paquet, dirhamManager);
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
				joueurs[i] = new Joueur(i, paquet, dirhamManager);
				for(int j = 0; j < 12; j++)
				{
					paquet.addTapis(new Tapis(joueurs[i].getCouleur()));
				}
			}
		}

		assam = Assam.getAssam();
		de = De.getDe(6);
		this.state = GameState.NOTSTARTED;
	}

  	
 /**
 	* On utilise la surcharge pour adapter le plateau en fonction du nombre de joueur, 
    * ou des differentes options choisies
 */
  
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
		de = De.getDe(6);
		this.state = GameState.NOTSTARTED;
	}
	
 /** 
 	méthode appellée lors du lancement de la partie 
	*/
	public void start()
	{
		GameState oldState = this.state;
		this.state = GameState.STARTED;
		this.fireGameStateChanged(oldState,this.state);
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

    public void fireGameStateChanged(GameState oldState, GameState newState)
	{
		for(GameListener listener : this.getGameListeners()) 
		{
            listener.gameStateChanged(new GameEvent(oldState, newState, this.currentPlayer));
        }
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
  
  	public void moveAssam(int babouche)
	{
		this.assam.avancer(babouche);
		this.fireAssamMoved(new AssamEvent(babouche, this.currentPlayer));
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
		GameState oldState = this.state;
		this.state = GameState.CARPETPUT;
		this.fireGameStateChanged(oldState, this.state);
	}

	public boolean checkCarpet(Position coord1, Position coord2)
	{	
		Tapis carpet = new Tapis(this.currentPlayer, coord1, coord2);
		return this.plateau.peutPlacerTapis(carpet);
	}

	public void removeCarpet()
	{
		Tapis carpet = this.joueurs[this.currentPlayer].getTapis();
		Case[][] gameGrid = this.plateau.getGameGrid();
		for(int i = 0; i < gameGrid.length; i++)
		{
			for(int j = 0; j < gameGrid.length; j++)
			{
				if(carpet == gameGrid[i][j].recupererTapis())
				{
					gameGrid[i][j].removeCarpet();
				}
			}
		}
	}

	private boolean isGoodPosition(Position position)
	{
		int assamY = this.assam.getCoord().getX();
		int assamX = this.assam.getCoord().getY();

		Position[] positions = new Position[4];
		positions[0] = new Position(assamX + 1, assamY);
		positions[1] = new Position(assamX - 1, assamY);
		positions[2] = new Position(assamX , assamY + 1);
		positions[3] = new Position(assamX, assamY - 1);

		for(int i = 0; i < positions.length; i++)
		{
			if ((position.getX() == positions[i].getX()) && (position.getY() == positions[i].getY()))
			{
				return true;
			}
		}

		return false;
	}

	private boolean isGoodOrientation(Position position1, Position position2)
	{	
		if ((position2.getX() == -1) || (position2.getY() == -1))
		{
			return false;
		}
		if ((position2.getY() == this.assam.getCoord().getX()) || (position2.getX() == this.assam.getCoord().getY()))
		{
			return false;
		}

		Tapis carpet = new Tapis(this.currentPlayer, position1, position2);
		return this.plateau.peutPlacerTapis(carpet);
	}

	public void putCarpet(Position position)
	{
		if(isGoodPosition(position))
		{
			int positionX = position.getX();
			int positionY = position.getY();

			Position[] positions = new Position[4];
			positions[0] = new Position(positionX + 1, positionY);
			positions[2] = new Position(positionX - 1, positionY);
			positions[1] = new Position(positionX , positionY + 1);
			positions[3] = new Position(positionX, positionY - 1);

			Position coord2 = null;

			for(int i = 0; i < positions.length; i++)
			{
				if(isGoodOrientation(position, positions[i]))
				{
					coord2 = positions[i];
					break;
				}
			}

			if(coord2 != null)
			{
				this.removeCarpet();
				Tapis carpet = new Tapis(this.currentPlayer, position, coord2);
				if(this.plateau.peutPlacerTapis(carpet))
				{
					carpet = this.joueurs[this.currentPlayer].getTapis();
					carpet.setPosition(position, coord2);
					this.plateau.placerTapis(carpet);
					this.carpetPosition = position;
					this.carpetOrientation = coord2;
					this.fireCarpetPut(new CarpetEvent(this.currentPlayer, true));
					GameState oldState = this.state;
					this.state = GameState.CARPETORIENTED;
					this.fireGameStateChanged(oldState, this.state);
				}
				else
				{
					this.fireCarpetPut(new CarpetEvent(this.currentPlayer, false));
				}
			}
			else
			{
				this.fireCarpetPut(new CarpetEvent(this.currentPlayer, false));
			}
		}
		else
		{
			this.fireCarpetPut(new CarpetEvent(this.currentPlayer, false));
		}
	}

	public void rotateCarpetClockwise()
	{
		int positionX = this.carpetPosition.getX();
		int positionY = this.carpetPosition.getY();

		Position[] positions = new Position[4];
		positions[1] = new Position(positionX + 1, positionY);
		positions[3] = new Position(positionX - 1, positionY);
		positions[2] = new Position(positionX , positionY + 1);
		positions[0] = new Position(positionX, positionY - 1);

		int index = 0;

		for(int i = 0; i < positions.length; i++)
		{
			if(this.carpetOrientation == positions[i])
			{
				index = i;
			}
		}

		if(this.isGoodOrientation(this.carpetPosition,positions[index+1]))
		{
			this.removeCarpet();
			Tapis carpet = this.joueurs[this.currentPlayer].getTapis();
			carpet.setPosition(this.carpetPosition, this.carpetOrientation);
			this.plateau.placerTapis(carpet);
			this.carpetOrientation = positions[index+1];
			this.fireCarpetPut(new CarpetEvent(this.currentPlayer, true));
			System.out.println("lol");
		}
	}

	public void nextCarpet()
	{
		this.joueurs[this.currentPlayer].getCarpets().next();
	}

	public Position getAssamCoord()
	{
		return this.assam.getCoord();
	}

	public Assam getAssam()
	{
		return this.assam;
	}
	
	public Case[][] getGameGrid()
	{
		return this.plateau.getGameGrid();
	}

	public GameState getState()
	{
		return this.state;
	}
}
