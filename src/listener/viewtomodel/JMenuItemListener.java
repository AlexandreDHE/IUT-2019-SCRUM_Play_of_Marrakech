package listener.viewtomodel;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.event.*;

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
