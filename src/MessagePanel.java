import java.awt.*;
import javax.swing.*;  

public class MessagePanel extends JPanel implements InterfaceListener{

	private JLabel jlmess;

	public MessagePanel(){

		this.jlmess = new JLabel("New game started !");
		jlmess.setForeground(Color.RED);
		jlmess.setFont(new Font("Serif", Font.PLAIN, 20));
		this.add(jlmess);

	}

	public void messageChanged(String message){
		this.jlmess.setText(message);
		this.repaint();

	}
}