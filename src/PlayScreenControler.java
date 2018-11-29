import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

public class PlayScreenControler implements ActionListener{

	PlayScreen ps;
	Partie game;

	public PlayScreenControler(PlayScreen ps, Partie game){

		this.ps = ps;
		this.game = game;

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand() == "▲"){

			System.out.println("Up");

		}

		if(e.getActionCommand() == "◀"){

			System.out.println("Left");

		}

		if(e.getActionCommand() == "▶"){

			System.out.println("Right");

		}

		if(e.getActionCommand() == "▼"){

			System.out.println("Down");

		}

		if(e.getActionCommand() == "Lancer le dé"){

			int value = game.getDe().getValeur();
			ps.mp.messageChanged("Le dé a été lancé. Il vaut "+value+".");
			ps.mp.repaint();
			System.out.println(value);
			ps.lancerde.setEnabled(false);

		}
	}
}