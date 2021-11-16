package application;

import java.awt.Color;

import framework.FilterWithScale;
import framework.Picture;

public class Ahmad implements FilterWithScale {
	
	double darkzone;
	
	public Ahmad(){
		darkzone = 0.10;
	}
	

	@Override
	public Picture transform(Picture p) {
		Picture temp = new Picture(p.width(), p.height());
		
		int ahmad=(int)(p.height()*darkzone);
		int ahmad1=(int)(p.width()*darkzone); 
		for(int i=0; i<p.width();i++)
			for(int j=0;j<p.height();j++) {
				if(j<ahmad&&i<ahmad1) {
					Color c = Color.BLACK;
					temp.set(i, j, c);
					
				}
				else {
					Color c = p.get(i, j);
					temp.set(i, j, c);
				}
			}
		return temp;
		
		
	
		
	}

	@Override
	public void change(int x) {
		darkzone = 0.1*x;
		
	
		
	}
	

	
}
