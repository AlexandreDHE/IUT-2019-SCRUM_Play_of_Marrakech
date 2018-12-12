package view.parameter;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import listener.viewtomodel.GameParameterListener;

public class GameParameterView extends JPanel
{
	public GameParameterView() 
	{
		JPanel parametersPanel = new JPanel();
		parametersPanel.setLayout(new GridLayout(2,1));

		JPanel playersPanel = new JPanel();
		playersPanel.setLayout(new GridLayout(1,4));
		for(int i = 0; i < 4; i++)
			playersPanel.add(new ItemParameter("./drawable/player.png", "Joueur"));

		JPanel dicePanel = new JPanel();
		dicePanel.setLayout(new GridLayout(1,2));
		ItemParameter[] diceParameters = new ItemParameter[2];
		diceParameters[0] = new ItemParameter("./drawable/de.png", "Jouer avec un de.");
		diceParameters[1] = new ItemParameter("./drawable/node.png", "Jouer sans de.");
		for(int i = 0; i < diceParameters.length; i++)
		{
			diceParameters[i].addMouseListener(new  GameParameterListener(diceParameters));
			dicePanel.add(diceParameters[i]);
		}

		parametersPanel.add(playersPanel);
		parametersPanel.add(dicePanel);

		this.add(parametersPanel, BorderLayout.CENTER);
		this.add(new JButton("Valider"), BorderLayout.SOUTH);
	}
 };
