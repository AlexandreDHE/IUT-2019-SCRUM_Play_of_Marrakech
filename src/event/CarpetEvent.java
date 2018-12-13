package event;

public class CarpetEvent implements Event
{
	private int player;
	protected boolean state;

	public CarpetEvent(int player, boolean state)
	{
		this.player = player;
		this.state = state;
	}

	public boolean getState()
	{
		return this.state;
	}

	public int getPlayer()
	{
		return this.player;
	}
}