import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

public class TwoPlayersControler implements ActionListener{

	SelectPlayer selectplayer;

	int nbplayer = 0;

	public TwoPlayersControler(SelectPlayer selectplayer){

		this.selectplayer = selectplayer;

	}

	public void actionPerformed(ActionEvent e) {

			this.nbplayer = 2;
			selectplayer.getPlayButton().setEnabled(true);
			selectplayer.repaint();
			System.out.println(this.nbplayer+" joueurs");
	}
}