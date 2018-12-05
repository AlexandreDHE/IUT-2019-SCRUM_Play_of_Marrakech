package view;

import java.awt.*;
import javax.swing.*;

import model.Couleur;
import model.Joueur;  

public class ScorePanel extends JPanel{

	public ScorePanel(Joueur j, int top, int left, int bottom, int right){

		JLabel numplayer = new JLabel("Joueur "+(j.getCouleur()+1));
		JLabel nbtapis = new JLabel();
		JLabel nbdirham1 = new JLabel();
		JLabel nbdirham5 = new JLabel();

		JPanel player = new JPanel();
		JPanel tapis = new JPanel();
		JPanel dirhams1 = new JPanel();
		JPanel dirhams5 = new JPanel();

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

		this.add(player);
		this.add(tapis);
		this.add(dirhams1);
		this.add(dirhams5);
	}
}