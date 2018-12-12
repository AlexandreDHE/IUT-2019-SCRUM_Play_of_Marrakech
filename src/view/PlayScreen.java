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

	private	JButton[] assamOrientationButtons;
	private	JButton[] carpetOrientationButtons;

	private JPanel allcases[][];
	private JPanel centercenter = new JPanel();
	private Game game;

	public PlayScreen(Game game){

		this.game = game;
		this.allcases = new JPanel[7][7];

		lancerde.setEnabled(false);

		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 12);

		this.carpetOrientationButtons = new JButton[2];
		this.carpetOrientationButtons[0] = new JButton("Tourner dans le sens anti-horaire");
		this.carpetOrientationButtons[1] = new JButton("Tourner dans le sens horaire");

		this.assamOrientationButtons = new JButton[3];
		this.assamOrientationButtons[0] = new JButton("Tourner dans le sens horaire");
		this.assamOrientationButtons[1] = new JButton("Tourner dans le sens anti-horaire");
		this.assamOrientationButtons[2] = new JButton("Ne pas orienter");

		enableButtons(false, getCarpetOrientationButtons());

		JPanel bottompanel = new JPanel();
		JPanel centerpanel = new JPanel();
		JPanel centernorth = new JPanel();
		JPanel centersouth = new JPanel();
		JPanel centereast = new JPanel();
		JPanel centerwest = new JPanel();

		OpenImage northimg = new OpenImage(750,70,"./drawable/haut.png");
		OpenImage southimg = new OpenImage(750,70,"./drawable/bas.png");
		OpenImage eastimg = new OpenImage(75,350,"./drawable/droite.png");
		OpenImage westimg = new OpenImage(75,350,"./drawable/gauche.png");

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
		JPanel bottompanelcenter = new JPanel();
		JPanel bottompanelleft = new JPanel();
		JPanel leftpanel = new JPanel();
		JPanel rightpanel = new JPanel();

		leftpanel.setBackground(new Color(255, 203, 153));
		rightpanel.setBackground(new Color(255, 203, 153));

		JMenuBar menuBar = new JMenuBar();  
		JMenu quit = new JMenu();
		JMenuItem quitnsave = new JMenuItem(); 
		JMenuItem quitwsave = new JMenuItem(); 

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

		bottompanel.add(bottompanelleft, BorderLayout.WEST);
		bottompanel.setBackground(Color.GRAY);

		game.addGameListener(new MessagePanelControler(this.mp, this));
		game.addAssamListener(new MessagePanelControler(this.mp, this));
		game.addDiceListener(new MessagePanelControler(this.mp, this));
		game.addCarpetListener(new MessagePanelControler(this.mp, this));

		//Disposition des boutons d'orientation des tapis

		JPanel b1 = new JPanel();
		b1.add(carpetOrientationButtons[0]);
		b1.setBackground(new Color(255, 203, 153));

		JPanel b2 = new JPanel();
		b2.add(carpetOrientationButtons[1]);
		b2.setBackground(new Color(255, 203, 153));

		bottompanelcenter.setLayout(new GridLayout(3,1));

		JLabel bpc = new JLabel("Orienter un tapis.");
		bpc.setFont(myFont);
		bpc.setHorizontalAlignment(JLabel.CENTER);

		bottompanelcenter.add(bpc);
		bottompanelcenter.add(b1);
		bottompanelcenter.add(b2);

		bottompanel.add(bottompanelcenter, BorderLayout.CENTER);
		bottompanelcenter.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));

		//Disposition des boutons d'orientation d'Assam

		JLabel bpr = new JLabel("Orienter Assam.");
		bpr.setFont(myFont);
		
		JPanel b4 = new JPanel();
		b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
		b4.add(assamOrientationButtons[1]);
		b4.add(assamOrientationButtons[0]);

		JPanel b5 = new JPanel();
		b5.setLayout(new BoxLayout(b5, BoxLayout.LINE_AXIS));
		b5.add(assamOrientationButtons[2]);

		bottompanelright.setLayout(new BoxLayout(bottompanelright, BoxLayout.PAGE_AXIS));
		bottompanelright.add(bpr);
		bottompanelright.add(b4);
		bottompanelright.add(b5);
		bottompanel.add(bottompanelright, BorderLayout.EAST);
		
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

		return this.assamOrientationButtons[2];

	}


	public JButton getDownButton(){

		return this.assamOrientationButtons[0];
		
	}


	public JButton getLeftButton(){

		return this.assamOrientationButtons[1];
		
	}

	public void enableButtons(boolean state, JButton[] tab){

		for(int i = 0; i < tab.length; i++){

			tab[i].setEnabled(state);

		}
	}

	public JButton[] getAssamOrientationButtons(){
		return this.assamOrientationButtons;
	}

	public JButton[] getCarpetOrientationButtons(){
		return this.carpetOrientationButtons;
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