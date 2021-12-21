package whoseThere;

import java.util.ArrayList;

public abstract class Playboard {
	protected ArrayList<Person> personsOnPlayboard;
	
	public ArrayList<Person> getPersonsOnPlayboard(){
		return personsOnPlayboard;
	}
	
	public abstract void buildPlayboard();
	
	public Playboard() {
		personsOnPlayboard = new ArrayList<Person>();
	}
	
}
