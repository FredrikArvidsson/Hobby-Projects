package LearnTheClock;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


/**
 * 
 * @author Fredrik Arvidsson
 *
 */
public class ClockView extends JFrame {
		
	private JPanel trainingPanel,voiceButtonsContainer;
	private JMenuItem trainingMode, voiceMode;
	private JButton listen, hourForward, hourBackwards, minutesForward, minutesBackwards, generateButton;
	private JButton[] guessButtons;
	private ClockPanel theClock;
	
	public ClockView() {
		super("Lär dig klockan");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		//setPreferredSize(new Dimension(800,800));
		buildMenu();
		buildTheClock();
		buildButtonPanel();
		buildTrainingPanel();
		
	}
	
	private void buildMenu() {
		JMenuBar mainMenu = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenu modes = new JMenu("Läge");
		mainMenu.add(menu);
		mainMenu.add(modes);
		voiceMode = new JMenuItem("Röstläge");
		trainingMode = new JMenuItem("Träningsläge");
		
		modes.add(voiceMode);
		modes.add(trainingMode);
		JMenuItem quit = new JMenuItem("Stäng");
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(quit);
		setJMenuBar(mainMenu);
	}
	
	private void buildTheClock() {
		theClock = new ClockPanel();
		add(theClock, BorderLayout.WEST);
	}
	
	private void buildButtonPanel() {
		listen = new JButton();
		hourForward = new JButton(">>");
		hourBackwards = new JButton("<<");
		minutesForward = new JButton(">>");
		minutesBackwards = new JButton("<<");
		listen.setIcon(new ImageIcon("listen.jpg"));
		voiceButtonsContainer = new JPanel(new BorderLayout());
		JPanel clockButtons = new JPanel(new BorderLayout());
		JPanel soundButton = new JPanel(new BorderLayout());
		voiceButtonsContainer.add(clockButtons, BorderLayout.CENTER);
		voiceButtonsContainer.add(soundButton, BorderLayout.EAST);
		
		JPanel hourButtons = new JPanel(new FlowLayout());
		hourButtons.setBackground(new Color(255,255,255));
		JLabel hour = new JLabel("Timmar");
		hour.setFont(new Font("Arial", Font.PLAIN, 25));
		hourButtons.add(hourBackwards);
		hourButtons.add(hour);
		hourButtons.add(hourForward);
				
		JPanel minutesButtons = new JPanel(new FlowLayout());
		minutesButtons.setBackground(new Color(255,255,255));
		
		JLabel minutes = new JLabel("Minuter");
		minutes.setFont(new Font("Arial", Font.PLAIN, 25));
		minutesButtons.add(minutesBackwards);
		minutesButtons.add(minutes);
		minutesButtons.add(minutesForward);
		
		clockButtons.add(hourButtons, BorderLayout.NORTH);
		clockButtons.add(minutesButtons, BorderLayout.SOUTH);
		soundButton.add(listen, BorderLayout.CENTER);
		add(voiceButtonsContainer,BorderLayout.SOUTH);
	}
	
	private void buildTrainingPanel() {
		trainingPanel = new JPanel();
		trainingPanel.setLayout(new GridLayout(8, 1));
		generateButton = new JButton("Ny Tid!");
		generateButton.setFont(new Font("Arial", Font.PLAIN, 30));
		trainingPanel.add(generateButton);
		guessButtons = new JButton[7];
		for(int i=0;i<7;i++) {
			
			guessButtons[i] = new JButton();
			guessButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
			trainingPanel.add(guessButtons[i]);
		}
		
		trainingPanel.setPreferredSize(new Dimension(200, 800));
		trainingPanel.setBackground(Color.LIGHT_GRAY);
		add(trainingPanel, BorderLayout.EAST);
		trainingPanel.setVisible(false);
	}
	
	
	public void drawPointers(ClockModel cm) {
		theClock.setPointers(cm);
		theClock.repaint();
	}	
	
	
	public void addButtonsToTrainingPanel(JButton[] theButtons) {
		for(int i=0;i<theButtons.length;i++) {
			trainingPanel.add(theButtons[i]);
		}
	}
	
	public void setModeToTraining() {
		trainingPanel.setVisible(true);
		voiceButtonsContainer.setVisible(false);
		pack();
	}
	
	public void setModeToVoiceMode() {
		voiceButtonsContainer.setVisible(true);
		trainingPanel.setVisible(false);
		pack();
	}
	public void generateAnswerButtons(ClockModel theModel) {
		
		int[] hours = {12,1,2,3,4,5,6,7,8,9,10,11};
		String[] minutes = {"", "Fem över ", "Tio över ", "Kvart över ", "Tjugo över ", "Fem i halv ", "Halv ",
				"Fem över halv ", "Tjugo i ", "Kvart i ", "Tio i ", "Fem i "};
		String[] allPossibilities = new String[hours.length*minutes.length];
		for(int i=0;i<minutes.length;i++) {
			for(int l=0;l<hours.length;l++) {
				allPossibilities[i*(hours.length)+l] = minutes[i] + hours[l];
			}
		}
			
		
		String correct, temp;
		String[] incorrect = {"-1","-1","-1","-1","-1","-1","-1"};
		if(theModel.getMinutes()>4) //Vi använder nästkommande timme om klockan är mer än tjugo över (T.ex >3<.25 blir fem i halv >4<)
			correct = minutes[theModel.getMinutes()] + hours[theModel.getHour()+1];
		else
			correct = minutes[theModel.getMinutes()] + hours[theModel.getHour()];
		
		//Generera 7 möjliga svar, 6 fel 1 rätt att välja mellan
		for(int i=0;i<7;i++) {
			temp = allPossibilities[(int)(Math.random()*(hours.length*minutes.length))];
			while(temp.equals(correct) || Arrays.asList(incorrect).contains(temp)) {
				temp = allPossibilities[(int)(Math.random()*(hours.length*minutes.length))];
			}
			incorrect[i] = temp;
		}
		int correctIndex = (int)(Math.random()*6);
		int incorrecta = 0;
		
		
		//Gör så knappen blir grön och det är rätt svar och röd om det är fel
		for(int i=0;i<7;i++) {
			if(guessButtons[i].getActionListeners().length > 0)
				guessButtons[i].removeActionListener(guessButtons[i].getActionListeners()[0]);
			//JButton tempa, tempa2;
			if(i == correctIndex) {
				guessButtons[i].setText(correct);
				guessButtons[i].addActionListener(new CorrectButton());
			}
			else {
				guessButtons[i].setText(incorrect[incorrecta++]);
				guessButtons[i].addActionListener(new IncorrectButton());
			}
			guessButtons[i].setBackground(new JButton().getBackground());
		}
		
			
		
	}
		
	//Funktioner för att lägga till actionlistener till knapparna från controllen klassen
	public void listenForGenerateButton(ActionListener listenerForGenerateTime) {
		generateButton.addActionListener(listenerForGenerateTime);
	}
	public void listenForTrainingMode(ActionListener listenerForTrainingMode) {
		trainingMode.addActionListener(listenerForTrainingMode);
	}
	
	public void listenForVoiceMode(ActionListener listenerForVoiceMode) {
		voiceMode.addActionListener(listenerForVoiceMode);
	}
	
	public void hourPointerForward(ActionListener listenerForHourForward){
		hourForward.addActionListener(listenerForHourForward);
	}
	
	public void hourPointerBackwards(ActionListener listenerForHourBackwards){
		hourBackwards.addActionListener(listenerForHourBackwards);
	}
	
	public void minutesPointerForward(ActionListener listenerForMinutesForward){
		minutesForward.addActionListener(listenerForMinutesForward);
	}
	
	public void minutesPointerBackwards(ActionListener listenerForMinutesBackwards){
		minutesBackwards.addActionListener(listenerForMinutesBackwards);
	}
	
	public void listenWhatTimeIsIt(ActionListener listenerForListenButton){
		listen.addActionListener(listenerForListenButton);
	}
	
	class ClockPanel extends JPanel{
		private int hourPointer, minutePointer;
		public ClockPanel() {
			setPreferredSize(new Dimension(800,800));
			setBackground(Color.LIGHT_GRAY);
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setFont(new Font("TimesRoman", Font.PLAIN, 70));
			g2.setColor(Color.RED);
			g2.drawOval(0,0,800,800);
			for(int i=1;i<=12;i++){
				if(i<4) {
					int R=90;
					g2.drawString(Integer.toString(i), (int)(380+370*Math.cos(Math.toRadians(R-i*30))), (int)(420-370*Math.sin(Math.toRadians(R-i*30))));
				}
				else{
					int R=360;
					g2.drawString(Integer.toString(i), (int)(380+370*Math.cos(Math.toRadians(R-((i-3)*30)))), (int)(420-370*Math.sin(Math.toRadians(R-((i-3)*30)))));
				}
	
			}
			g2.setColor(Color.BLACK);
			g2.fillOval(390,390,20,20);
			
			
			
			g2.setStroke(new BasicStroke(10));
			g2.draw(new Line2D.Double(400, 400, 400+325*Math.sin(Math.toRadians(30*minutePointer)), 400-325*Math.cos(Math.toRadians(30*minutePointer))));
			g2.setColor(Color.GREEN);
			g2.draw(new Line2D.Double(400, 400, 400+200*Math.sin(Math.toRadians(30*hourPointer+2.5*minutePointer)), 400-200*Math.cos(Math.toRadians(30*hourPointer+2.5*minutePointer))));
			
		}
		public void setPointers(ClockModel cm){
			hourPointer = cm.getHour();
			minutePointer = cm.getMinutes();
		}
	}
	
	private class CorrectButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			((JButton) e.getSource()).setBackground(Color.GREEN);
			((JButton) e.getSource()).removeActionListener(this);
			
		}
		
	}
	
	private class IncorrectButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			((JButton) e.getSource()).setBackground(Color.RED);
			((JButton) e.getSource()).removeActionListener(this);
			
		}
		
	}

	
}
