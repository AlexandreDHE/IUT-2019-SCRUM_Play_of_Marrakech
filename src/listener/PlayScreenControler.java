package listener;

import java.awt.*;  
import javax.swing.*;

import model.Game;
import view.PlayScreen;

import java.awt.event.*;

public class PlayScreenControler implements ActionListener{

	public PlayScreen ps;
	public Game game;

	public PlayScreenControler(PlayScreen ps, Game game){

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
			ps.getLabelDe().setText("Le dé vaut "+value+"."); //affiche la valeur du dé après le lancer
			ps.mp.repaint();
			ps.lancerde.setEnabled(false);

		}
	}
}