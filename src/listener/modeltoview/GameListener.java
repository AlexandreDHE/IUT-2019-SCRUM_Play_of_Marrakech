package listener.modeltoview;

import java.util.EventListener;

import event.GameEvent;

public interface GameListener extends EventListener
{
	public void gameStateChanged(GameEvent event);
}
