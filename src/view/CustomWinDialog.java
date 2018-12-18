package model;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.PlayScreen;

/**
 * Cette classe permet de créer une boîte de dialogue personnalisée. Elle intervient à la fin
 * d'une partie pour annoncer le n° du joueur gagnant, son nombre de tapis,
 * son nombre de Dirhams et le total de ses points (nombre de tapis + nombre de Dirhams).
 * Elle permet à l'utilisateur de recommencer une partie avec les mêmes paramètres,
 * de rester sur la fenêtre de jeu pour contempler les scores ou bien de quitter l'application.
 */

public class CustomWinDialog{
  
    /**
 	* Constructeur de la classe CustomWinDialog.
 	* @param ps
    *			Fenêtre de jeu appelante et par-dessus laquelle la boîte de dialogue se placera. 
    *			@see PlayScreen
    * @param game
    *			Classe gèrant le déroulement d'une partie et regroupant l'ensemble de ses caractéristiques.
    *			@see Game
 	*/

  public CustomWinDialog(PlayScreen ps, Joueur j){
	  
	  PlayScreen newGame = new PlayScreen(ps.getGame());
	  
	  int numPlayer = j.getCouleur()+1;
	  int nbCarpets = j.getCarpetsLeft();
	  int nbDirhams = j.getArgentTotal();
	  int sum = nbCarpets + nbDirhams;
	  int res;
	  
	  String message =   "Le joueur "+numPlayer+
	  " a gagné ! \n Bravo à lui ! \n----------\n Nombre de tapis : "
	  +nbCarpets+"\n Nombre de Dihrams : "
	  +nbDirhams+"\n----------\n Total : "
	  +sum+"\n\n Voulez-vous recommencer une partie ?";

	  Object[] options = {"Oui", "Non", "Quitter"};
	  
	  res = JOptionPane.showOptionDialog(ps, message, "Gagné !", JOptionPane.YES_NO_CANCEL_OPTION, 
			  													   JOptionPane.INFORMATION_MESSAGE,
			  													   null,
			  													   options,
			  													   options[2]);
	  
      switch (res) {
      case 0:
    	  newGame.setVisible(true);
    	  break;
      case 1: break;
      case 2:
          System.exit(0);
          break;
      }
  }
}
