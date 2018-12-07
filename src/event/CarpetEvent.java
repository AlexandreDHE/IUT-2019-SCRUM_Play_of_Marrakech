package event;

public class CarpetEvent implements Event
{
	protected boolean state;

	public CarpetEvent(boolean state)
	{
		this.state = state;
	}

	public boolean getState()
	{
		return this.state;
	}
}