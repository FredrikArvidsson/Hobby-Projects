package framework;

import java.awt.Color;

public class Chessboard implements Filter {

	@Override
	/** transform a picture to a picture with a "chessboard" 
	 * @param p picture to be transformed
	 * @return the transformed picture
	 */
	public Picture transform(Picture p) {
		Picture vs = new Picture(p.width(),p.height());
		int squareWidth = p.width()/8;
		int squareHeight = p.height()/8;
		
		for(int i=0;i<p.width();i++) {
			for(int j=0;j<p.height();j++) {
				Color c = p.get(i, j);
				if((i/squareWidth)%2 != (j/squareHeight)%2 ) {
					vs.set(i, j, c);
				}
				else
					vs.set(i, j, Color.BLACK);
			
			}
		}
		return vs;
	}
	
}