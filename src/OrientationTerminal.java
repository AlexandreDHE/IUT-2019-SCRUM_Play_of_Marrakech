import java.util.Scanner;

public class OrientationTerminal implements OrientationListener
{
	public void orienter(Assam assam)
	{
		System.out.println("0 - Ne pas changer l'orientation\n1 - Sens horraire\n2 - Sens trigo");
		Scanner s = new Scanner(System.in);

		if(s.nextInt() == 1)
			assam.tournerHorraire();
		else if(s.nextInt() == 2)
			assam.tournerAntiHorraire();
	}
}