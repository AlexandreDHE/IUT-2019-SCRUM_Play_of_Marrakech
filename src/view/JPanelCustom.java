package view;
import javax.swing.*;

import listener.MenuControler;

import java.awt.*;
import java.awt.Color.*;

public class JPanelCustom extends JPanel{

	private Image image;

	public JPanelCustom(Image image){

		this.image = image;


	}

	public void paintComponent(Graphics g){

		super.paintComponents(g);
		g.drawImage(image, 0, 0,getWidth(),getHeight(), null);
	}
}