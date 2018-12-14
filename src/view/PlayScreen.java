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
	public JButton lancerde = new JButton("Ok");
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

		this.carpetOrientationButtons = new JButton[3];
		this.carpetOrientationButtons[0] = new JButton("Tourner le tapis dans le sens anti-horaire");
		this.carpetOrientationButtons[1] = new JButton("Tourner le tapis dans le sens horaire");
		this.carpetOrientationButtons[2] = new JButton("Valider la position");

		this.assamOrientationButtons = new JButton[3];
		this.assamOrientationButtons[0] = new JButton("Tourner dans le sens horaire");
		this.assamOrientationButtons[1] = new JButton("Tourner dans le sens anti-horaire");
		this.assamOrientationButtons[2] = new JButton("Ne pas orienter");

		enableButtons(false, getCarpetOrientationButtons());

		JPanel bottompanel = new JPanel();
		JPanel bottompanelright = new JPanel();
		JPanel bottompanelcenter = new JPanel();
		JPanel bottompanelleft = new JPanel();
		JPanel leftpanel = new JPanel();
		JPanel rightpanel = new JPanel();
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

		bottompanel.setLayout(new GridLayout(1,3));
		centerpanel.setLayout(new BorderLayout());
		centercenter.setLayout(new GridLayout(7,7));
		leftpanel.setLayout(new GridLayout(2,1));
		rightpanel.setLayout(new GridLayout(2,1));

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

		leftpanel.setBackground(new Color(255, 203, 153));
		rightpanel.setBackground(new Color(255, 203, 153));

		JMenuBar menuBar = new JMenuBar();  
		JMenu quit = new JMenu();
		JMenuItem quitnsave = new JMenuItem(); 
		JMenuItem quitwsave = new JMenuItem(); 

		quitnsave.setText("Sauver et quitter");
		quitwsave.setText("Quitter sans sauver");

		back.setText("Retour");  
		quit.setText("[] Quitter");  
		quit.add(quitnsave);
		quit.add(quitwsave);

		menuBar.add(back);  
		menuBar.add(quit);  

		quitwsave.addActionListener(new JMenuItemListener());
		quitnsave.addActionListener(new JMenuItemListener());     
		back.addMenuListener(new JMenuListener(this));

		//Disposition des boutons d'orientation d'Assam

		JLabel bpr = new JLabel("1 - Orienter Assam.");
		bpr.setFont(myFont);
		bpr.setHorizontalAlignment(JLabel.CENTER);
		bpr.setBackground(new Color(255, 203, 153));
		
		JPanel b4 = new JPanel();
		b4.add(assamOrientationButtons[1]);
		b4.setBackground(new Color(255, 203, 153));

		JPanel b5 = new JPanel();
		b5.add(assamOrientationButtons[0]);
		b5.setBackground(new Color(255, 203, 153));

		JPanel b6 = new JPanel();
		b6.add(assamOrientationButtons[2]);
		b6.setBackground(new Color(255, 203, 153));

		bottompanelleft.setLayout(new GridLayout(4,1));
		bottompanelleft.add(bpr);
		bottompanelleft.add(b4);
		bottompanelleft.add(b5);
		bottompanelleft.add(b6);

		//Panneau du lancer de dé

		JLabel btl = new JLabel("2 - Lancer le dé.");
		btl.setFont(myFont);
		btl.setHorizontalAlignment(JLabel.CENTER);

		bottompanelcenter.setLayout(new GridLayout(3,1));

		bottompanelcenter.add(btl);
		bottompanelcenter.add(lancerde);
		bottompanelcenter.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));

		//Disposition des boutons d'orientation des tapis

		JPanel b1 = new JPanel();
		b1.add(carpetOrientationButtons[0]);
		b1.setBackground(new Color(255, 203, 153));

		JPanel b2 = new JPanel();
		b2.add(carpetOrientationButtons[1]);
		b2.setBackground(new Color(255, 203, 153));

		JPanel b3 = new JPanel();
		b3.add(carpetOrientationButtons[2]);
		b3.setBackground(new Color(255, 203, 153));

		bottompanelright.setLayout(new GridLayout(4,1));

		JLabel bpc = new JLabel("3 - Orienter un tapis.");
		bpc.setFont(myFont);
		bpc.setHorizontalAlignment(JLabel.CENTER);

		bottompanelright.add(bpc);
		bottompanelright.add(b1);
		bottompanelright.add(b2);
		bottompanelright.add(b3);

		bottompanelleft.setBackground(new Color(255, 203, 153));
		bottompanelcenter.setBackground(new Color(255, 203, 153));
		bottompanelright.setBackground(new Color(255, 203, 153));

		bottompanel.add(bottompanelleft);
		bottompanel.add(bottompanelcenter);
		bottompanel.add(bottompanelright);

		game.addGameListener(new MessagePanelControler(this.mp, this));
		game.addAssamListener(new MessagePanelControler(this.mp, this));
		game.addDiceListener(new MessagePanelControler(this.mp, this));
		game.addCarpetListener(new MessagePanelControler(this.mp, this));
		
		this.drawCenter();

		this.add(mp, BorderLayout.NORTH);
		this.add(leftpanel, BorderLayout.WEST);
		this.add(rightpanel, BorderLayout.EAST);
		this.add(bottompanel, BorderLayout.SOUTH);
		this.add(centerpanel, BorderLayout.CENTER);

		getUpButton().addActionListener(new PlayScreenControler(this,game));
		getDownButton().addActionListener(new PlayScreenControler(this,game));
		getLeftButton().addActionListener(new PlayScreenControler(this,game));

		for(int i = 0; i < this.carpetOrientationButtons.length; i++)
		{
			this.carpetOrientationButtons[i].addActionListener(new PlayScreenControler(this,game));
		}
		lancerde.addActionListener(new PlayScreenControler(this,game));

		Joueur[] players = game.getJoueurs();

		leftpanel.add(new ScorePanel(players[0],1,1,1,1));
		rightpanel.add(new ScorePanel(players[1],1,1,1,1));

		switch (game.getJoueurs().length) {

			case 3: 

			rightpanel.add(new ScorePanel(players[2],1,1,1,1));

			break;

			case 4:  

			rightpanel.add(new ScorePanel(players[2],1,1,1,1));
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


	
	public JPanel getCase(int colorPlayer, int i, int j)
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
		casePanel.addMouseListener(new CaseListener(this.game, i, j));
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
				JPanel casePanel;

				if(grid[i][j].recupererTapis() == null)
				{

					casePanel = this.getCase(Couleur.NONE,i,j);

				}else{

					casePanel = this.getCase(grid[i][j].recupererTapis().getCouleur(),i,j);
				}

				if((i==assamCoord.getY()) && (j==assamCoord.getX())){
					
					casePanel.add(assamPanel);
				}

				allcases[i][j] = casePanel;
				centercenter.add(allcases[i][j]);
			}

		}
		
		this.revalidate();
		this.repaint();
	}
}