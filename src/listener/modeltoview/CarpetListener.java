package listener.modeltoview;

import java.util.EventListener;
import event.CarpetEvent;

public interface CarpetListener extends EventListener
{
	public void carpetPut(CarpetEvent event);
}
