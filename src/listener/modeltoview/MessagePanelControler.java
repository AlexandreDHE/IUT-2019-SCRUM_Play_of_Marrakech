package listener.modeltoview;

import java.util.EventListener;

import model.Assam;
import model.Position;
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
		this.messagepanel.setMessage("La partie a commencee !");
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
	}

	@Override
	public void carpetOriented(CarpetEvent event) {
		// TODO Auto-generated method stub
		
	}
}
