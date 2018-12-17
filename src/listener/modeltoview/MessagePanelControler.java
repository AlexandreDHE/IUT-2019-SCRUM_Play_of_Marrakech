package listener.modeltoview;

import java.util.EventListener;

import model.Assam;
import model.Position;
import model.game.*;
import event.*;
import view.*;
import listener.modeltoview.*;

import event.*;

/**
* La classe MessagePanelControler est le contrôleur de la classe MessagePanel.
* Ce contrôleur permet de gérer les messages à afficher au cours de la partie, 
* liés aux actions des joueurs et au déroulement du jeu.
* 
* @see MessagePanel
* @see GameState
*/

public class MessagePanelControler implements GameListener, DiceListener, AssamListener, CarpetListener
{
	private MessagePanel messagepanel;
	private PlayScreen playScreen;

	public MessagePanelControler(MessagePanel messagepanel, PlayScreen playScreen)
	{
		this.messagepanel = messagepanel;
		this.playScreen = playScreen;
	}

	public void gameStateChanged(GameEvent event)
	{
  		GameState gameState = event.getNewState();
  		GameState oldState = event.getOldState();
  		if (gameState == GameState.STARTED)
  		{
  			this.messagepanel.setMessage("La partie a commence !");
  		}
  		else if(gameState == GameState.ASSAMORIENTED)
  		{
  			this.playScreen.getScorePanel(event.getOldPlayer()).refreshCarpetDisplay();
  			this.messagepanel.setMessage("Au tour du joueur " + (event.getNewPlayer() + 1) + " d'orienter Assam");
  			this.playScreen.enableButtons(false, this.playScreen.getCarpetOrientationButtons());
  			this.playScreen.enableButtons(true, this.playScreen.getAssamOrientationButtons());
  		}

  		else if(gameState == GameState.CARPETPUT)
  		{
  			if(oldState == GameState.CARPETPUT)
  			{
  				this.playScreen.enableButtons(true, this.playScreen.getCarpetOrientationButtons());
  			}

  			this.messagepanel.setMessage("Au tour du joueur " + (event.getNewPlayer() + 1) + " de poser son tapis en cliquant sur une case.");

  		}
  		else if(gameState == GameState.CARPETORIENTED)
  		{

  		}
	}

	public void diceThrown(DiceEvent event)
	{
		this.messagepanel.setMessage("Le de vaut "+event.getState()+".");
	}

	public void assamMoved(AssamEvent event)
	{
		this.messagepanel.setMessage("Assam a avance de " + event.getValue() + " cases.");
		this.playScreen.drawCenter();
	}

	public void assamOriented(AssamEvent event)
	{
		String str = new String();

		switch (event.getValue()) {

			case Assam.NORD: str = "le Nord"; break;
			case Assam.SUD: str = "le Sud"; break;
			case Assam.EST: str = "l'Est"; break;
			case Assam.OUEST: str = "l'Ouest"; break;

			default: str = "?"; break;
		}

		this.messagepanel.setMessage("Le joueur " + (event.getPlayer()+1) + " a oriente Assam vers " +str+".");
	}
	
	public void carpetPut(CarpetEvent event)
	{
		if(event.getState())
		{
			this.playScreen.drawCenter();
			this.messagepanel.setMessage("Le joueur " + (event.getPlayer()+1) + " a posé son tapis.");
		}
		else
		{
			this.messagepanel.setMessage("Cliquez sur une case près d'Assam !");
		}

	}

	@Override
	public void carpetOriented(CarpetEvent event) {

		this.messagepanel.setMessage("Le joueur " + (event.getPlayer()+1) + " a oriente son tapis.");
		
	}
}
