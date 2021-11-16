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
	//Tiden r�knas fr�n 0-11 d�r 0 = 12, Dels f�r att arrayer b�rjar p� index 0 och f�r att f�renkla l�sning av kod. Om klockan �r 1 anv�nder
	//den ljuden p� index 1 i arrayen osv, f�rrutom om klockan �r 12 d� e det index 0.
	
	//Array av filnamn till ljuden som anv�nds f�r att beskriva var minutvisaren befinner sig. Index 0 anv�nds aldrig d� vi aldrig
	//s�ger n�got framf�r timmen om klockan �r hel timme.
	public final String[] minuteSounds  = {"FILLER","fivepast.wav", "tenpast.wav","quarterpast.wav", "twentypast.wav", "twentyfivepast.wav",
											"halfpast.wav", "twentyfiveto.wav", "twentyto.wav", "quarterto.wav", "tento.wav", "fiveto.wav"};
	
	////Array av filnamn till ljuden som anv�nds f�r att beskriva var timvisaren befinner sig	
	public final String[] hourSounds = {"twelve.wav", "one.wav", "two.wav", "three.wav", "four.wav", "five.wav", "six.wav", "seven.wav",
								"eight.wav", "nine.wav", "ten.wav", "eleven.wav"};
	
	public int getHour() {
		return hour;
	}
	public int getMinutes() {
		return minutes;
	}
	
	
	/**
	 * Genererar och s�tter en random tid
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
