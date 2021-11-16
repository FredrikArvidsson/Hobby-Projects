package LearnTheClock;
/**
 * 
 * @author Fredrik Arvidsson
 * 
 *
 */
public class ClockModel {
	private int hour=0;
	private int minutes=0;
	//Tiden räknas från 0-11 där 0 = 12, Dels för att arrayer börjar på index 0 och för att förenkla läsning av kod. Om klockan är 1 använder
	//den ljuden på index 1 i arrayen osv, förrutom om klockan är 12 då e det index 0.
	
	//Array av filnamn till ljuden som används för att beskriva var minutvisaren befinner sig. Index 0 används aldrig då vi aldrig
	//säger något framför timmen om klockan är hel timme.
	public final String[] minuteSounds  = {"FILLER","fivepast.wav", "tenpast.wav","quarterpast.wav", "twentypast.wav", "twentyfivepast.wav",
											"halfpast.wav", "twentyfiveto.wav", "twentyto.wav", "quarterto.wav", "tento.wav", "fiveto.wav"};
	
	////Array av filnamn till ljuden som används för att beskriva var timvisaren befinner sig	
	public final String[] hourSounds = {"twelve.wav", "one.wav", "two.wav", "three.wav", "four.wav", "five.wav", "six.wav", "seven.wav",
								"eight.wav", "nine.wav", "ten.wav", "eleven.wav"};
	
	public int getHour() {
		return hour;
	}
	public int getMinutes() {
		return minutes;
	}
	
	
	/**
	 * Genererar och sätter en random tid
	 */
	public void randomTime() {
		hour = (int)(Math.random()*11);
		minutes = (int)(Math.random()*11);
		
	}
	
	public void hourForward(){
		if(hour==11)
			hour = 0;
		else
			hour += 1;
	}
	public void hourBackwards() {
		if(hour==0)
			hour = 11;
		else
			hour -= 1;
	}
	public void minutesForward() {
		if(minutes==11) {
			minutes=0;
			hour += 1;
		}
		else
			minutes += 1;
		
	}
	public void minutesBackwards() {
		if(minutes==0){
			minutes =11;
			hour -= 1;
		}
		else
			minutes -= 1;
	}
	
	public void resetMinutes() {
		minutes = 0;
	}
}
