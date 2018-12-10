package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.GameParameterListener;

public class GameParameterView extends JPanel
{
	public GameParameterView() 
	{
		this.setLayout(new GridLayout(1,2));
		ItemParameter[] parameters = new ItemParameter[2];
		parameters[0] = new ItemParameter("./drawable/de.png", "Jouer avec un de.");
		parameters[1] = new ItemParameter("./drawable/node.png", "Jouer sans de.");
		
		for(int i = 0; i < parameters.length; i++)
		{
			parameters[i].addMouseListener(new  GameParameterListener(parameters));
			this.add(parameters[i]);
		}
	}
 };
