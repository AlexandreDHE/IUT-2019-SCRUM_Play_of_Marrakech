package listener;

import java.awt.*;  
import javax.swing.*;

import model.*;
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

		if(e.getActionCommand() == "▲")
		{
			if(orientation == Assam.OUEST)
			{
				game.rotateAssamClockwise();
			}
			else if(orientation == Assam.EST)
			{
				game.rotateAssamCounterClockwise();
			}
			System.out.println(game.getAssam().getOrientation());
			ps.getAssamPanel().setAssamTop();
			this.ps.setEnabledOrientationButtons(false);
			this.ps.getDiceButton().setEnabled(true);
		}

		if(e.getActionCommand() == "◀"){

			if(orientation == Assam.SUD)
			{
				game.rotateAssamClockwise();
			}
			else if(orientation == Assam.NORD)
			{
				game.rotateAssamCounterClockwise();
			}
			System.out.println(game.getAssam().getOrientation());

			ps.getAssamPanel().setAssamLeft();
			this.ps.setEnabledOrientationButtons(false);
			this.ps.getDiceButton().setEnabled(true);

		}

		if(e.getActionCommand() == "▶"){
			if(orientation == Assam.NORD)
			{
				game.rotateAssamClockwise();
			}
			else if(orientation == Assam.SUD)
			{
				game.rotateAssamCounterClockwise();
			}
			System.out.println(game.getAssam().getOrientation());

			ps.getAssamPanel().setAssamRight();
			this.ps.setEnabledOrientationButtons(false);
			this.ps.getDiceButton().setEnabled(true);

		}

		if(e.getActionCommand() == "▼"){
			if(orientation == Assam.EST)
			{
				game.rotateAssamClockwise();
			}
			else if(orientation == Assam.OUEST)
			{
				game.rotateAssamCounterClockwise();
			}
			System.out.println(game.getAssam().getOrientation());
			ps.getAssamPanel().setAssamBottom();
			this.ps.setEnabledOrientationButtons(false);
			this.ps.getDiceButton().setEnabled(true);

		}

		if(e.getActionCommand() == "Lancer le dé"){
			game.throwDice();
			ps.mp.repaint();
			ps.lancerde.setEnabled(false);

		}
	}
}