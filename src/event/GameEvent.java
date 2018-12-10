package event;

import model.game.GameState;

public class GameEvent implements Event
{
	protected GameState oldState;
	protected GameState newState;

	public GameEvent(GameState oldState, GameState newState)
	{
		this.oldState = oldState;
		this.newState = newState;
	}

	public GameState getOldState()
	{
		return this.oldState;
	}
	public GameState getNewState()
	{
		return this.newState;
	}
}