/*********************************************************************
 * Represents a NamedThing that is sentient. Falls into 2 categories,
 * players and non-player characters(NPC's)
 * @author Alec Bertoy
 * @version 3/5/2018
 ********************************************************************/
public abstract class Entity extends NamedThing {

	private double strength, sneak, speech;
	
	
	public Entity(String n, String d, double str, double sn, double sp) {
		super(n, d);
		strength = str;
		sneak = sn;
		speech = sp;
	}
	
	public double getStrength() { return strength; }
	
	public void addStrength(double str) {
		strength += str;
	}
	
	public double getSneak() { return sneak; }
	
	public double getSpeech() { return speech; }
	
	public String toString() {
		return this.getName() + ": " + this.getDescription();
	}
}
