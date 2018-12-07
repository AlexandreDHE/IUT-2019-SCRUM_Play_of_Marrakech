package view;
import java.awt.*;
import javax.swing.*;

import event.GameEvent;
import listener.GameListener;


public class MessagePanel extends JPanel{

	private JLabel jlmess;

	public MessagePanel(){
		this.jlmess = new JLabel();
		this.setBackground(new Color(255, 203, 153));
		jlmess.setForeground(Color.RED);
		jlmess.setFont(new Font("Serif", Font.PLAIN, 20));
		this.add(jlmess);
	}

	public void setMessage(String message)
	{
		this.jlmess.setText(message);
		this.repaint();
	}
}