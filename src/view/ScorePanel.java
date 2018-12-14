package view;

import java.awt.*;
import javax.swing.*;

import model.Couleur;
import model.Joueur;  

public class ScorePanel extends JPanel{

	private Joueur j;
	private	JLabel nbtapis = new JLabel();
	private JLabel nbdirham1 = new JLabel();
	private JLabel nbdirham5 = new JLabel();

	public ScorePanel(Joueur j, int top, int left, int bottom, int right){

		this.j = j;

		JLabel numplayer = new JLabel("Joueur "+(j.getCouleur()+1));

		JPanel player = new JPanel();
		JPanel tapis = new JPanel();
		JPanel dirhams1 = new JPanel();
		JPanel dirhams5 = new JPanel();

		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 12);

		this.setLayout(new GridLayout(4,1));

		this.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));

		nbtapis.setText(j.getNombreTapis()+" tapis.");
		nbdirham5.setText(j.getArgent(Joueur.PIECECINQ)+" pièces de 5 dirhams.");
		nbdirham1.setText(j.getArgent(Joueur.PIECEUN)+" pièces de 1 dirham.");

		numplayer.setFont(new Font("Serif", Font.PLAIN, 20));
		nbtapis.setFont(new Font("Serif", Font.PLAIN, 15));
		nbdirham1.setFont(new Font("Serif", Font.PLAIN, 15));
		nbdirham5.setFont(new Font("Serif", Font.PLAIN, 15));

		switch (j.getCouleur()) {

			case Couleur.JOUEUR1:  numplayer.setForeground(Color.RED); break;

			case Couleur.JOUEUR2:  numplayer.setForeground(Color.BLUE); break;

			case Couleur.JOUEUR3:  numplayer.setForeground(new Color(1,147,93)); break;

			case Couleur.JOUEUR4:  numplayer.setForeground(new Color(137,42,254)); break;

			default: break;
		}

		player.add(numplayer);
		tapis.add(nbtapis);
		dirhams1.add(nbdirham1);
		dirhams5.add(nbdirham5);

		numplayer.setFont(myFont);
		nbtapis.setFont(myFont);
		nbdirham1.setFont(myFont);
		nbdirham5.setFont(myFont);

		player.setBackground(new Color(255, 203, 153));
		tapis.setBackground(new Color(255, 203, 153));
		dirhams1.setBackground(new Color(255, 203, 153));
		dirhams5.setBackground(new Color(255, 203, 153));

		this.add(player);
		this.add(tapis);
		this.add(dirhams1);
		this.add(dirhams5);

	}

	public void refreshCarpetDisplay(){

		this.nbtapis.setText(j.getCarpetsLeft()+" tapis.");
		this.nbtapis.repaint();

	}

	public void refreshDirhams1Display(){

		this.nbdirham1.setText(j.getArgent(Joueur.PIECEUN)+" pièces de 1 dirham.");
		this.nbdirham1.repaint();


	}

	public void refreshDirhams5Display(){

		this.nbdirham5.setText(j.getArgent(Joueur.PIECECINQ)+" pièces de 5 dirhams.");
		this.nbdirham5.repaint();

	}
}