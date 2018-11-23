import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

public class SelectPlayerControler implements ActionListener{

	SelectPlayer selectplayer;

	int nbplayer = 0;

	public SelectPlayerControler(SelectPlayer selectplayer){

		this.selectplayer = selectplayer;

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand() == "Play"){

			selectplayer.dispose();
			PlayScreen playscreen = new PlayScreen();
			playscreen.setVisible(true);
			System.out.println(this.nbplayer+" joueurs");

		}

		if(e.getActionCommand() == "Back"){

			this.nbplayer = 0;
			selectplayer.dispose();
			Menu backtomenu = new Menu();
			backtomenu.setVisible(true);

		}

	}
}