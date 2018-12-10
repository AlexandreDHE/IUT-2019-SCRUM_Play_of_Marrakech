package listener.viewtomodel;

import java.awt.Container.*;
import java.awt.*;  
import javax.swing.*;

import model.game.Game;
import view.PlayScreen;

import java.awt.event.*;

public class CaseListener implements MouseListener{

	public CaseListener(){

	}

	public void mouseClicked(MouseEvent e){

		JPanel panel = (JPanel)e.getComponent();	

		panel.setBackground(Color.GREEN);

		System.out.println("case");

	}

	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void actionPerformed(ActionEvent e){}
}