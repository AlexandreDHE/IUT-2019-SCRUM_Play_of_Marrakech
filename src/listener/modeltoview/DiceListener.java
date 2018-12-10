package listener.modeltoview;

import java.util.EventListener;
import event.DiceEvent;

public interface DiceListener extends EventListener
{
	public void diceThrown(DiceEvent event);
}
