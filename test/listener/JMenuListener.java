package listener;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.event.*;

import view.PlayScreen;
import view.SelectPlayer;

public class JMenuListener implements MenuListener {

    PlayScreen ps;

    public JMenuListener(PlayScreen ps){
        this.ps = ps;
    }

    @Override
    public void menuSelected(MenuEvent e){

        if(e.getSource() == ps.back){
            
            SelectPlayer sp = new SelectPlayer();
            ps.dispose();
            sp.setVisible(true);

        }
    }

    @Override
    public void menuDeselected(MenuEvent e){}

    @Override
    public void menuCanceled(MenuEvent e){}
} 