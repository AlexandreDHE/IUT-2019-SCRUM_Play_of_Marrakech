package event;

public class DiceEvent implements Event
{
	protected int value;

	public DiceEvent(int value)
	{
		this.value = value;
	}

	public int getState()
	{
		return this.value;
	}
}