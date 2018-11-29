import java.util.Scanner;

public class StrategieOrientationTerminal implements StrategieOrientation
{
	public void orienter(Assam assam)
	{
		int valeur = 0;
		Scanner s = new Scanner(System.in);
		
		valeur = s.nextInt();

		if(valeur == 0)
			assam.tournerHorraire();
		else if(valeur == 1)
			assam.tournerAntiHorraire();
	}
}