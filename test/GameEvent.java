package event;

import listener.Event;

public class GameEvent implements Event
{
	protected int oldState;
	protected int newState;

	public GameEvent(int oldState, int newState)
	{
		this.oldState = oldState;
		this.newState = newState;
	}

	public int getOldState()
	{
		return this.oldState;
	}
	public int getNewState()
	{
		return this.newState;
	}
}