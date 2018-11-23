import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

public class SelectPlayerControler implements ActionListener{

	SelectPlayer selectplayer;

	int nbplayers = 0;

	public SelectPlayerControler(SelectPlayer selectplayer){

		this.selectplayer = selectplayer;

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand() == "2 players"){

			this.nbplayers = 2;
			selectplayer.getPlayButton().setEnabled(true);
			selectplayer.repaint();

		}

		if(e.getActionCommand() == "3 players"){

			this.nbplayers = 3;
			selectplayer.getPlayButton().setEnabled(true);
			selectplayer.repaint();

		}

		if(e.getActionCommand() == "4 players"){

			this.nbplayers = 4;
			selectplayer.getPlayButton().setEnabled(true);
			selectplayer.repaint();

		}

		if(e.getActionCommand() == "Play"){

			selectplayer.dispose();
			PlayScreen playscreen = new PlayScreen();
			playscreen.setVisible(true);
			System.out.println(nbplayers);

		}

		if(e.getActionCommand() == "Back"){

			selectplayer.dispose();
			Menu backtomenu = new Menu();
			backtomenu.setVisible(true);

		}

	}
}