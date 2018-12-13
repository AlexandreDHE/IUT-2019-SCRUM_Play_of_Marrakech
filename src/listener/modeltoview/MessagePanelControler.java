package listener.modeltoview;

import java.util.EventListener;

import model.Assam;
import model.Position;
import model.game.*;
import event.*;
import view.*;
import listener.modeltoview.*;

import event.*;

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
		/*NOTSTARTED(0),
  STARTED(1),
  ASSAMORIENTED(2),
  DICETHROWN(3),
  ASSAMMOVED(4),
  DIHMPAID(5),
  CARPETPUT(6),
  CARPETORIENTED(7),
  CARPETVALIDATE(8),
  OVER(9);*/
  		GameState gameState = event.getNewState();
  		if (gameState == GameState.STARTED)
  		{
  			this.messagepanel.setMessage("La partie a commence !");
  		}
  		else if(gameState == GameState.CARPETPUT)
  		{
  			this.messagepanel.setMessage("Au tour du joueur " + (event.getPlayer() + 1) + " de poser son tapis en cliquant sur une case.");
  			  			this.playScreen.enableButtons(true, this.playScreen.getCarpetOrientationButtons());
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
		this.playScreen.drawCenter();
		this.messagepanel.setMessage("Le joueur " + (event.getPlayer()+1) + " a posé son tapis.");
	}

	@Override
	public void carpetOriented(CarpetEvent event) {

		this.messagepanel.setMessage("Le joueur " + (event.getPlayer()+1) + " a oriente son tapis.");
		
	}
}
