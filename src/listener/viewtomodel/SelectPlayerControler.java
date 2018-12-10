package listener.viewtomodel;

import java.awt.*;  
import javax.swing.*;

import model.Game;
import view.Menu;
import view.PlayScreen;
import view.SelectPlayer;

import java.awt.event.*;

public class SelectPlayerControler implements ActionListener{

	SelectPlayer selectplayer;

	JButton jb1, jb2, jb3;

	int nbplayers = 0;

	public SelectPlayerControler(SelectPlayer selectplayer, JButton jb1, JButton jb2, JButton jb3){

		this.selectplayer = selectplayer;
		this.jb1 = jb1;
		this.jb2 = jb2;
		this.jb3 = jb3;

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand() == "2 players"){

			this.nbplayers = 2;
			selectplayer.getPlayButton().setEnabled(true);
			selectplayer.repaint();
			jb1.setBackground(Color.GRAY);
			jb2.setBackground(null);
			jb3.setBackground(null);

		}

		if(e.getActionCommand() == "3 players"){

			this.nbplayers = 3;
			selectplayer.getPlayButton().setEnabled(true);
			selectplayer.repaint();
			jb1.setBackground(null);
			jb2.setBackground(Color.GRAY);
			jb3.setBackground(null);

		}

		if(e.getActionCommand() == "4 players"){

			this.nbplayers = 4;
			selectplayer.getPlayButton().setEnabled(true);
			selectplayer.repaint();
			jb1.setBackground(null);
			jb2.setBackground(null);
			jb3.setBackground(Color.GRAY);

		}

		if(e.getActionCommand() == "Play"){

			selectplayer.dispose();
			PlayScreen playscreen = new PlayScreen(new Game(this.nbplayers));
			Game game = new Game(this.nbplayers);
			playscreen.setVisible(true);

		}

		if(e.getActionCommand() == "Back"){

			selectplayer.dispose();
			Menu backtomenu = new Menu();
			backtomenu.setVisible(true);

		}
	}
}