package view;
import javax.swing.*;

import listener.viewtomodel.*;

import java.awt.*;
import java.awt.Color.*;

/**
* Cette classe permet d'afficher une fenêtre de sélection du nombre de joueurs.
* Le JButton "back" permet de retourner au menu du jeu, tandis que
* le JButton "start" permet de commencer une partie avec le nombre de joueurs sélectionné.
* Ce dernier est accessible uniquement lorsque le nombre de joueurs est sélectionné.
 */


public class SelectPlayer extends JFrame{

	JButton play = new JButton("Play");

	public SelectPlayer(){

		JPanel toppan = new JPanel();
		JPanel centerpan = new JPanel();
		JPanel bottompan = new JPanel();

		JButton players2 = new JButton("2 players");
		JButton players3 = new JButton("3 players");
		JButton players4 = new JButton("4 players");
		JButton back = new JButton("Back");

		JLabel label1 = new JLabel("Select the number of players : ");

		toppan.add(label1);
		label1.setFont(new Font("Serif", Font.PLAIN, 35));

		centerpan.add(players2);
		centerpan.add(players3);
		centerpan.add(players4);
		centerpan.add(new OpenImage(600, 500, "./drawable/background2.jpg"));

		SelectPlayerControler spc = new SelectPlayerControler(this, players2, players3, players4);

		players2.addActionListener(spc);
		players3.addActionListener(spc);
		players4.addActionListener(spc);
		play.addActionListener(spc);
		back.addActionListener(spc);

		bottompan.add(back);
		bottompan.add(play);
		bottompan.setBackground(Color.GRAY);
		play.setEnabled(false);

		this.add(toppan, BorderLayout.NORTH);
		this.add(centerpan, BorderLayout.CENTER);
		this.add(bottompan, BorderLayout.SOUTH);

		this.setSize(1080, 720);
		this.setTitle("Marrakech Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

	}

	//Accesseur

	public JButton getPlayButton(){
		return this.play;
	}

}