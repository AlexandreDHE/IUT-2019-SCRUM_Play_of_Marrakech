package view.parameter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import view.OpenImage;

public class ItemParameter extends JPanel
{
	private String pictureFilePath;
	private String description;
	
	private boolean hover;
	private boolean selected;
	

	public ItemParameter( String pictureFilePath, String description) 
	{
		this.pictureFilePath = pictureFilePath;
		this.description = description;
		this.setLayout(new GridBagLayout());
		OpenImage picture = new OpenImage(100, 100, this.pictureFilePath);
		picture.setOpaque(false);
		this.add(picture);
		this.hover = false;
		this.selected = false;
	}
	
	public void setHover(boolean hover)
	{
		this.hover = hover;
		this.repaint();
	}
	
	public void setSelected(boolean selected)
	{
		this.selected = selected;
		this.repaint();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       Dimension arcs = new Dimension(45,45); 
       int width = getWidth();
       int height = getHeight();
       Graphics2D graphics = (Graphics2D) g;
       graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


       if(!selected)
       {
    	   if(!hover)
           {
        	   graphics.setColor(new Color(255,255,255)); 
           }
           else
           {
        	   graphics.setColor(new Color(153,217,234)); 
           }
       }
       else
       {
    	   graphics.setColor(new Color(34,177,76));  
       }
      
       graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
       graphics.setColor(getForeground());
       graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
    }

}
