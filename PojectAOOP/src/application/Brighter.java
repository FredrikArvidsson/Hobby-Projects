package application;

import java.awt.Color;

import framework.FilterWithScale;
import framework.Picture;

public class Brighter implements FilterWithScale{
	int theBrightness;
	
	public Brighter() {
		theBrightness = 0;
	}
	
	@Override
	public Picture transform(Picture p) {
		 Picture temp = new Picture(p.width(), p.height());
	        for (int x = 0; x < p.width(); x++) {
	            for (int y = 0; y < p.height(); y++) {
	                Color c1 = p.get(x, y);
	                Color c2 = c1;
	                for(int i=0; i< theBrightness;i++)
	                	c2 = c2.brighter();
	                temp.set(x, y, c2);
	            }
	        }
	        return temp;
	}

	@Override
	public void change(int x) {
		theBrightness = x;
		
	}

}
