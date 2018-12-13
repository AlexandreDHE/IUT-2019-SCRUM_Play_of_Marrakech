import model.*;
import model.dirham.DirhamManagerClassic;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * UndoRedo
 */
public class UndoRedoTest {

	@Test
	public static void undo(String[] args) {
		DirhamManagerClassic manager = new DirhamManagerClassic();
		Joueur j1 = new Joueur(0, new PaquetTapis(), manager);
		Joueur j2 = new Joueur(1, new PaquetTapis(), manager);

		Joueur[] joueurs = {j1,j2};
		PlateauJeu p = new PlateauJeu();
		Assam a = Assam.getAssam();

		boolean b;

		UndoRedo ur = new UndoRedo(joueurs, p, a);
		ur.save();

		a.setCoord(new Position(1,1));
		ur.save();

		a.setCoord(new Position(2,2));
		ur.save();

		a.setCoord(new Position(5,5));

		b = ur.undo();
		test(a, 2,2);

		b = ur.redo();
		test(a, 1,1);


	}


	private static void test(Assam a, int x, int y){
		assertEquals(x, a.getCoord().getX());
		assertEquals(y, a.getCoord().getY());
	}
}