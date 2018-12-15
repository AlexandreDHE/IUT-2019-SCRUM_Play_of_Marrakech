package listener.viewtomodel;

import java.awt.*;  
import javax.swing.*;

import view.SelectPlayer;

import java.awt.event.*;

/**
* La classe MenuControler est le contrôleur de la classe Menu.
* Ce contrôleur permet de gérer les actions liées aux JButton disposés en bas de la fenêtre du menu.
* 
* @see Menu
*/

public class MenuControler implements ActionListener{

	JFrame jframe;
	JFrame nextF;

	public MenuControler(JFrame jframe){

		this.jframe = jframe;

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand() == "Start new game"){

			jframe.dispose();
			nextF = new SelectPlayer();
			nextF.setVisible(true);


		}

		if(e.getActionCommand() == "Continue"){

			jframe.dispose();
		//	nextF = new PlayScreen();
			nextF.setVisible(true);


		}

		if(e.getActionCommand() == "Quit"){

			System.exit(0);

		}

	}
}