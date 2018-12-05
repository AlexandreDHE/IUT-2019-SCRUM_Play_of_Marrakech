package view;

import javax.swing.*;

import listener.*;

import model.Joueur;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;

public class PlayScreen extends JFrame{

	public JMenu back = new JMenu();
	public MessagePanel mp = new MessagePanel();
	public JButton lancerde = new JButton("Lancer le dé");
	public JLabel devalue = new JLabel();

	public PlayScreen(Game game){

		JButton up = new JButton("▲");
		JButton down = new JButton("▼");
		JButton left = new JButton("◀");
		JButton right = new JButton("▶");

		JPanel bottompanel = new JPanel();

		JPanel centerpanel = new JPanel();
		JPanel centernorth = new JPanel();
		JPanel centersouth = new JPanel();
		JPanel centereast = new JPanel();
		JPanel centerwest = new JPanel();
		JPanel centercenter = new JPanel();

		OpenImage northimg = new OpenImage(750,70,"../drawable/borderimage.jpg");

		centernorth.add(northimg);

		centerpanel.setBackground(Color.RED);

		centerpanel.setLayout(new BorderLayout());

		centerpanel.add(centernorth, BorderLayout.NORTH);
		centerpanel.add(centersouth, BorderLayout.SOUTH);
		centerpanel.add(centereast, BorderLayout.EAST);
		centerpanel.add(centerwest, BorderLayout.WEST);
		centerpanel.add(centercenter, BorderLayout.CENTER);

		centernorth.setBackground(Color.BLUE);
		centersouth.add(new JButton("Sud"));
		centereast.add(new JButton("Est"));
		centerwest.add(new JButton("Ouest"));

		GridLayout gridl = new GridLayout(7,7);
		gridl.setHgap(0);

		centercenter.setLayout(gridl);

		JPanel bottompanelright = new JPanel();
		JPanel bottompanelleft = new JPanel();
		JPanel leftpanel = new JPanel();
		JPanel rightpanel = new JPanel();

		JMenuBar menuBar = new JMenuBar();  
		JMenu quit = new JMenu();
		JMenuItem quitnsave = new JMenuItem(); 
		JMenuItem quitwsave = new JMenuItem(); 

		bottompanel.setLayout(new GridLayout(1,2));
		leftpanel.setLayout(new GridLayout(2,1));
		rightpanel.setLayout(new GridLayout(2,1));

		quitnsave.setText("Sauver et quitter");
		quitwsave.setText("Quitter sans sauver");

		back.setText("← Retour");  
		quit.setText("[] Quitter");  
		quit.add(quitnsave);
		quit.add(quitwsave);

		menuBar.add(back);  
		menuBar.add(quit);  

		quitwsave.addActionListener(new JMenuItemListener());
		quitnsave.addActionListener(new JMenuItemListener());     
		back.addMenuListener(new JMenuListener(this));

		bottompanelright.setBackground(Color.GRAY);
		bottompanelleft.setBackground(Color.GRAY);
		bottompanelleft.add(lancerde);
		devalue.setForeground(Color.WHITE);
		bottompanelleft.add(devalue);

		bottompanel.add(bottompanelleft);
		bottompanel.setBackground(Color.GRAY);

		game.addGameListener(new MessagePanelControler(this.mp));

		JPanel b1 = new JPanel();
		b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		b1.add(up);

		JPanel b2 = new JPanel();
		b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
		b2.add(left);
		b2.add(right);

		JPanel b3 = new JPanel();
		b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
		b3.add(down);

		bottompanelright.setLayout(new BoxLayout(bottompanelright, BoxLayout.PAGE_AXIS));
		bottompanelright.add(b1);
		bottompanelright.add(b2);
		bottompanelright.add(b3);
		bottompanel.add(bottompanelright);

		for(int i =0; i<7; i++){

			for(int  y=0; y<7; y++){

			//	OpenImage oi = new OpenImage(60, 60, "../drawable/case.jpg");
				JPanel pantoadd = new JPanel();
			//	oi.setVerticalAlignment(JLabel.CENTER);
			//	pantoadd.add(oi);
				pantoadd.setBackground(new Color(255,255,255));
				pantoadd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(68, 106, 48)));
				centercenter.add(pantoadd);

			}

		}

		this.add(mp, BorderLayout.NORTH);
		this.add(leftpanel, BorderLayout.WEST);
		this.add(rightpanel, BorderLayout.EAST);
		this.add(bottompanel, BorderLayout.SOUTH);
		this.add(centerpanel, BorderLayout.CENTER);

		up.addActionListener(new PlayScreenControler(this,game));
		down.addActionListener(new PlayScreenControler(this,game));
		left.addActionListener(new PlayScreenControler(this,game));
		right.addActionListener(new PlayScreenControler(this,game));
		lancerde.addActionListener(new PlayScreenControler(this,game));

		Joueur[] players = game.getJoueurs();

		leftpanel.add(new ScorePanel(players[0],1,1,1,1));
		rightpanel.add(new ScorePanel(players[1],1,1,1,1));

		switch (game.getJoueurs().length) {

			case 3: 

			rightpanel.add(new ScorePanel(players[2],1,1,1,1));

			break;

			case 4:  

			rightpanel.add(new ScorePanel(players[2],1,1,0,1));
			leftpanel.add(new ScorePanel(players[3],1,1,1,1));

			break;

			default: break;
		}

		this.setJMenuBar(menuBar);  
		this.setSize(1080, 720);
		this.setTitle("Marrakech Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		game.start();
	}

	public JLabel getLabelDe(){
		return this.devalue;
	}
}