import java.util.Scanner;

public class OrientationTerminal implements OrientationListener
{
	public void orienter(Assam assam)
	{
		System.out.println("0 - Sens horraire\n1 - Sens trigo");
		Scanner s = new Scanner(System.in);
		if(s.nextInt() == 0)
			assam.tournerHorraire();
		else
			assam.tournerAntiHorraire();
	}
}