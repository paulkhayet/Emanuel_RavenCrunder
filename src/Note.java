/*************************************************************
 * Represents a note that is printed to the player when used.
 * @author Alec Bertoy
 * @version 3/5/2018
 ************************************************************/
public class Note extends Item{
	
	public Note(String n, String d) {
		super(n, d);
	}

	/**
	 * Prints the note.
	 * @param p only passed because Note is an Item and the use function
	 *          calls for a Player object
	 */
	public void use(Player p) {
		System.out.println(this.toString());
	}
	
	public String toString() {
		return "\nYou have received a note!\n\n" + 
		this.getName() + ":\n" + this.getDescription();
	}
}
