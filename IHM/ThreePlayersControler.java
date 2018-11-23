import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

public class ThreePlayersControler implements ActionListener{

	SelectPlayer selectplayer;

	int nbplayer = 0;

	public ThreePlayersControler(SelectPlayer selectplayer){

		this.selectplayer = selectplayer;

	}

	public void actionPerformed(ActionEvent e) {

		this.nbplayer = 3;
		selectplayer.getPlayButton().setEnabled(true);
		selectplayer.repaint();
		System.out.println(this.nbplayer+" joueurs");

	}
}