
public class Note extends Item{
	
	public Note(String n, String d) {
		super(n, d);
	}
	
	public void use(Player p) {
		System.out.println(this.toString());
	}
	
	public String toString() {
		return "\nYou have received a note!\n\n" + 
		this.getName() + ":\n" + this.getDescription();
	}
}
