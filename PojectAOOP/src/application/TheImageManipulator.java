package application;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import framework.AdditionalFilters;
import framework.Function;
import framework.Picture;
import framework.PictureEditorFAO;

public class TheImageManipulator {
		
	public static void main(String[] args) {
		AdditionalFilters myOwnCreatedFilters = new MyFilters();
		PictureEditorFAO mainW = new PictureEditorFAO(myOwnCreatedFilters);
		PictureEditorFAO main2 = new PictureEditorFAO();
		PictureEditorFAO test = new PictureEditorFAO();
		Function a = new ShakeAndUndo("Shake And Undo", test);
		Function b = new TestAllDefaultFilters("Test Default Filters", test);
		test.addFunction(a);
		test.addFunction(b);
		test.setVisible(false);
				
		JFrame tester = new JFrame("Swap");
		tester.setLayout(new FlowLayout());
		JButton with = new JButton("With Extra Filter");
		with.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				main2.setVisible(false);
				test.setVisible(false);
				mainW.setVisible(true);
				
			}
		});
		JButton without = new JButton("Without Extra Filter");
		without.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainW.setVisible(false);
				test.setVisible(false);
				main2.setVisible(true);
				
				
			}
		});
		JButton withFunctions = new JButton("With Extra Functions");
		withFunctions.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				test.setVisible(true);
				mainW.setVisible(false);
				main2.setVisible(false);
			}
		});
		tester.add(with);
		tester.add(without);
		tester.add(withFunctions);
		tester.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-tester.getPreferredSize().getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-tester.getPreferredSize().getHeight()/2));
		tester.pack();
		tester.setVisible(true);
		tester.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

}
