
public abstract class Item extends NamedThing{
	
	public Item(String n, String d) {
		super(n, d);
	}
	
	public abstract void use(Player p);
}
