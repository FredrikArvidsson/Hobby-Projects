package LearnTheClock;

public class LearnTheClockMain {
	
	
	//Startar programmet
	public static void main(String[] cmdln) {
		ClockModel model = new ClockModel();
		ClockView view = new ClockView();
		ClockController c = new ClockController(model, view);
		c.show();
	}
}
