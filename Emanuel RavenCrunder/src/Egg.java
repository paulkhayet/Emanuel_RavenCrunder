
public class Egg extends Item{
	public Egg() {
		super("Egg", "a small round egg");
	}
	
	public void use(Player p) {
		p.getEgg();
	}
	
	public String toString() {
		return this.getName() + ": " + this.getDescription();
	}
}
