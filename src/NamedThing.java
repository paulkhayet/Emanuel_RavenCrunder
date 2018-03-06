/*********************************************************
 * Represents anything with a name. Includes all objects.
 * @author Alec Bertoy
 * @version 3/5/2018
 ********************************************************/
public abstract class NamedThing {
	private String name;
	private String description;
	
	public NamedThing(String n, String d) {
		name = n;
		description = d;
	}
	
	public String getName() { return name; }
	
	public String getDescription() { return description; }
	
	public abstract String toString();
	
	public void setName(String n) { name = n; }

	/**
	 * Clears the terminal.
	 * Accessible to all NamedThings so you can use it anywhere.
	 */
	public void clear() {
		for(int i = 0; i < 100; i++) {
			System.out.println("\n");
		}
	}
}
