package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public abstract class Function extends JMenuItem{
	protected PictureEditorFAO theEditor;
	
	public Function(String functionName) {
		super(functionName);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				whatToDo();
				
			}
		});
	}
	
	public Function(String functionName, PictureEditorFAO editor) {
		this(functionName);
		theEditor = editor;
	}
	
	public PictureEditorFAO getEditor() {
		return theEditor;
	}
	
	public abstract void whatToDo();
}
