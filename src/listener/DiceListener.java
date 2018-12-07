package listener;
import java.util.EventListener;
import event.DiceEvent;

public interface DiceListener extends EventListener
{
	public void diceThrown(DiceEvent event);
}
