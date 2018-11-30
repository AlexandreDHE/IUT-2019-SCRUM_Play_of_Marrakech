package listener;
import java.util.EventListener;

import view.*;

import event.GameEvent;

public class MessagePanelControler implements GameListener
{
	private MessagePanel messagepanel;

	public MessagePanelControler(MessagePanel messagepanel)
	{
		this.messagepanel = messagepanel;
	}

	public void gameStateChanged(GameEvent event)
	{
	}

	public void gameStarted(GameEvent event)
	{
		this.messagepanel.setMessage("La partie a commencé !");
	}

	public void gameFinished(GameEvent event)
	{
	}
}
