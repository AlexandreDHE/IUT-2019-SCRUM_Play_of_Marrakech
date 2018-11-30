package view;
import java.awt.*;
import javax.swing.*;

import event.GameEvent;
import listener.GameListener;


public class MessagePanel extends JPanel implements GameListener{

	private JLabel jlmess;

	public MessagePanel(){
		this.jlmess = new JLabel("New game started !");
		jlmess.setForeground(Color.RED);
		jlmess.setFont(new Font("Serif", Font.PLAIN, 20));
		this.add(jlmess);
	}

	@Override
	public void gameStateChanged(GameEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameStarted(GameEvent event) {
	}

	@Override
	public void gameFinished(GameEvent event) {
		// TODO Auto-generated method stub
		
	}
}