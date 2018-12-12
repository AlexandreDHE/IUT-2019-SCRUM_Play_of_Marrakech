package listener.viewtomodel;

import java.awt.*;  
import javax.swing.*;

import model.*;
import model.game.*;
import view.PlayScreen;

import java.awt.event.*;

public class PlayScreenControler implements ActionListener{

	public PlayScreen ps;
	public Game game;
	public int orientation;

	public PlayScreenControler(PlayScreen ps, Game game){

		this.ps = ps;
		this.game = game;

	}

	public void actionPerformed(ActionEvent e) {

		orientation = game.getAssam().getOrientation();

		if(e.getActionCommand() == "Ne pas orienter"){

			this.ps.getDiceButton().setEnabled(true);

		}

		else if(e.getActionCommand() == "Tourner dans le sens anti-horaire"){
			
				game.rotateAssamCounterClockwise();
				orientation = game.getAssam().getOrientation();
			ps.getAssamPanel().setAssam(orientation);
			this.ps.getDiceButton().setEnabled(true);

		}

		else if(e.getActionCommand() == "Tourner dans le sens horaire"){

				game.rotateAssamClockwise();
				orientation = game.getAssam().getOrientation();
				ps.getAssamPanel().setAssam(orientation);
			this.ps.getDiceButton().setEnabled(true);

		}

		if(e.getActionCommand() == "Lancer le dé"){
			game.throwDice();
			ps.mp.repaint();
			ps.lancerde.setEnabled(false);

		}
	}
}