package application;

import java.awt.Color;

import javax.swing.event.ChangeEvent;

import framework.FilterWithScale;
import framework.Picture;

public class ACircle implements FilterWithScale{
	private int radius;
	
	public ACircle() {
		radius = 50;
	}
	
	@Override
	public Picture transform(Picture p) {
		Picture bc = new Picture(p.width(),p.height());
		int r = radius;
		int h = p.width()/2;
		int k = p.height()/2;
		for(int i=0;i<p.width();i++) {
			for(int j=0;j<p.height();j++) {
				Color c = p.get(i, j);
				if(((Math.pow((i-h),2))+Math.pow((j-k), 2))<= Math.pow(r, 2))
					bc.set(i, j, Color.BLACK);
				else
					bc.set(i, j, c);
					
			}
		}
		return bc;
	}

	

	@Override
	public void change(int x) {
		radius = 50 + x*20;
		
	}

}
