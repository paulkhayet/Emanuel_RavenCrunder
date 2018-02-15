
public abstract class NPC extends Entity{
	
	
	public NPC(String n, String d,
		double str, double m, double sn, double sp) {
		super(n, d, str, m, sn, sp);
	}
	
	public abstract void meet(Player p);
	
	public void say(String s) {
		System.out.println(this.getName() + ": " + s);
	}
}
