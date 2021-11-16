package framework;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FlipX implements Filter{
	
	@Override
	/** transform a picture to a horizontal mirrored picture 
	 * @param p picture to be transformed
	 * @return the transformed picture
	 */
	public Picture transform(Picture p) {
		Picture flipX = new Picture( p.width(),p.height());
		for(int i=0;i<p.width();i++) {
			for(int j=0;j<p.height();j++) {
			Color c = p.get(i, j);
			flipX.set(p.width()-i-1, j, c);
			
			}
		}
		return flipX;
	}
	
	
	
	
	
	
}
