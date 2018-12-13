package event;

import model.game.GameState;

public class GameEvent implements Event
{
	protected GameState oldState;
	protected GameState newState;
	private int player;

	public GameEvent(GameState oldState, GameState newState, int player)
	{
		this.oldState = oldState;
		this.newState = newState;
		this.player = player;
	}

	public GameState getOldState()
	{
		return this.oldState;
	}
	public GameState getNewState()
	{
		return this.newState;
	}

	public int getPlayer()
	{
		return this.player;
	}
}