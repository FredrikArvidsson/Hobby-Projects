package framework;
import java.awt.Color;

import framework.*;


public class VerticalStripes implements Filter {

	@Override
	/**
	 * @param p picture to be transformed
	 * @return picture with Stripes
	 */
	public Picture transform(Picture p) {
		Picture vs = new Picture(p.width(),p.height());
		int barHeight = p.width()/20;
		for(int i=0;i<p.width();i++) {
			for(int j=0;j<p.height();j++) {
				Color c = p.get(i, j);
				if((i/barHeight)%2 == 0) {
					vs.set(i, j, c);
				}
				else {
					vs.set(i, j, Color.BLACK);
					
				}
			}
		}
		return vs;
	}
	
}
