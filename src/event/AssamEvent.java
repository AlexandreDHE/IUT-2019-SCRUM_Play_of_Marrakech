package event;

public class AssamEvent implements Event
{
	protected int value;

	public AssamEvent(int value)
	{
		this.value = value;
	}

	public int getState()
	{
		return this.value;
	}
}