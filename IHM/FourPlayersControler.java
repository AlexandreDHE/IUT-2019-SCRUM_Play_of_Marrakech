import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

public class FourPlayersControler implements ActionListener{

	SelectPlayer selectplayer;

	int nbplayer = 0;

	public FourPlayersControler(SelectPlayer selectplayer){

		this.selectplayer = selectplayer;

	}

	public void actionPerformed(ActionEvent e) {

		this.nbplayer = 4;
		selectplayer.getPlayButton().setEnabled(true);
		selectplayer.repaint();
		System.out.println(this.nbplayer+" joueurs");

	}
}