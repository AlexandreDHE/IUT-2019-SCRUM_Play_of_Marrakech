package view;
import java.awt.*;
import javax.swing.*;

public class MessagePanel extends JPanel{
  
  /**
 * Cette classe est un JPanel qui permet d'afficher des informations relatives
 * aux actions des joueurs au cours d'une partie.
 * Son message peut être modifié en appellant @see MessagePanel#setMessage(String)
 */

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