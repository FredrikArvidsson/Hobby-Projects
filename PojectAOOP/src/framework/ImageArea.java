package framework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageArea extends JLabel{
	
	public ImageArea() {
		setPreferredSize(new Dimension(600, 600));
		this.setBackground(new Color(255,255,255));
	}
	public void changePicture(Picture p) {
		setPreferredSize(new Dimension(p.width(), p.height()));
		setIcon(new ImageIcon(p.getImage()));
		repaint();
	}

	

}
