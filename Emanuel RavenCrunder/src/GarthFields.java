
public class GarthFields extends NPC{
	public GarthFields() {
		super("Man", "Average Joe", 3, 3, 3, 3);
	}
	
	public void meet(Player p) {
		System.out.println();
		this.say("Greetings traveler, what are you doing around these lands");
		
		System.out.println("1. \"Who are you?\"");
		System.out.println("2. \"Die\" (attack)");
		
		int n = p.chooseOption(1, 2);
		if(n == 1) {
			((Entity)this).setName("Girth Fields");
			this.say("My name is Girth Fields, I'm an traveler");
		} else {
			this.say("Prepare to die");
			p.fight(this);
		}
	}
}
