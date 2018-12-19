package event;

public class PlayerEvent implements Event
{
	protected int player;
	protected int price;

	public PlayerEvent(int player, int price)
	{
		this.player = player;
		this.price = price;
	}

	public int getPlayer()
	{
		return this.player;
	}
	
	public int getPrice()
	{
		return this.price;
	}
}