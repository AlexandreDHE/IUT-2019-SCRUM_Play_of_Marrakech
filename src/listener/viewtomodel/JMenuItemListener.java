package listener.viewtomodel;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.event.*;

/**
* La classe JMenuItemListener est le contrôleur des JMenuItems de la classe PlayScreen.
* Ce contrôleur permet de gérer les actions liées aux JMenuItems de la JMenuBar.
* 
* @see PlayScreen
*/

public class JMenuItemListener implements ActionListener{  

    public void actionPerformed(ActionEvent e){  

        if(e.getActionCommand().equals("Sauver et quitter")){

            //Save method
            System.exit(0);
         
        }  
        if(e.getActionCommand().equals("Quitter sans sauver")){

            System.exit(0);

        }
    }
}
