package event;

public class AssamEvent implements Event
{
	protected int value;
	protected int player;

	public AssamEvent(int value, int player)
	{
		this.value = value;
		this.player = player;
	}

	public int getValue()
	{
		return this.value;
	}

	public int getPlayer()
	{
		return this.player;
	}
}