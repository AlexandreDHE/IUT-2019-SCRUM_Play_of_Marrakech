package model.game;

import javax.swing.event.EventListenerList;

import event.*;
import model.*;
import model.dirham.*;
import listener.modeltoview.*;

/**
 * Représente une partie
 * Cette classe a pour rôle de servir d'intermediaires entre les differents modeles et la vue
*/
    
public class Game
{
	/**
	 * state est l'etat du jeu
	*/
	protected GameState state;
	
	/**
	 * le singleton Assam
	*/
	protected Assam assam;
	
	/**
	 * le singleton de
	*/
	protected Dice dice;
	
	/**
	 * un tableau de joueurs
	*/
	protected Player[] players;
	
	/**
	 * le joueur actuel
	*/
	protected int currentPlayer;
	
	/**
	 * la valeur du de apres l'avoir lance
	*/
	protected int diceValue;
	
	/**
	 * le plateau de jeu
	*/
	protected Grid grid;
	
	/**
	 * la position du nouveau tapis
	*/
	protected Position carpetPosition;
	
	/**
	 * les positions envisageables de la deuxieme case du nouveau tapis
	*/
	protected Position[] carpetOrientations;
	
	/**
	 * la position de la deuxieme case du nouveau tapis
	*/
	protected Position carpetOrientation;
	
	/**
	 * le nouveau tapis a pose sur la plateau de jeu
	*/
	protected Carpet newCarpet;
	
	/**
	 * liste de listeners
	*/
	protected final EventListenerList listeners;
	
	/**
	 * Constructeur permettant de creer une partie 
	 * @param nombreJoueurs est le nombre de joueur dans la partie
	 * @param size est la taille du plateau de jeu
	 * @param DirhamManager est la strategie a adopter pour distribuer aux joueurs les dirham
	*/
	public Game(int nombreJoueurs, int size, DirhamManager dirhamManager)
	{
		this.listeners = new EventListenerList();
		this.players = new Player[nombreJoueurs];
		this.currentPlayer = 0;
		this.grid = new Grid();

		if (nombreJoueurs == 2)
		{
			CarpetList paquet = new CarpetList();
			for(int i = 0; i < nombreJoueurs; i++)
			{
				players[i] = new Player(i, paquet, dirhamManager);
				for(int j = 0; j < 24; j++)
				{
					paquet.addTapis(new Carpet(players[i].getCouleur()));
				}
			}
			paquet.melanger();
		}

		else if (nombreJoueurs == 3)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				CarpetList paquet = new CarpetList();
				players[i] = new Player(i, paquet, dirhamManager);
				for(int j = 0; j < 15; j++)
				{
					paquet.addTapis(new Carpet(players[i].getCouleur()));
				}
			}
		}

		else if (nombreJoueurs == 4)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				CarpetList paquet = new CarpetList();
				players[i] = new Player(i, paquet, dirhamManager);
				for(int j = 0; j < 12; j++)
				{
					paquet.addTapis(new Carpet(players[i].getCouleur()));
				}
			}
		}

		assam = Assam.getAssam();
		dice = Dice.getDe(6);
		this.state = GameState.NOTSTARTED;
	}

  	
 /**
 	* On utilise la surcharge pour adapter le plateau en fonction du nombre de joueur, 
    * ou des differentes options choisies
 */
  
	public Game(int nombreJoueurs, int taille)
	{
		this.listeners = new EventListenerList();
		this.players = new Player[nombreJoueurs];
		this.currentPlayer = 0;
		this.grid = new Grid(taille);

		if (nombreJoueurs == 2)
		{
			CarpetList paquet = new CarpetList();
			for(int i = 0; i < nombreJoueurs; i++)
			{
				players[i] = new Player(i, paquet, new DirhamManagerVar());
				for(int j = 0; j < ((taille * taille)/nombreJoueurs); j++)
				{
					paquet.addTapis(new Carpet(players[i].getCouleur()));
				}
			}
			paquet.melanger();
		}

		else if (nombreJoueurs == 3)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				CarpetList paquet = new CarpetList();
				players[i] = new Player(i, paquet, new DirhamManagerVar());
				for(int j = 0; j < ((taille * taille)/nombreJoueurs); j++)
				{
					paquet.addTapis(new Carpet(players[i].getCouleur()));
				}
			}
		}

		else if (nombreJoueurs == 4)
		{
			for(int i = 0; i < nombreJoueurs; i++)
			{
				CarpetList paquet = new CarpetList();
				players[i] = new Player(i, paquet, new DirhamManagerVar());
				for(int j = 0; j < ((taille * taille)/nombreJoueurs); j++)
				{
					paquet.addTapis(new Carpet(players[i].getCouleur()));
				}
			}
		}

		assam = Assam.getAssam();
		dice = Dice.getDe(6);
		this.state = GameState.NOTSTARTED;
	}
	
 /** 
 	* methode appellee lors du lancement de la partie 
	*/
	public void start()
	{
		GameState oldState = this.state;
		this.state = GameState.STARTED;
		this.fireGameStateChanged(oldState,this.state);
	}
	
	 /** 
 	* permet d'ajouter un assamListener dans la liste des listeners 
 	* @param AssamListener
	*/
	public void addAssamListener(AssamListener listener)
	{
		this.listeners.add(AssamListener.class, listener);
	}
	
	 /** 
 	* permet d'ajouter un GameListener dans la liste des listeners 
 	* @param GameListener
	*/
	public void addGameListener(GameListener listener)
	{
		this.listeners.add(GameListener.class, listener);
	}
	
	 /** 
 	* permet d'ajouter un DiceListener dans la liste des listeners 
 	* @param DiceListener
	*/
	public void addDiceListener(DiceListener listener)
	{
		this.listeners.add(DiceListener.class, listener);
	}

	 /** 
 	* permet d'ajouter un CarpetListener dans la liste des listeners 
 	* @param CarpetListener
	*/
	public void addCarpetListener(CarpetListener listener)
	{
		this.listeners.add(CarpetListener.class, listener);
	}
	
	 /** 
 	* permet d'ajouter un PlayerListener dans la liste des listeners 
 	* @param PlayerListener
	*/
	public void addPlayerListener(PlayerListener listener)
	{
		this.listeners.add(PlayerListener.class, listener);
	}
	
	 /** 
 	* @return les GameListeners
	*/
	public GameListener[] getGameListeners() 
	{
        return listeners.getListeners(GameListener.class);
    }

	 /** 
 	* @return les AssamListeners
	*/
    public AssamListener[] getAssamListeners() 
	{
        return listeners.getListeners(AssamListener.class);
    }

    /** 
 	* @return les DiceListeners
	*/
    public DiceListener[] getDiceListeners() 
	{
        return listeners.getListeners(DiceListener.class);
    }

    /** 
 	* @return les CarpetListeners
	*/
    public CarpetListener[] getCarpetListeners() 
	{
        return listeners.getListeners(CarpetListener.class);
    }
    
    /** 
 	* @return les PlayerListeners
	*/
    public PlayerListener[] getPlayerListeners() 
	{
        return listeners.getListeners(PlayerListener.class);
    }

    /** 
 	* previent les GameListeners d'un changement d'etat de jeu
 	* @param oldState est l'ancient etat
 	* @param newState est le nouvel etat
	*/
    public void fireGameStateChanged(GameState oldState, GameState newState)
	{
		for(GameListener listener : this.getGameListeners()) 
		{
            listener.gameStateChanged(new GameEvent(oldState, newState, this.currentPlayer, this.currentPlayer));
        }
	}

    /** 
 	* previent les AssamListeners que l'orientation d'Assam a changée
 	* @param event est un objet possedant la nouvelle orientation d'Assam
	*/
    public void fireAssamOriented(AssamEvent event)
	{
		for(AssamListener listener : this.getAssamListeners()) 
		{
            listener.assamOriented(event);
        }
	}

    /** 
 	* previent les AssamListeners que la position d'Assam a changée
 	* @param event est un objet possedant la nouvelle position d'Assam
	*/
	public void fireAssamMoved(AssamEvent event)
	{
		for(AssamListener listener : this.getAssamListeners()) 
		{
            listener.assamMoved(event);
        }
	}
	
	/** 
 	* previent les DiceListeners que le de a ete lance
 	* @param event est un objet possedant la valeur du de et le joueur qui l'a lance
	*/
	public void fireDiceThrown(DiceEvent event)
	{
		for(DiceListener listener : this.getDiceListeners()) 
		{
            listener.diceThrown(event);
        }
	}

	/** 
 	* previent les CarpetListeners qu'un tapis a ete pose ou non
 	* @param event est un objet possedant une reference vers le tapis pose
	*/
	public void fireCarpetPut(CarpetEvent event)
	{
		for(CarpetListener listener : this.getCarpetListeners()) 
		{
            listener.carpetPut(event);
        }
	}
	
	/** 
 	* previent les PlayerListeners qu'un joueur a paye
 	* @param event est un objet possedant le prix de la dime
	*/
	public void firePlayerPaid(PlayerEvent event)
	{
		for(PlayerListener listener : this.getPlayerListeners()) 
		{
            listener.playerPaid(event);
        }
	}

	/** 
 	* @return les joueurs
	*/
	public Player[] getPlayers()
	{
		return this.players;
	}

	/** 
 	* @return le de
	*/
	public Dice getDice()
	{
		return this.dice;
	}
	
	/** 
 	* deplace Assam
	*/
	public void moveAssam()
	{
		this.assam.avancer(this.diceValue);
		this.fireAssamMoved(new AssamEvent(this.diceValue, this.currentPlayer));
		
		/*if(this.isAssamOnCarpet() != -1)
		{
			int price = this.plateau.payerDime(this.assam, this.joueurs[this.currentPlayer]);
			this.joueurs[this.currentPlayer].payerDime(price, this.joueurs[this.currentPlayer]);
			firePlayerPaid(new PlayerEvent(this.currentPlayer, price));
		}*/
	}
	
	/** 
 	* @return -1 si Assam n'est pas sur un tapis
 	* @return le numero du joueur si Assam est sur un tapis
	*/
	private int isAssamOnCarpet()
	{
		Position assamPosition = this.assam.getCoord();
		Case[][] grid = this.grid.getGameGrid();
		if(grid[assamPosition.getY()][assamPosition.getX()].recupererTapis() != null)
		{
			return grid[assamPosition.getY()][assamPosition.getX()].recupererTapis().getCouleur();
		}
		
		return -1;
	}
  
	/** 
 	* deplace Assam
 	* @param babouche pour la variante
	*/
  	public void moveAssam(int babouche)
	{
		this.assam.avancer(babouche);
		this.fireAssamMoved(new AssamEvent(babouche, this.currentPlayer));
	}
  
  	/** 
 	* fait tourner Assam dans le sens anti-horaire
	*/
	public void rotateAssamCounterClockwise()
	{
		this.assam.tournerAntiHorraire();
		this.fireAssamOriented(new AssamEvent(this.assam.getOrientation(), this.currentPlayer));
	}

	/** 
 	* fait tourner Assam dans le sens horaire
	*/
	public void rotateAssamClockwise()
	{
		this.assam.tournerHorraire();
		this.fireAssamOriented(new AssamEvent(this.assam.getOrientation(), this.currentPlayer));
	}

	/** 
 	* lance le de
	*/
	public void throwDice()
	{
		this.diceValue = this.dice.getValeur();
		this.fireDiceThrown(new DiceEvent(this.diceValue));
		this.moveAssam();
		GameState oldState = this.state;
		this.state = GameState.CARPETPUT;
		this.fireGameStateChanged(oldState, this.state);
	}
	
	/** 
 	* @return true si le tapis peut etre pose
 	* @return false sinon
	*/	
	public boolean checkCarpet(Position coord1, Position coord2)
	{	
		Carpet carpet = new Carpet(this.currentPlayer, coord1, coord2);
		return this.grid.peutPlacerTapis(carpet);
	}
	
	/**
	 * @param la position du tapis 
 	* @return true si le tapis est pose dans un case adjacente a celle d'Assam
 	* @return false sinon
	*/	
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

	/**
	 * @param la position1 de la premiere case du tapis 
	 * @param la position2 de la deuxieme case du tapis 
 	* @return true si le tapis peut etre oriente de cette maniere
 	* @return false sinon
	*/	
	private boolean isGoodOrientation(Position position1, Position position2)
	{	
		if ((position2.getX() == -1) || (position2.getY() == -1))
		{
			return false;
		}
		if ((position2.getY() == this.assam.getCoord().getX()) && (position2.getX() == this.assam.getCoord().getY()))
		{
			return false;
		}

		Carpet carpet = new Carpet(this.currentPlayer, position1, position2);
		return this.grid.peutPlacerTapis(carpet);
	}
	
	/**
 	* @return le nouveau tapis a pose
	*/
	public Carpet getNewCarpet()
	{	
		return this.newCarpet;
	}

	/**
 	* creer un nouveau tapis a pose dans le plateau de jeu
	*/
	public void putCarpet(Position position)
	{
		if(this.isGoodPosition(position))
		{
			int positionX = position.getX();
			int positionY = position.getY();

			Position[] positions = new Position[4];
			positions[0] = new Position(positionX + 1, positionY);
			positions[2] = new Position(positionX - 1, positionY);
			positions[1] = new Position(positionX , positionY + 1);
			positions[3] = new Position(positionX, positionY - 1);

			this.carpetOrientations = positions;

			Position coord2 = null;
			boolean orientation = false;

			for(int i = 0; i < positions.length; i++)
			{
				if(!orientation)
				{
					if(this.isGoodOrientation(position, positions[i]))
					{
						orientation = true;
						coord2 = positions[i];
					}
				}
			}
			
			if(orientation)
			{
				Carpet carpet = new Carpet(this.currentPlayer, position, coord2);
				if(this.grid.peutPlacerTapis(carpet))
				{
					this.newCarpet = this.players[this.currentPlayer].getTapis();
					this.newCarpet.setPosition(position, coord2);
					this.carpetPosition = position;
					this.carpetOrientation = coord2;
					this.fireCarpetPut(new CarpetEvent(this.currentPlayer, this.newCarpet, true));
					GameState oldState = this.state;
					this.state = GameState.CARPETPUT;
					this.fireGameStateChanged(oldState, this.state);
				}
				else
				{
					this.fireCarpetPut(new CarpetEvent(this.currentPlayer, null, false));
				}
			}
			else
			{
				this.fireCarpetPut(new CarpetEvent(this.currentPlayer, null, false));
			}
			
		}
		else
		{
			this.fireCarpetPut(new CarpetEvent(this.currentPlayer, null, false));
		}
	}
	
	/**
 	* tourne le tapis dans le sens horaire
	*/
	public void rotateCarpetClockwise()
	{
		int index = 0;
		for(int i = 0; i < this.carpetOrientations.length; i++)
		{
			if(this.carpetOrientations[i] == this.carpetOrientation)
			{
				index = i;
				break;
			}
		}

		int cpt = 0;
		do
		{
			if(cpt == 4)
			{
				return;
			}
			index--;
			if(index < 0)
			{
				index = 3;
			}
			cpt++;
		} while(!this.isGoodOrientation(this.carpetPosition, this.carpetOrientations[index]));

		if(this.carpetOrientations[index] != this.carpetOrientation)
		{
			this.newCarpet = this.players[this.currentPlayer].getTapis();
			this.newCarpet.setPosition(this.carpetPosition, this.carpetOrientations[index]);
			this.carpetOrientation = this.carpetOrientations[index];
			this.fireCarpetPut(new CarpetEvent(this.currentPlayer, this.newCarpet, true));
		}
		
		
	}

	/**
 	* tourne le tapis dans le sens anti-horaire
	*/
	public void rotateCarpetCounterClockwise()
	{
		int index = 0;
		for(int i = 0; i < this.carpetOrientations.length; i++)
		{
			if(this.carpetOrientations[i] == this.carpetOrientation)
			{
				index = i;
				break;
			}
		}

		int cpt = 0;
		do
		{
			if(cpt == 4)
			{
				return;
			}
			index++;
			if(index > 3)
			{
				index = 0;
			}
			cpt++;
		} while(!this.isGoodOrientation(this.carpetPosition, this.carpetOrientations[index]));

		if(this.carpetOrientations[index] != this.carpetOrientation)
		{
			this.newCarpet = this.players[this.currentPlayer].getTapis();
			this.newCarpet.setPosition(this.carpetPosition, this.carpetOrientations[index]);
			this.carpetOrientation = this.carpetOrientations[index];
			this.fireCarpetPut(new CarpetEvent(this.currentPlayer, this.newCarpet, true));
		}
	}

	/**
 	* pose definitivement le nouveau tapis dans le plateau de jeu
	*/
	public void nextCarpet()
	{
		this.grid.placerTapis(this.newCarpet);
		GameState oldState = this.state;
		this.state = GameState.CARPETPUTVALIDATE;
		this.fireGameStateChanged(oldState, this.state);
		this.players[this.currentPlayer].getCarpets().next();
		this.currentPlayer++;
		if(this.currentPlayer == this.players.length)
		{
			this.currentPlayer = 0;
		}
		
		oldState = this.state;
		this.state = GameState.ASSAMORIENTED;
		this.fireGameStateChanged(oldState, this.state);
	}

	/**
 	* @return la position d'Assam dans la grille
	*/
	public Position getAssamCoord()
	{
		return this.assam.getCoord();
	}

	/**
 	* @return Assam
	*/
	public Assam getAssam()
	{
		return this.assam;
	}
	
	/**
 	* @return le plateau de jeu
	*/
	public Case[][] getGameGrid()
	{
		return this.grid.getGameGrid();
	}

	/**
 	* @return l'etat de 
	*/
	public GameState getState()
	{
		return this.state;
	}
}