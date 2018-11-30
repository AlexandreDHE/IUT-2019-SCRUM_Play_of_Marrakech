package listener;
import java.awt.*;  
import javax.swing.*;

import view.SelectPlayer;

import java.awt.event.*;

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