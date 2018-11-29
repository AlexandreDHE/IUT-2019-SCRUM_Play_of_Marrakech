public class PartieEvent implements Event
{
	public final static int PARTIECOMMENCE = 0;
	public final static int PARTIEFINIE = 1;

	protected int event;

	public Event(int event)
	{
		this.event = event;
	}

	public int getEvent()
	{
		return this.event;
	}
}