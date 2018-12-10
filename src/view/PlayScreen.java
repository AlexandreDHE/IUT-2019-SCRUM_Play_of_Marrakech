package view;

import javax.swing.*;

import listener.viewtomodel.*;

import model.*;
import model.game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;

public class PlayScreen extends JFrame{

	public JMenu back = new JMenu();
	public MessagePanel mp = new MessagePanel();
	public JButton lancerde = new JButton("Lancer le dé");
	public JLabel devalue = new JLabel();
	private AssamPanel assamPanel = new AssamPanel();

	private	JButton[] orientationButtons;
	private Game game;

	public PlayScreen(Game game){
		this.game = game;
		lancerde.setEnabled(false);

		this.orientationButtons = new JButton[4];
		this.orientationButtons[0] = new JButton("▼");
		this.orientationButtons[1] = new JButton("◀");
		this.orientationButtons[2] = new JButton("▲");
		this.orientationButtons[3] = new JButton("▶");

		this.setEnabledOrientationButtons(true);

		JPanel bottompanel = new JPanel();

		JPanel centerpanel = new JPanel();
		JPanel centernorth = new JPanel();
		JPanel centersouth = new JPanel();
		JPanel centereast = new JPanel();
		JPanel centerwest = new JPanel();
		JPanel centercenter = new JPanel();

		OpenImage northimg = new OpenImage(750,70,"./drawable/haut.png");
		OpenImage southimg = new OpenImage(750,70,"./drawable/bas.png");
		OpenImage eastimg = new OpenImage(75,400,"./drawable/droite.png");
		OpenImage westimg = new OpenImage(75,400,"./drawable/gauche.png");

		centernorth.add(northimg);
		centersouth.add(southimg);
		centereast.add(eastimg);
		centerwest.add(westimg);

		centerpanel.setBackground(Color.RED);

		centerpanel.setLayout(new BorderLayout());

		centerpanel.add(centernorth, BorderLayout.NORTH);
		centerpanel.add(centersouth, BorderLayout.SOUTH);
		centerpanel.add(centereast, BorderLayout.EAST);
		centerpanel.add(centerwest, BorderLayout.WEST);
		centerpanel.add(centercenter, BorderLayout.CENTER);

		centernorth.setBackground(new Color(254, 153, 1));
		centersouth.setBackground(new Color(254, 153, 1));
		centereast.setBackground(new Color(254, 153, 1));
		centerwest.setBackground(new Color(254, 153, 1));
		centercenter.setBackground(new Color(254, 153, 1));

		GridLayout gridl = new GridLayout(7,7);
		gridl.setHgap(0);

		centercenter.setLayout(gridl);

		JPanel bottompanelright = new JPanel();
		JPanel bottompanelleft = new JPanel();
		JPanel leftpanel = new JPanel();
		JPanel rightpanel = new JPanel();

		leftpanel.setBackground(new Color(255, 203, 153));
		rightpanel.setBackground(new Color(255, 203, 153));

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

		bottompanelright.setBackground(new Color(255, 203, 153));
		bottompanelleft.setBackground(new Color(255, 203, 153));
		bottompanelleft.add(lancerde);
		devalue.setForeground(Color.WHITE);
		bottompanelleft.add(devalue);

		bottompanel.add(bottompanelleft);
		bottompanel.setBackground(Color.GRAY);

		game.addGameListener(new MessagePanelControler(this.mp));
		game.addAssamListener(new MessagePanelControler(this.mp));
		game.addDiceListener(new MessagePanelControler(this.mp));

		JPanel b1 = new JPanel();
		b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		b1.add(getUpButton());

		JPanel b2 = new JPanel();
		b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
		b2.add(getLeftButton());
		b2.add(getRightButton());

		JPanel b3 = new JPanel();
		b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
		b3.add(getDownButton());

		bottompanelright.setLayout(new BoxLayout(bottompanelright, BoxLayout.PAGE_AXIS));
		bottompanelright.add(b1);
		bottompanelright.add(b2);
		bottompanelright.add(b3);
		bottompanel.add(bottompanelright);

		JPanel allcases[][] = new JPanel[7][7];

		for(int i = 0; i < 7; i++){

			for(int j = 0; j < 7; j++){

				if((i==3) && (j==3)){
					allcases[i][j] = assamPanel;
				}else{


				allcases[i][j] = new JPanel();
				allcases[i][j].addMouseListener(new CaseListener());
				allcases[i][j].setBackground(new Color(255, 203, 153));
				allcases[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(254, 153, 1)));
				
			}
			centercenter.add(allcases[i][j]);

			}

		}

		this.add(mp, BorderLayout.NORTH);
		this.add(leftpanel, BorderLayout.WEST);
		this.add(rightpanel, BorderLayout.EAST);
		this.add(bottompanel, BorderLayout.SOUTH);
		this.add(centerpanel, BorderLayout.CENTER);

		getUpButton().addActionListener(new PlayScreenControler(this,game));
		getDownButton().addActionListener(new PlayScreenControler(this,game));
		getLeftButton().addActionListener(new PlayScreenControler(this,game));
		getRightButton().addActionListener(new PlayScreenControler(this,game));
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

	public JButton getDiceButton(){

		return this.lancerde;

	}

	public AssamPanel getAssamPanel(){ 

		return this.assamPanel;

	}

	public JButton getUpButton()
	{ 

		return this.orientationButtons[2];

	}


	public JButton getDownButton(){

		return this.orientationButtons[0];
		
	}


	public JButton getRightButton(){

		return this.orientationButtons[3];
		
	}


	public JButton getLeftButton(){

		return this.orientationButtons[1];
		
	}

	public void setEnabledOrientationButtons(boolean enable)
	{
		for(int i = 0; i < this.orientationButtons.length; i++)
		{
			this.orientationButtons[i].setEnabled(enable);
		}
		if(enable)
		{
			this.orientationButtons[game.getAssam().getOrientation()].setEnabled(false);
		}
	}
}