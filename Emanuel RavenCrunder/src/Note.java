
public class Note extends Item{
	
	public Note(String n, String d) {
		super(n, d);
	}
	
	public void use() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		return this.getName() + ":\n" + this.getDescription();
	}
}
