package listener.viewtomodel;

import java.awt.Container.*;
import java.awt.*;  
import javax.swing.*;

import model.*;
import model.game.Game;
import view.PlayScreen;

import java.awt.event.*;

public class CaseListener implements MouseListener{

	private int i, j;
	private JPanel panel;
	private Game game;

	public CaseListener(Game game, int i, int j){

		this.game = game;
		this.i = i;
		this.j = j;

	}

	public void mouseClicked(MouseEvent e){

		Position case1 = new Position(this.i, this.j);
		Position case2 = new Position(this.i+1, this.j);

		game.putCarpet(case1, case2);


	}

	public void mouseEntered(MouseEvent e){

		/*
		this.panel = (JPanel)e.getComponent();	
		this.panel.setBackground(new Color(255, 229, 206));
		*/

	}

	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
}