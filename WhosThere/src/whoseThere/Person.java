package whoseThere;

public class Person {
	
	
	private final String name;
	private final boolean hasBeard, hasMoustache, isShowingTeeth, hasBigNose;
	private final boolean hasGlasses;
	private final boolean hasBlueEyes, hasBrownEyes;
	private final boolean hasOrangeHair, hasBlackHair, hasBlondeHair, hasBrownHair, hasWhiteHair;
	private final boolean hasLongHair, hasShortHair, isBold;
	private final boolean hasDarkSkincolor;
	private final boolean hasPiercing;
	private final boolean isMale, isFemale;
	private final boolean hasHat;
	
		
	
	
	
	private Person(Builder builder) {
		this.name = builder.name;
		this.hasBeard = builder.hasBeard;
		this.hasMoustache = builder.hasMoustache;
		this.isShowingTeeth = builder.isShowingTeeth;
		this.hasBigNose = builder.hasBigNose;
		this.hasGlasses = builder.hasGlasses;
		this.hasBlueEyes = builder.hasBlueEyes;
		this.hasBrownEyes = builder.hasBrownEyes;
		this.hasOrangeHair = builder.hasOrangeHair;
		this.hasBlackHair = builder.hasBlackHair;
		this.hasBlondeHair = builder.hasBlondeHair;
		this.hasBrownHair = builder.hasBrownHair;
		this.hasWhiteHair = builder.hasWhiteHair;
		this.hasLongHair = builder.hasLongHair;
		this.hasShortHair = builder.hasShortHair;
		this.isBold = builder.isBold;
		this.hasDarkSkincolor = builder.hasDarkSkincolor;
		this.hasPiercing = builder.hasPiercing;
		this.isMale = builder.isMale;
		this.isFemale = builder.isFemale;
		this.hasHat = builder.hasHat;
		
	}


	public boolean hasBeard() {
		return hasBeard;
	}


	public boolean hasMoustache() {
		return hasMoustache;
	}


	public boolean isShowingTeeth() {
		return isShowingTeeth;
	}


	public boolean hasBigNose() {
		return hasBigNose;
	}


	public boolean hasGlasses() {
		return hasGlasses;
	}


	public boolean hasBlueEyes() {
		return hasBlueEyes;
	}


	public boolean hasOrangeHair() {
		return hasOrangeHair;
	}


	public boolean hasBlackHair() {
		return hasBlackHair;
	}


	public boolean hasBlondeHair() {
		return hasBlondeHair;
	}


	public boolean hasLongHair() {
		return hasLongHair;
	}


	public boolean hasDarkSkincolor() {
		return hasDarkSkincolor;
	}


	public boolean hasPiercing() {
		return hasPiercing;
	}


	public boolean isMale() {
		return isMale;
	}


	public boolean hasHat() {
		return hasHat;
	}
	
	
	public boolean hasShortHair() {
		return hasShortHair;
	}


	public boolean isBold() {
		return isBold;
	}
	
	public String getName() {
		return name;
	}


	public boolean hasBrownHair() {
		return hasBrownHair;
	}


	public boolean hasBrownEyes() {
		return hasBrownEyes;
	}


	public boolean hasWhiteHair() {
		return hasWhiteHair;
	}


	public boolean isFemale() {
		return isFemale;
	}
	
	public String toString() {
		return "[" + name + "]" + (isMale ? "[Male]":"[Female]") + (hasBlueEyes ? "[Blue Eyes]":"[Brown Eyes]") + (hasOrangeHair ? "[Orange Hair]":hasBlackHair ? "[Black Hair]":hasBlondeHair ? "[Blonde Hair]":hasBrownHair ? "[Brown Hair]":"[White Hair]") + (hasLongHair ? "[Long Hair]":hasShortHair ? "[Short Hair]":"[Bold]") + " | Hat?[" + hasHat + "] | Piercing?[" + hasPiercing + "] | Showing Teeth?[" + isShowingTeeth + "] | Big Nose?[" + hasBigNose + "] | Glasses?[" + hasGlasses + "] | Beard?[" + hasBeard + "] | Moustache?[" + hasMoustache + "]";
	}


	
	
	
	
public static class Builder{
		
		//Constructor parameter
		private final String name;
		
		//optional parameters set to default
		private boolean hasBeard, hasMoustache, isShowingTeeth, hasBigNose = false;
		private boolean hasGlasses = false;
		private boolean hasBlueEyes, hasBrownEyes = false;
		private boolean hasOrangeHair, hasBlackHair, hasBlondeHair, hasBrownHair, hasWhiteHair = false;
		private boolean hasLongHair, hasShortHair, isBold = false;
		private boolean hasDarkSkincolor = false;
		private boolean hasPiercing = false;
		private boolean isMale, isFemale = false;
		private boolean hasHat = false;
		
		public Builder(String name) {
			this.name = name;
		}
		
		public Builder hasBeard(boolean hasBeard) {
			this.hasBeard = hasBeard;
			return this;
		}
		
		
		public Builder hasMoustache(boolean hasMoustache) {
			this.hasMoustache = hasMoustache;
			return this;
		}
		
		public Builder isShowingTeeth(boolean isShowingTeeth) {
			this.isShowingTeeth = isShowingTeeth;
			return this;
		}
		
		public Builder hasBigNose(boolean hasBigNose) {
			this.hasBigNose = hasBigNose;
			return this;
		}
		
		public Builder hasGlasses(boolean hasGlasses) {
			this.hasGlasses = hasGlasses;
			return this;
		}
		
		public Builder hasBlueEyes(boolean hasBlueEyes) {
			this.hasBlueEyes = hasBlueEyes;
			return this;
		}
		
		public Builder hasOrangeHair(boolean hasOrangeHair) {
			this.hasOrangeHair = hasOrangeHair;
			return this;
		}
		
		public Builder hasBlackHair(boolean hasBlackHair) {
			this.hasBlackHair = hasBlackHair;
			return this;
		}
		
		public Builder hasBlondeHair(boolean hasBlondeHair) {
			this.hasBlondeHair = hasBlondeHair;
			return this;
		}
		
		public Builder hasBrownHair(boolean hasBrownHair) {
			this.hasBrownHair = hasBrownHair;
			return this;
		}
		
		public Builder hasWhiteHair(boolean hasWhiteHair) {
			this.hasWhiteHair = hasWhiteHair;
			return this;
		}
		
		
		public Builder hasLongHair(boolean hasLongHair) {
			this.hasLongHair = hasLongHair;
			return this;
		}
		
		public Builder hasShortHair(boolean hasShortHair) {
			this.hasShortHair = hasShortHair;
			return this;
		}
		
		public Builder isBold(boolean isBold) {
			this.isBold = isBold;
			return this;
		}
		
		public Builder hasDarkSkincolor(boolean hasDarkSkincolor) {
			this.hasDarkSkincolor = hasDarkSkincolor;
			return this;
		}
		
		public Builder hasPiercing(boolean hasPiercing) {
			this.hasPiercing = hasPiercing;
			return this;
		}
		
		public Builder isMale(boolean isMale) {
			this.isMale = isMale;
			return this;
		}
		
		public Builder isFemale(boolean isFemale) {
			this.isFemale = isFemale;
			return this;
		}
		
		public Builder hasHat(boolean hasHat) {
			this.hasHat = hasHat;
			return this;
		}
		
		public Builder hasBrownEyes(boolean hasBrownEyes) {
			this.hasBrownEyes = hasBrownEyes;
			return this;
		}
		
				
		public Person build() {
			return new Person(this);
		}

		

		
		
		
	}
	
	
	
	
	
	
	
}
