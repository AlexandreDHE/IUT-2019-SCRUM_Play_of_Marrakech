package listener.viewtomodel;

import java.awt.Container.*;
import java.awt.*;  
import javax.swing.*;

import model.game.Game;
import view.PlayScreen;

import java.awt.event.*;

public class CaseListener implements MouseListener{

	int i, j;
	boolean carpetBase = false, state = false;
	JPanel panel;

	public CaseListener(int i, int j){

		this.i = i;
		this.j = j;

	}

	public void setState(boolean state){

		this.state = state;

	}

	public void mouseClicked(MouseEvent e){

		if(state){

			this.carpetBase = true;
			this.panel = (JPanel)e.getComponent();	
			this.panel.setBackground(Color.GREEN);
			System.out.println(i+" "+j);

		}
		
	}

	public void mouseEntered(MouseEvent e){

		if(state){

			this.panel = (JPanel)e.getComponent();	
			this.panel.setBackground(new Color(255, 229, 206));

		}


	}

	public void mouseExited(MouseEvent e){

		if(!carpetBase && state){
			this.panel = (JPanel)e.getComponent();	
			this.panel.setBackground(new Color(255, 203, 153));
		}

	}

	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
}