import java.util.ArrayList;
public abstract class Entity extends NamedThing {
	
	private ArrayList<Item> items;
	private double strength, magic, sneak, speech;
	
	
	public Entity(String n, String d, double str, double m, double sn, double sp) {
		super(n, d);
		strength = str;
		magic = m;
		sneak = sn;
		speech = sp;
		items = new ArrayList<Item>();
	}
	public Entity(String n, String d, double str, double m, double sn, double sp, ArrayList<Item> i) {
		super(n, d);
		strength = str;
		magic = m;
		sneak = sn;
		speech = sp;
		items = i;
	}
	
	public double getStrength() { return strength; }
	
	public void addStrength(double str) {
		strength += str;
	}
	
	public double getMagic() { return magic; }
	
	public void addMagic(double m) {
		magic += m;
	}
	
	public double getSneak() { return sneak; }
	
	public void addSneak(double sn) {
		sneak += sn;
	}
	
	public double getSpeech() { return speech; }
	
	public void addSpeech(double sp) {
		speech += sp;
	}
	
	public String toString() {
		return this.getName() + ": " + this.getDescription();
	}
	
	public ArrayList<Item> getItems() { return items; }
}
