package listener.modeltoview;

import java.util.EventListener;

import event.PlayerEvent;

public interface PlayerListener extends EventListener
{
	public void playerPaid(PlayerEvent event);
	public void playerLost(PlayerEvent event);
}
