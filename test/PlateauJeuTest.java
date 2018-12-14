import model.*;
import model.dirham.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * maintest
 */
public class PlateauJeuTest {

	@Test
	public void compterAvecDiagonal(){
		DirhamManagerClassic manager = new DirhamManagerClassic();
		PaquetTapis p1 = new PaquetTapis();
		PaquetTapis p2 = new PaquetTapis();
		
		for (int i = 0; i < 4; i++) {
			p1.addTapis(new Tapis(Couleur.JOUEUR1));
		}
		for (int i = 0; i < 4; i++) {
			p2.addTapis(new Tapis(Couleur.JOUEUR2));
		}
		Joueur j1 = new Joueur(0, p1, manager);
		Joueur j2 = new Joueur(1, p2, manager);

		PlateauJeu p = new PlateauJeu();

		j2.getTapis().setPosition(new Position(3, 3), new Position(3, 4));
		p.placerTapis(j2.getTapis());
		p2.next();
		j2.getTapis().setPosition(new Position(3, 5), new Position(3, 6));
		p.placerTapis(j2.getTapis());
		p2.next();
		j2.getTapis().setPosition(new Position(3, 6), new Position(4, 6));
		p.placerTapis(j2.getTapis());
		p2.next();

		Assam ass = Assam.getAssam();

		int c = p.payerDime(ass, j1);

		assertEquals(c, 5);
	}

	//public static void main(String[] args) {
		// supersosition tapis
		// 5
		// PlateauJeu p = new PlateauJeu();
		// Joueur j1 = new Joueur(0, 10);
		// Joueur j2 = new Joueur(1, 10);

		// j2.setTapisCoord(0, new Coord(3, 3), new Coord(3, 4));
		// j2.setTapisCoord(1, new Coord(3, 5), new Coord(3, 6));
		// j2.setTapisCoord(2, new Coord(3 , 6), new Coord(4, 6));

		// p.placerTapis(j2.getTapis()[0]);
		// p.placerTapis(j2.getTapis()[1]);
		// p.placerTapis(j2.getTapis()[2]);


		// Assam ass = Assam.getAssam();

		// tapis diagonal
		// 4
		// PlateauJeu p = new PlateauJeu();
		// Joueur j1 = new Joueur(0, 10);
		// Joueur j2 = new Joueur(1, 10);

		// j2.setTapisCoord(0, new Coord(3, 3), new Coord(3, 4));
		// j2.setTapisCoord(1, new Coord(3, 5), new Coord(3, 6));
		// j2.setTapisCoord(3, new Coord(4, 2), new Coord(5, 2));

		// p.placerTapis(j2.getTapis()[0]);
		// p.placerTapis(j2.getTapis()[1]);
		// p.placerTapis(j2.getTapis()[3]);

		// Assam ass = Assam.getAssam();

		// clasique
		// 6
		// PlateauJeu p = new PlateauJeu();
		// Joueur j1 = new Joueur(0, 10);
		// Joueur j2 = new Joueur(1, 10);

		// j2.setTapisCoord(0, new Coord(3, 3), new Coord(3, 4));
		// j2.setTapisCoord(1, new Coord(4, 3), new Coord(4, 4));
		// j2.setTapisCoord(3, new Coord(5, 4), new Coord(6, 4));

		// p.placerTapis(j2.getTapis()[0]);
		// p.placerTapis(j2.getTapis()[1]);
		// p.placerTapis(j2.getTapis()[3]);

		// Assam ass = Assam.getAssam();

		// clasique separé joueur actuel
		// 2
		// PlateauJeu p = new PlateauJeu();
		// Joueur j1 = new Joueur(0, 10);
		// Joueur j2 = new Joueur(1, 10);

		// j2.setTapisCoord(0, new Coord(3, 3), new Coord(3, 4));
		// j1.setTapisCoord(0, new Coord(4, 3), new Coord(4, 4));
		// j2.setTapisCoord(1, new Coord(5, 4), new Coord(6, 4));

		// p.placerTapis(j2.getTapis()[0]);
		// p.placerTapis(j1.getTapis()[0]);
		// p.placerTapis(j2.getTapis()[1]);

		// Assam ass = Assam.getAssam();

		// p.payerDime(ass, j1);

		// clasique separé joueur actuel
		// 2
		// PlateauJeu p = new PlateauJeu();
		// Joueur j1 = new Joueur(0, 10);
		// Joueur j2 = new Joueur(1, 10);

		// j2.setTapisCoord(0, new Coord(3, 3), new Coord(3, 4));
		// j1.setTapisCoord(0, new Coord(4, 3), new Coord(4, 4));
		// j2.setTapisCoord(1, new Coord(5, 4), new Coord(6, 4));

		// p.placerTapis(j2.getTapis()[0]);
		// p.placerTapis(j1.getTapis()[0]);
		// p.placerTapis(j2.getTapis()[1]);

		// Assam ass = Assam.getAssam();

		// p.payerDime(ass, j2);

	//}
}