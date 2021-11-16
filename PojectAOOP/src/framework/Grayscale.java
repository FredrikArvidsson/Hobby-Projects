package framework;

import java.awt.Color;

import framework.*;

public class Grayscale implements Filter {
	/**
	 * transform a picture to a grayscale version of the picture 
	 * @param p picture to be transformed
	 * @return the transformed picture
	 */
	@Override
	
	public Picture transform(Picture p) {
		Picture grayScale = new Picture( p.width(),p.height());
		for(int i=0;i<p.width();i++) {
			for(int j=0;j<p.height();j++) {
			Color c = p.get(i, j);
			Color newColor = new Color(c.getBlue(),c.getBlue(),c.getBlue());
			if(newColor.equals(new Color(0,0,0)))
				newColor = new Color(c.getGreen(),c.getGreen(),c.getGreen());
			if(newColor.equals(new Color(0,0,0)))
				newColor = new Color(c.getRed(),c.getRed(),c.getRed());
			grayScale.set(i, j, newColor);
			
			}
		}
		return grayScale;
		
		
	}
	
	
	
}
