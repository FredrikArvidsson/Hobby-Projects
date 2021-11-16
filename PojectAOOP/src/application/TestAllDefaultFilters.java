package application;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import framework.Filter;
import framework.FilterWithScale;
import framework.Function;
import framework.PictureEditorFAO;

public class TestAllDefaultFilters extends Function{

	public TestAllDefaultFilters(String functionName, PictureEditorFAO editor) {
		super(functionName, editor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void whatToDo() {
		ArrayList<Filter> theFilters = theEditor.getDefaultFilters();
		for(Filter f : theFilters) {
			if(!(f instanceof FilterWithScale)) {
				theEditor.addFilterToPicture(f);
				JOptionPane.showMessageDialog(theEditor,
						"Next Filter plz",
					    "Do Next",
					    JOptionPane.INFORMATION_MESSAGE);
				theEditor.undoIt();
			}
				
		}
		JOptionPane.showMessageDialog(theEditor,
			    "This was the default Filters without a scale.\n"
			    + "For Swirl, go Filter>>Default Filter>>Swirl"
			    ,"No more Filters",
			    JOptionPane.INFORMATION_MESSAGE);
		
	}

}
