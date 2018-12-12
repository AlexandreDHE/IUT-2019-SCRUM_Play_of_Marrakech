package view;

import java.awt.*;
import javax.swing.*;

import model.Assam;

public class AssamPanel extends JPanel{

	OpenImage front = new OpenImage(50,50,"./drawable/front.png");
	OpenImage back = new OpenImage(50,50,"./drawable/back.png");
	OpenImage left = new OpenImage(50,50,"./drawable/left.png");
	OpenImage right = new OpenImage(50,50,"./drawable/right.png");
	OpenImage currentImage;

	public AssamPanel()
	{
		this.currentImage = back;
		this.add(this.currentImage);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(254, 153, 1)));
	}
	
	public void setAssam(int assamOrientation)
	{
		switch(assamOrientation)
		{
			case Assam.NORD : this.setAssamTop(); break;
			case Assam.EST : this.setAssamRight(); break;
			case Assam.SUD : this.setAssamBottom(); break;
			case Assam.OUEST : this.setAssamLeft(); break;
			default : break;
		}
		
	}

	public void setAssamLeft(){

		this.remove(this.currentImage);
		this.currentImage = this.left;
		this.add(this.currentImage);
		this.revalidate();
		this.repaint();

	}

	public void setAssamRight(){

		this.remove(this.currentImage);
		this.currentImage = this.right;
		this.add(this.currentImage);
		this.revalidate();
		this.repaint();

	}

	public void setAssamTop(){

		this.remove(this.currentImage);
		this.currentImage = this.back;
		this.add(this.currentImage);
		this.revalidate();
		this.repaint();

	}

	public void setAssamBottom(){

		this.remove(this.currentImage);
		this.currentImage = this.front;
		this.add(this.currentImage);
		this.revalidate();
		this.repaint();

	}

}