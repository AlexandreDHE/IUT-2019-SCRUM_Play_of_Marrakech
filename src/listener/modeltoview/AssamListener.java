package listener.modeltoview;

import java.util.EventListener;

import event.AssamEvent;

public interface AssamListener extends EventListener
{
	public void assamMoved(AssamEvent event);
	public void assamOriented(AssamEvent event);
}
