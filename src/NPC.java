/************************************************************
 * Represents a non-player character. The meet function runs
 * to start the storyline associated with that character.
 * All story is contained in NPC's
 * @author Alec Bertoy
 * @version 3/5/2018
 ************************************************************/
public abstract class NPC extends Entity{
	
	private Item dropItem;
	
	public NPC(String n, String d,
		double str, double m, double sn, double sp) {
		super(n, d, str, sn, sp);
		dropItem = null;
	}
	
	public abstract void meet(Player p);
	
	public Item getDrop() {
		return dropItem;
	}
	
	public boolean hasDropItem() {
		return dropItem != null;
	}
	
	public void setItem(Item i) {
		dropItem = i;
	}
	
	public void say(String s) {
		System.out.println(this.getName() + ": \"" + s + "\"");
	}
}
