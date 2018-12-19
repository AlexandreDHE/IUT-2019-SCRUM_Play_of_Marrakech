package event;

import model.Carpet;

public class CarpetEvent implements Event
{
	private int player;
	protected boolean state;
	private Carpet newCarpet;

	public CarpetEvent(int player, Carpet newCarpet, boolean state)
	{
		this.player = player;
		this.newCarpet = newCarpet;
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
	
	public Carpet getNewCarpet()
	{
		return this.newCarpet;
	}
}