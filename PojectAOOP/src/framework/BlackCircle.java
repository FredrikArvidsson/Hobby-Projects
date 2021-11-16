package framework;

import java.awt.Color;

import javax.swing.JLabel;

public class BlackCircle implements Filter{
	
	/** transform a picture to a picture with a black circle with the diameter of the picture's width 
	 * @param p picture to be transformed
	 * @return the transformed picture
	 */
	@Override
	public Picture transform(Picture p) {
		Picture bc = new Picture(p.width(),p.height());
		int radius = p.width()/2;
		int h = p.width()/2;
		int k = p.height()/2;
		for(int i=0;i<p.width();i++) {
			for(int j=0;j<p.height();j++) {
				Color c = p.get(i, j);
				if(((Math.pow((i-h),2))+Math.pow((j-k), 2))<= Math.pow(radius, 2))
					bc.set(i, j, Color.BLACK);
				else
					bc.set(i, j, c);
					
			}
		}
		return bc;
	}
	

}
