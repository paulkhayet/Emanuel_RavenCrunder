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
	
	public double getMagic() { return magic; }
	
	public double getSneak() { return sneak; }
	
	public double getSpeech() { return speech; }
	
	public String toString() {
		return this.getName() + ": " + this.getDescription();
	}
	
	public ArrayList<Item> getItems() { return items; }
}
