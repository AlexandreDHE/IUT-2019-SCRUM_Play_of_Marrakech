package listener.viewtomodel;

import java.awt.*;  
import javax.swing.*;

import model.*;
import model.game.*;
import view.PlayScreen;

import java.awt.event.*;

/**
* La classe PlayScreenControler est le contrôleur de la classe PlayScreen.
* Ce contrôleur permet de gérer les JButton disposés en bas de la fenêtre de jeu,
* permettant de réaliser des actions durant la partie.
* 
* @see PlayScreen
*/

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

			ps.enableButtons(false, ps.getAssamOrientationButtons());
			this.ps.getDiceButton().setEnabled(true);

		}else if(e.getActionCommand() == "Tourner dans le sens anti-horaire"){
			
			game.rotateAssamCounterClockwise();
			orientation = game.getAssam().getOrientation();
			ps.getAssamPanel().setAssam(orientation);
			ps.enableButtons(false, ps.getAssamOrientationButtons());
			this.ps.getDiceButton().setEnabled(true);

		}else if(e.getActionCommand() == "Tourner dans le sens horaire"){

			game.rotateAssamClockwise();
			orientation = game.getAssam().getOrientation();
			ps.getAssamPanel().setAssam(orientation);
			ps.enableButtons(false, ps.getAssamOrientationButtons());
			this.ps.getDiceButton().setEnabled(true);
		}

		else if(e.getActionCommand() == "Tourner le tapis dans le sens horaire"){
			this.game.rotateCarpetClockwise();
		}

		else if(e.getActionCommand() == "Tourner le tapis dans le sens anti-horaire"){
			this.game.rotateCarpetCounterClockwise();
		}

		else if(e.getActionCommand() == "Valider la position du tapis"){
			this.game.nextCarpet();
		}

		else if(e.getActionCommand() == "Ok"){
			game.throwDice();
			ps.mp.repaint();
			ps.lancerde.setEnabled(false);

		}
	}
}