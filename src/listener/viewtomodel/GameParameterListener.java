package listener.viewtomodel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import view.ItemParameter;

public class GameParameterListener implements MouseListener
{
	private ItemParameter[] parameters;
	
	public GameParameterListener(ItemParameter[] parameters) 
	{
		this.parameters = parameters;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		ItemParameter parameter = (ItemParameter)e.getComponent();
		parameter.setSelected(true);
		for(int i = 0; i < this.parameters.length; i++)
		{
			if(parameter != this.parameters[i])
			{
				this.parameters[i].setSelected(false);
			}
		}
	}

	public void mouseEntered(MouseEvent e)
	{
		ItemParameter parameter = (ItemParameter)e.getComponent();
		parameter.setHover(true);
	}
	
	public void mouseExited(MouseEvent e)
	{
		ItemParameter parameter = (ItemParameter)e.getComponent();
		parameter.setHover(false);
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
}

