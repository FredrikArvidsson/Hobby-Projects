package application;

import java.awt.Color;

import framework.Filter;
import framework.Picture;

public class FlipY implements Filter{
	@Override
	public Picture transform(Picture p) {
		Picture flipY = new Picture( p.width(),p.height());
		for(int i=0;i<p.width();i++) {
			for(int j=0;j<p.height();j++) {
			Color c = p.get(i, j);
			flipY.set(i, p.height()-j-1, c);
			
			}
		}
		return flipY;
	}
	
}
