package application;

import java.awt.Color;

import framework.Filter;
import framework.Picture;

public class Greenscale implements Filter{
	@Override
	public Picture transform(Picture p) {
		Picture greenScale = new Picture( p.width(),p.height());
		for(int i=0;i<p.width();i++) {
			for(int j=0;j<p.height();j++) {
			Color c = p.get(i, j);
			greenScale.set(i, j, new Color(0,c.getGreen(),0));
			
			}
		}
		return greenScale;
	}
	
}
