package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * 
 * Changed, version BETA.af.1 ; 
 * + previousPicturesStack instead of previousPicture,
 * allows for more undos.
 * + Ctrl-Z to undo
 * + implemented a before/after feature
 * + now supporting FilterWithScale, scale 0-10
 * 
 * Changed, version BETA.af.2 ;
 * + improved GUI
 * + small bugfixes
 * 
 * Changed, Version BETA_af.3
 * + Changed name from MainFrame to PictureEditorFAO 
 * + fixed a bug where the program exited even if you pressed cancel in save mode while exiting
 * + Changed to FilteredPicture thePicture instead of Filter theFilter and Picture currentPicture
 * + Removed theScaleFilter
 * + Made ActionListeners anonymous and removed JMenuItem load,exit,undo,about, help 
 * and beforeAndAfter from class variables
 * 
 * 
 * changed, Version BETA_af.4
 * Fixed a bug with beforeAfter() where it would give error after loading a picture
 * with different size.
 * + Now able to add "Function" to editor with method addFunction(Function)
 * + Added public methods:changePicture(FilteredPicture),changePicture(Picture), 
 * undoIt(), canUndo() to help create Function, also made addFilterToPicture(Filter) public
 */


public class PictureEditorFAO extends JFrame{
	private ArrayList<Filter> defaultFilters;
	private ArrayList<Filter> additonalFilters;
	private Picture scalePicture;
	private PictureStack previousPicturesStack;
	private ImageArea pictureArea;
	private JMenuItem save;
	private JMenu defaultFiltersMenu,additonalFiltersMenu, filtersMenu;
	private boolean imageLoaded, beforeAfter, saved;
	private JPanel sliderPanel, content;
	private JSlider theSlider;
	private FilteredPicture thePicture; 
	
	
	/**
	 * 
	 * @param filters 
	 */
	public PictureEditorFAO(AdditionalFilters filters) {
		this();
		additonalFilters = filters.getAdditionalFilters();
	}
	
	public PictureEditorFAO() {
		super("PictureEditorFAO");
		thePicture = new FilteredPicture(null);
		previousPicturesStack = new PictureStack();
		imageLoaded = saved = false;
		content = new JPanel(new BorderLayout());		
		buildThePictureArea();
		buildTheMenu();
		buildTheSliderPanel();		
		WindowListener exitListener = new WindowAdapter() {

		    @Override
		    public void windowClosing(WindowEvent e) {
		        exit();
		    }
		};
		setResizable(false);
		addWindowListener(exitListener);
		add(content);
		pack();
		setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-getPreferredSize().getWidth()/2), 
				(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-getPreferredSize().getHeight()/2));

	}
	
	private void buildThePictureArea() {
		pictureArea  = new ImageArea();
		pictureArea.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				//Not used
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(imageLoaded && beforeAfter && previousPicturesStack.size()>0)
					beforeAfter(e.getX());
			}
		});
		pictureArea.setPreferredSize(new Dimension(600, 600));
		content.add(pictureArea, BorderLayout.NORTH);
	}
	
	private void buildTheSliderPanel() {
		sliderPanel = new JPanel(new FlowLayout());
		sliderPanel.setVisible(false);
		theSlider = new JSlider(0, 10, 0);
		theSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				thePicture.setPicture(scalePicture);
				int change = theSlider.getValue();
				((FilterWithScale)(thePicture.getFilter())).change(change);
				addFilterToPicture(thePicture.getFilter());
				
				
			}
		});
		JButton done = new JButton("DONE");
		done.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				previousPicturesStack.push(scalePicture);
				scalePicture = thePicture.getPicture();
				defaultFiltersMenu.setEnabled(true);
				additonalFiltersMenu.setEnabled(true);
				sliderPanel.setVisible(false);
				
				/*previousPicturesStack.push(scalePicture);
				scalePicture = currentPicture;
				defaultFiltersMenu.setEnabled(true);
				additonalFiltersMenu.setEnabled(true);
				sliderPanel.setVisible(false);*/
				pack();
			}
		});
		sliderPanel.add(theSlider);
		sliderPanel.add(done);
		content.add(sliderPanel, BorderLayout.SOUTH);
		pack();
	}
		
	private void buildTheMenu() {
		
		defaultFilters = new DefaultFilters().getAdditionalFilters();
		
		JMenuBar theMenuBar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		filtersMenu = new JMenu("Filters");
		defaultFiltersMenu = new JMenu("Default Filters");
		additonalFiltersMenu = new JMenu("Additonal Filters");
		filtersMenu.add(defaultFiltersMenu);
		filtersMenu.add(additonalFiltersMenu);
		filtersMenu.setEnabled(false);
		
		JMenuItem undo = new JMenuItem("Undo");
		undo.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				undo();
				
			}
		});
		filtersMenu.add(undo);
		
		JCheckBoxMenuItem beforeAndAfter = new JCheckBoxMenuItem("Before/After");
		beforeAndAfter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == (JCheckBoxMenuItem) beforeAndAfter  ) {
					beforeAfter = !beforeAfter;
					if(!beforeAfter && imageLoaded)
						pictureArea.changePicture(thePicture.getPicture());
				}
				
			}
		});
		filtersMenu.add(beforeAndAfter);
		
		JMenu helpMenu = new JMenu("Help");
		
		save = new JMenuItem("Save");
		save.setEnabled(false);
		save.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
				
			}
		});
		
		JMenuItem load = new JMenuItem("Load");
		load.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		load.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				load();
				
			}
		});
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
				
			}
		});
		
		file.add(load);
		file.add(save);
		file.add(exit);
		
		
		JMenuItem help = new JMenuItem("Help");
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(PictureEditorFAO.this,
					    "1: Load a picture from a file by pressing File>>Load or use ctrl+O \n"
					    + "2: Apply filter by pressing Filters>>Default Filters or Filters>>Additional Filters\n"
					    + "3: Undo by pressing Filters>>Undo or Ctrl+Z\n"
					    + "4: Save by pressing File>>Save or Ctrl+S", "Help",JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(PictureEditorFAO.this,
						"Author: Fredrik - GUI\n"
						+ "Author: Oday - Filter interfaces and default filters\n"
						+ "Author: Ahmad - Default filters and PictureStack\nYear: 2018\nVersion: BETA_af.4",
					    "About",
					    JOptionPane.INFORMATION_MESSAGE);
			
				
			}
		});
		helpMenu.add(help);
		helpMenu.add(about);
		
		theMenuBar.add(file);
		theMenuBar.add(filtersMenu);
		theMenuBar.add(helpMenu);
		setJMenuBar(theMenuBar);
	}
		
	private void buildFilterMenu() {
		if(!imageLoaded) {
			imageLoaded = true;
			for(Filter f : defaultFilters) {
				JMenuItem temp = new JMenuItem(f.getClass().getSimpleName());
				temp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//thePicture.setFilter(f);
						addFilterToPicture(f);
						if(f instanceof FilterWithScale) {
							//theFilter = (FilterWithScale) f;
							theSlider.setValue(0);
							defaultFiltersMenu.setEnabled(false);
							additonalFiltersMenu.setEnabled(false);
							sliderPanel.setVisible(true);
							pack();
						}
						//else {
							//theFilter = f;
							
						//}
					}
				});
				
				defaultFiltersMenu.add(temp);
			}
			if(additonalFilters != null) {
				for(Filter f2 : additonalFilters) {
					JMenuItem temp = new JMenuItem(f2.getClass().getSimpleName());
					temp.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							//thePicture.setFilter(f2);
							addFilterToPicture(f2);
							if(f2 instanceof FilterWithScale) {
								//theFilter = (FilterWithScale) f2;
								theSlider.setValue(0);
								defaultFiltersMenu.setEnabled(false);
								additonalFiltersMenu.setEnabled(false);
								sliderPanel.setVisible(true);
								pack();
							}
							//else {
								//theFilter = f2;
								
							//}

						}
					});
					additonalFiltersMenu.add(temp);
				}
			}
		}
	}
	
	private void exit() {
		if(saved || !imageLoaded || previousPicturesStack.size() == 0)
			System.exit(0);
		else {
			Object[] options = {"Yes",
                    "No",
                    "Cancel"};
			int n = JOptionPane.showOptionDialog(this,
		    "Would you like to save?",
		    "Picture not saved",
		    JOptionPane.YES_NO_CANCEL_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[2]);
			if(n==0) {
				save();
				if(saved)
					System.exit(0);
			}
			if(n==1)
				System.exit(0);
			if(n == 2)
				setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
		
		
	}
	private void save() {
		if(imageLoaded) {
			FileDialog chooser = new FileDialog(this,
	                "Use a .png, .gif or .jpg extension", FileDialog.SAVE);
			chooser.setVisible(true);
			if (chooser.getFile() != null) {
				//currentPicture.save(chooser.getDirectory() + File.separator + chooser.getFile());
				thePicture.getPicture().save(chooser.getDirectory() + File.separator + chooser.getFile());
				saved = true;
			}
			
		}
	}
	private void load() {
		save.setEnabled(true);
		filtersMenu.setEnabled(true);
		FileDialog chooser = new FileDialog(this,
                "Load an Image", FileDialog.LOAD);
		chooser.setVisible(true);
		if (chooser.getFile() != null) {
			if(thePicture.getPicture() != null)
				previousPicturesStack.push(thePicture.getPicture());
			thePicture = new FilteredPicture(new Picture(chooser.getDirectory() + File.separator + chooser.getFile()));
			pictureArea.changePicture(thePicture.getPicture());
			scalePicture= thePicture.getPicture();
			/*if(currentPicture != null)
				previousPicturesStack.push(currentPicture);
			currentPicture = new Picture(chooser.getDirectory() + File.separator + chooser.getFile());
			pictureArea.changePicture(currentPicture);
			scalePicture= currentPicture;
			*/
			buildFilterMenu();
			pack();
			setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-getPreferredSize().getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-getPreferredSize().getHeight()/2));

		}
	}
	private void undo() {
		try {
			thePicture.setPicture(previousPicturesStack.pop());
			scalePicture = thePicture.getPicture();
			pictureArea.changePicture(thePicture.getPicture());
			
			/*currentPicture = scalePicture = previousPicturesStack.pop();
			pictureArea.changePicture(currentPicture);*/
			pack();
			setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-getPreferredSize().getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-getPreferredSize().getHeight()/2));
			}catch(IndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(this,
					"Can't undo more",
				    "Fail",
				    JOptionPane.ERROR_MESSAGE
				    );
			}
		
	}
	private void beforeAfter(int x) {
		/*Picture temp = new Picture(currentPicture.width(), currentPicture.height());
		for(int i=0; i<currentPicture.width();i++)
			for(int j=0;j<currentPicture.height();j++) {
				if(i<x) {
					Color c = currentPicture.get(i, j);
					temp.set(i, j, c);
				}
				else {
					Color c = previousPicturesStack.peek().get(i, j);
					temp.set(i, j, c);
				}
			}
		pictureArea.changePicture(temp);*/
		if(thePicture.getPicture().width() == previousPicturesStack.peek().width() &&
				thePicture.getPicture().height() == previousPicturesStack.peek().height()) {
			Picture temp = new Picture(thePicture.getPicture().width(), thePicture.getPicture().height());
			for(int i=0; i<thePicture.getPicture().width();i++)
				for(int j=0;j<thePicture.getPicture().height();j++) {
					if(i<x) {
						Color c = thePicture.getPicture().get(i, j);
						temp.set(i, j, c);
					}
					else {
						Color c = previousPicturesStack.peek().get(i, j);
						temp.set(i, j, c);
					}
				}
			pictureArea.changePicture(temp);
		}	
	}
	public void addFilterToPicture(Filter f) {
		saved = false;
		if(!(f instanceof FilterWithScale) ) 
			previousPicturesStack.push(thePicture.getPicture());
		thePicture.setFilter(f); 
		pictureArea.changePicture(thePicture.getPicture());
		if(!(f instanceof FilterWithScale )) {
			sliderPanel.setVisible(false);
			pack();
			setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-getPreferredSize().getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-getPreferredSize().getHeight()/2));
			scalePicture = thePicture.getPicture();
		}
		
		/*saved = false;
		if(!(theFilter instanceof FilterWithScale) ) 
			previousPicturesStack.push(currentPicture);
		currentPicture = theFilter.transform(currentPicture);
		pictureArea.changePicture(currentPicture);
		if(!(theFilter instanceof FilterWithScale )) {
			sliderPanel.setVisible(false);
			pack();
			scalePicture = currentPicture;
		}*/
	}
	//Methods to help add functions
	/**
	 * 
	 * @return A copy of the FilteredPicture (OBS not THE FilteredPicture)
	 */
	public FilteredPicture getFilteredPicture() {
		FilteredPicture temp = new FilteredPicture(thePicture.getPicture(), thePicture.getFilter());
		return temp;
	}
	public void changePicture(FilteredPicture pic) {
		thePicture = pic;
		addFilterToPicture(thePicture.getFilter());
	}
	public void changePicture(Picture pic) {
		thePicture.setPicture(pic);
		addFilterToPicture(thePicture.getFilter());
	}
	public void undoIt() {
		if(canUndo())
			undo();
	}
	public boolean canUndo() {
		return previousPicturesStack.size() > 0;
	}
	public ArrayList<Filter> getDefaultFilters(){
		ArrayList<Filter> temp = new ArrayList<Filter>(defaultFilters);
		return temp;
	}
	public void addFunction(Function func) {
		filtersMenu.add(func);
	}
	

	

	
	
	

}
