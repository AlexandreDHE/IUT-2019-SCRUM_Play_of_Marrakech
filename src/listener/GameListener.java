package listener;
import java.util.EventListener;

import event.GameEvent;

public interface GameListener extends EventListener
{
	public void gameStateChanged(GameEvent event);
	public void gameStarted(GameEvent event);
	public void gameFinished(GameEvent event);
}
