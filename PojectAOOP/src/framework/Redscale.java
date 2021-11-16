package framework;

import java.awt.Color;

public class Redscale implements Filter{
	@Override
	
	/** transform a picture to a redscale version of the picture 
	 *  @param p picture to be transformed
	 * @return the transformed picture
	 */
	public Picture transform(Picture p) {
		Picture redScale = new Picture( p.width(),p.height());
		for(int i=0;i<p.width();i++) {
			for(int j=0;j<p.height();j++) {
			Color c = p.get(i, j);
			redScale.set(i, j, new Color(c.getRed(),0,0));
			
			}
		}
		return redScale;
	}
	
	public static void main(String[] cmdln) {
		Redscale a = new Redscale();
		Picture b = a.transform(new Picture("kukhuvudet.jpg"));
		b.show();
	}
	
}
