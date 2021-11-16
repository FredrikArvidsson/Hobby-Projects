package LearnTheClock;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ClockController {
	private ClockModel theModel;
	private ClockView theView;
	
	
	public ClockController(ClockModel cm, ClockView cv){
		theModel = cm;
		theView = cv;
		
		//lägger till actions till knapparna i ClockView
		theView.listenForGenerateButton(new GenerateTest());
		theView.hourPointerForward(new HourPointerForward());
		theView.hourPointerBackwards(new HourPointerBackwards());
		
		theView.minutesPointerForward(new MinutesPointerForward());
		theView.minutesPointerBackwards(new MinutesPointerBackwards());
		
		theView.listenWhatTimeIsIt(new ListenWhatTimeIsIt());
		theView.listenForVoiceMode(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				theView.setModeToVoiceMode();
				
			}
		});
		
		theView.listenForTrainingMode(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				theView.setModeToTraining();
				
			}
		});
		
		//theView.listenForTrainingMode(new TrainingMode());
	
	}
	
	//För att visa programmet
	public void show() {
		theView.pack();
		theView.setVisible(true);
	}
	
	///Start Actionlisteners	
	private class HourPointerForward implements ActionListener{
		public void actionPerformed(ActionEvent e){
			theModel.hourForward();
			theView.drawPointers(theModel);
		}
	}
	
	private class HourPointerBackwards implements ActionListener{
		public void actionPerformed(ActionEvent e){
			theModel.hourBackwards();
			theView.drawPointers(theModel);
			
		}
	}
	private class MinutesPointerForward implements ActionListener{
		public void actionPerformed(ActionEvent e){
			theModel.minutesForward();
			theView.drawPointers(theModel);
			
		}
	}
	
	private class MinutesPointerBackwards implements ActionListener{
		public void actionPerformed(ActionEvent e){
			theModel.minutesBackwards();
			theView.drawPointers(theModel);
			
		}
	}
	
	private class ListenWhatTimeIsIt implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//File clockIs = new File("ClockIs.WAV");
			String hour;
			if(theModel.getMinutes() > 4)
				hour = theModel.hourSounds[(theModel.getHour()+1)%12];
			else
				hour = theModel.hourSounds[theModel.getHour()%12];
			
			
			File hourSound = new File(hour);
			File minuteSound = new File(theModel.minuteSounds[theModel.getMinutes()]);
			if(theModel.getMinutes() != 0)
				minuteSound = new File(theModel.minuteSounds[theModel.getMinutes()]);
			//playSound(clockIs);'
			if(theModel.getMinutes()==0)
				playSound(hourSound);
			else {
				playSound(minuteSound);
				playSound(hourSound);
			}
	}
		public void playSound(File sound) {
			try{
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(sound));
				clip.start();
				
				Thread.sleep(clip.getMicrosecondLength()/1000);
			}catch(Exception e){
				
			}
		}
	}	
	/*class TrainingMode implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			theView.setModeToTraining();
			
		}
		
	}*/
	private class GenerateTest implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			theModel.randomTime();
			theView.drawPointers(theModel);
			theView.generateAnswerButtons(theModel);
			
			
		}
		
	}
	
	
	///End Actionlisteners
}