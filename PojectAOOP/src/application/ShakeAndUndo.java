package application;

import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import framework.Function;
import framework.PictureEditorFAO;

public class ShakeAndUndo extends Function{
	
	JFrame frame;
	public ShakeAndUndo(String functionName, PictureEditorFAO editor) {
		super(functionName, editor);
		frame = theEditor;
		
	}
	private void shake() {
		Point currLocation;
		int iDisplaceXBy = 5;
		int iDisplaceYBy = -10;
		currLocation = frame.getLocationOnScreen();
		Point position1 = new Point(currLocation.x + iDisplaceXBy, currLocation.y
	        + iDisplaceYBy);
	    Point position2 = new Point(currLocation.x - iDisplaceXBy, currLocation.y
	        - iDisplaceYBy);
	    for (int i = 0; i < 500; i++) {
	      frame.setLocation(position1);
	      frame.setLocation(position2);
	    }
	    frame.setLocation(currLocation);
	}
	@Override
	public void whatToDo() {
		shake();
		getEditor().undoIt();
		
	}
}
