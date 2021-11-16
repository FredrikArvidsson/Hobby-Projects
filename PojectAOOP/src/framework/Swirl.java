package framework;

import java.util.ArrayList;

public class Swirl implements FilterWithScale {
	private int size;
	private final int DEFAULT_VALUE=500;
	public Swirl() {
		size = DEFAULT_VALUE;
	}
	
	@Override
	/** transform a picture to a picture with a swirl
	 * @param p picture to be transformed
	 * @return the transformed picture
	 */
	public Picture transform(Picture p) {
		double x0 = 0.5 * (p.width()  - 1);
	    double y0 = 0.5 * (p.height() - 1);
	    Picture swirl = new Picture(p.width(), p.height());
	      // swirl
	      for (int sx = 0; sx < p.width(); sx++) {
	          for (int sy = 0; sy < p.height(); sy++) {
	        	  double dx = sx - x0;
	              double dy = sy - y0;
	              double r = Math.sqrt(dx*dx + dy*dy);
	              double angle = Math.PI /size * r;
	              int tx = (int) (+dx * Math.cos(angle) - dy * Math.sin(angle) + x0);
	              int ty = (int) (+dx * Math.sin(angle) + dy * Math.cos(angle) + y0);

	              // plot pixel (sx, sy) the same color as (tx, ty) if it's in bounds
	              if (tx >= 0 && tx < p.width() && ty >= 0 && ty < p.height())
	            	  swirl.set(sx, sy, p.get(tx, ty));
	           }
	        
	      }
	      return swirl;
	}
	@Override
	/**
	 * @param x preferably between 0-10 to change the amount of swirl applied in the filter
	 */
	public void change(int x) {
		size = DEFAULT_VALUE - x*45;
	}
				
}
