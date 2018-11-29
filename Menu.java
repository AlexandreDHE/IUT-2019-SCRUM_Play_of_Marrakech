import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;


public class Menu extends JFrame{

	public Menu(){

		JButton start = new JButton("Start new game");
		JButton resume = new JButton("Continue");
		JButton quit = new JButton("Quit");

		start.addActionListener(new MenuControler(this));
		resume.addActionListener(new MenuControler(this));
		quit.addActionListener(new MenuControler(this));

		JPanel btn_pane = new JPanel();
		JPanel img_pane = new JPanel();
		JPanel titlepan = new JPanel();

		JLabel title = new JLabel("Marrakech Game");
		title.setFont(new Font("Serif", Font.PLAIN, 35));

		titlepan.add(title);

		OpenImage openimage = new OpenImage(1080, 650, "img/background.jpg");

		img_pane.add(openimage);

		btn_pane.add(start);
		btn_pane.add(resume);
		btn_pane.add(quit);

		btn_pane.setBackground(Color.GRAY);
		this.add(btn_pane, BorderLayout.SOUTH);
		this.add(img_pane, BorderLayout.CENTER);
		this.add(titlepan, BorderLayout.NORTH);

		this.setSize(1080, 720);
		this.setTitle("Marrakech Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

	}

}