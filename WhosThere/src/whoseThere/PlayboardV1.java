package whoseThere;



public class PlayboardV1 extends Playboard {
public static void main(String[] args) {
	PlayboardV1 v = new PlayboardV1();
	v.buildPlayboard();
	for(Person p:v.getPersonsOnPlayboard()) {
		System.out.println(p);
	}
}
	
	
	public PlayboardV1() {
		super();
	}

	@Override
	public void buildPlayboard() {
		Person p = new Person.Builder("Katrin").isMale(false).isFemale(true).hasHat(true).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(false)
				.hasBrownEyes(true)
				.hasOrangeHair(false)
				.hasBlackHair(false)
				.hasBlondeHair(false)
				.hasBrownHair(true).hasWhiteHair(false).hasLongHair(true).hasShortHair(false).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Paul").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(true).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(true).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Charles").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(true).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(true).hasBrownEyes(false).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(true).hasWhiteHair(false).hasLongHair(false).hasShortHair(false).isBold(true).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Maria").isMale(false).isFemale(true).hasHat(true).hasPiercing(true)
				.isShowingTeeth(true).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(true).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(true).hasShortHair(false).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Hans").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(true).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(true)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(true)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Peter").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(true).hasGlasses(false).hasBeard(false).hasMoustache(true)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(true).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Anne").isMale(false).isFemale(true).hasHat(false).hasPiercing(true)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(true).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(true).hasBrownEyes(false).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(true).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Joe").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(true).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(true).hasBrownEyes(false).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(true)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Daniel").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(true).hasGlasses(true).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(true).hasLongHair(false).hasShortHair(false).isBold(true).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Sophie").isMale(false).isFemale(true).hasHat(false).hasPiercing(true)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(true).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(true).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(true).hasShortHair(false).isBold(false).hasDarkSkincolor(true)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Michael").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(true)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(true).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Sarah").isMale(false).isFemale(true).hasHat(false).hasPiercing(true)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(true).hasBrownEyes(false).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(true)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Victor").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(true).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Eric").isMale(true).isFemale(false).hasHat(true).hasPiercing(false)
				.isShowingTeeth(true).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(true)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Lucas").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(true).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(true)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Thomas").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(true)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(true).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(true)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Frank").isMale(true).isFemale(false).hasHat(true).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(true).hasGlasses(false).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(true).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Bernard").isMale(true).isFemale(false).hasHat(true).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(true).hasGlasses(false).hasBeard(false).hasMoustache(true)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(true).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(true)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Max").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(true).hasBigNose(false).hasGlasses(false).hasBeard(true).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(true).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(true)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Roger").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(true).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(true).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(false).isBold(true).hasDarkSkincolor(true)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Philippe").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(true).hasMoustache(true)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(true).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(false).isBold(true).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Herman").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(false).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(true).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(false).isBold(true).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Stephen").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(false).hasBigNose(false).hasGlasses(true).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(true).hasBrownEyes(false).hasOrangeHair(true).hasBlackHair(false).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		p = new Person.Builder("Theo").isMale(true).isFemale(false).hasHat(false).hasPiercing(false)
				.isShowingTeeth(true).hasBigNose(true).hasGlasses(false).hasBeard(false).hasMoustache(false)
				.hasBlueEyes(false).hasBrownEyes(true).hasOrangeHair(false).hasBlackHair(true).hasBlondeHair(false)
				.hasBrownHair(false).hasWhiteHair(false).hasLongHair(false).hasShortHair(true).isBold(false).hasDarkSkincolor(false)
				.build();
		personsOnPlayboard.add(p);
		
		
		
	}	
	
	

}
