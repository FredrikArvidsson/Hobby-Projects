package application;

import framework.Filter;
import framework.Picture;
import java.awt.*;

public class test implements Filter {

	@Override
	public Picture transform(Picture p) {
		Picture temp = new Picture(p.width(), p.height());
		for(int i = 0 ; i < p.width() ; i++) {
			for (int j = 0 ; j < p.height() ; j ++) {
				Color c = p.get(i, j);
				
			if (i <= p.width()/3)
				temp.set(i,j,new Color(c.getRed(),0,0));
			if (i>= p.width()/3 && i<= ((2*p.width())/3))
				temp.set(i,j,new Color(0,c.getGreen(),0));
			if (i>= ((2*p.width())/3)) 				
				temp.set(i,j,new Color(0,0,c.getBlue()));
			
				
			}
		}
		return temp;
	}

}
