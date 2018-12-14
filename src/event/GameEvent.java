package event;

import model.game.GameState;

public class GameEvent implements Event
{
	protected GameState oldState;
	protected GameState newState;
	private int oldPlayer;
	private int newPlayer;

	public GameEvent(GameState oldState, GameState newState, int oldPlayer, int newPlayer)
	{
		this.oldState = oldState;
		this.newState = newState;
		this.oldPlayer = oldPlayer;
		this.newPlayer = newPlayer;
	}

	public GameState getOldState()
	{
		return this.oldState;
	}
	public GameState getNewState()
	{
		return this.newState;
	}

	public int getOldPlayer()
	{
		return this.oldPlayer;
	}

	public int getNewPlayer()
	{
		return this.newPlayer;
	}
}