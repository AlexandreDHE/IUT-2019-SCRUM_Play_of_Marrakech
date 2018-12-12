package view;

import javax.swing.*;

import listener.modeltoview.MessagePanelControler;
import listener.viewtomodel.*;

import model.*;
import model.game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;

public class PlayScreen extends JFrame{

	public JMenu back = new JMenu();
	public MessagePanel mp = new MessagePanel();
	public JButton lancerde = new JButton("Lancer le de");
	public JLabel devalue = new JLabel();
	private AssamPanel assamPanel = new AssamPanel();

	private	JButton[] orientationButtons;
	private JPanel allcases[][];
	private JPanel centercenter = new JPanel();
	private Game game;

	public PlayScreen(Game game){
		this.game = game;
		this.allcases = new JPanel[7][7];
		lancerde.setEnabled(false);

		this.orientationButtons = new JButton[3];
		this.orientationButtons[0] = new JButton("Tourner dans le sens horaire");
		this.orientationButtons[1] = new JButton("Ne pas orienter");
		this.orientationButtons[2] = new JButton("Tourner dans le sens anti-horaire");

		JPanel bottompanel = new JPanel();

		JPanel centerpanel = new JPanel();
		JPanel centernorth = new JPanel();
		JPanel centersouth = new JPanel();
		JPanel centereast = new JPanel();
		JPanel centerwest = new JPanel();
		

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

		back.setText("â†� Retour");  
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

		game.addGameListener(new MessagePanelControler(this.mp, this));
		game.addAssamListener(new MessagePanelControler(this.mp, this));
		game.addDiceListener(new MessagePanelControler(this.mp, this));
		game.addCarpetListener(new MessagePanelControler(this.mp, this));
		
		JPanel b1 = new JPanel();
		b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		b1.add(getUpButton());

		JPanel b2 = new JPanel();
		b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
		b2.add(getLeftButton());

		JPanel b3 = new JPanel();
		b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
		b3.add(getDownButton());

		bottompanelright.setLayout(new BoxLayout(bottompanelright, BoxLayout.PAGE_AXIS));
		bottompanelright.add(b1);
		bottompanelright.add(b2);
		bottompanelright.add(b3);
		bottompanel.add(bottompanelright);
		
		this.drawCenter();

		this.add(mp, BorderLayout.NORTH);
		this.add(leftpanel, BorderLayout.WEST);
		this.add(rightpanel, BorderLayout.EAST);
		this.add(bottompanel, BorderLayout.SOUTH);
		this.add(centerpanel, BorderLayout.CENTER);

		getUpButton().addActionListener(new PlayScreenControler(this,game));
		getDownButton().addActionListener(new PlayScreenControler(this,game));
		getLeftButton().addActionListener(new PlayScreenControler(this,game));
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


	public JButton getLeftButton(){

		return this.orientationButtons[1];
		
	}


	
	public JPanel getCase(int colorPlayer)
	{
		Color color;
		switch(colorPlayer)
		{
			case Couleur.NONE : color = new Color(255, 203, 153); break;
			case Couleur.JOUEUR1 : color = new Color(255,0,0); break;
			case Couleur.JOUEUR2 : color = new Color(0,255,0); break;
			case Couleur.JOUEUR3 : color = new Color(0,0,255); break;
			case Couleur.JOUEUR4 : color = new Color(255,255,255); break;
			default: color = new Color(255, 203, 153); break;
		}
		JPanel casePanel = new JPanel();
		casePanel.addMouseListener(new CaseListener());
		casePanel.setBackground(color);
		casePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(254, 153, 1)));
		
		return casePanel;
	}
	
	public void drawCenter(){
		this.centercenter.removeAll();
		Case[][] grid = this.game.getGameGrid();
		Position assamCoord = this.game.getAssamCoord();
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				if((i==assamCoord.getY()) && (j==assamCoord.getX()))
				{
					allcases[i][j] = assamPanel;
				}
				else
				{
					if(grid[i][j].recupererTapis() == null)
					{
						allcases[i][j] = this.getCase(Couleur.NONE);
					}
					else
					{
						allcases[i][j] = this.getCase(grid[i][j].recupererTapis().getCouleur());
					}
				}
				centercenter.add(allcases[i][j]);
			}
		}
		this.revalidate();
		this.repaint();
	}
}