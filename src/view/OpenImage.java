package view;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.event.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OpenImage extends JLabel{

	String baseimg = new String("img/noimg.png");

	public OpenImage(int width, int height, String imgpath){
		File path = new File(imgpath);

		if(path.exists()){
			displayImage(width, height, imgpath, path);
		}else{
			File newpath = new File(baseimg);
			displayImage(width, height, baseimg, newpath);
		}
	}

	void displayImage(int width, int height, String imgpath, File file){

		try{
			BufferedImage myPicture = ImageIO.read(file);
			ImageIcon imgicon = new ImageIcon(myPicture);
			ImageIcon icon = new ImageIcon(new ImageIcon(imgpath).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
			this.setIcon(icon);

		}catch(IOException e){
			this.setText("Erreur lors du chargement de l'image");
		}
	}
}  

