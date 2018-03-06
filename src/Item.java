/***************************************
 * Represents an item that can be used.
 * @author Alec Bertoy
 * @version 3/5/2018
 **************************************/
public abstract class Item extends NamedThing{
	
	public Item(String n, String d) {
		super(n, d);
	}

	/**
	 * Runs when an item is used.
	 * @param p the player object is passed so items can alter the player
	 */
	public abstract void use(Player p);

	public String toString() {
		return this.getName() + ": " + this.getDescription();
	}
}
