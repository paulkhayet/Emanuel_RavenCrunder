import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entity {
	
	private Scanner input;
	
	public Player(String n, String d) {
		super(n, d, 0, 0, 0, 0);
		input = new Scanner(System.in);
	}
	
	public String toString() {
		return "\n" + this.getName() + ":" + 
				"\nStrength: " + this.getStrength() +
				"\nMagic: " + this.getMagic() +
				"\nSneak: " + this.getSneak() + 
				"\nSpeech: " + this.getSpeech();
	}
	
	public String acceptString() {
		return input.nextLine();
	}
	
	public int chooseOption(int min, int max) {
		int n;
		while(true) {
			System.out.print("Choice: ");
			n = input.nextInt();
			input.nextLine();
			
			if(n < min || n > max) {
				System.out.println("/nNot an option");
			} else {
				return n;
			}
		}
	}
	
	public boolean fight(NPC npc) {
		if(this.getStrength() >= npc.getStrength()) {
			System.out.println("\nYou have defeated " + npc.getName() + "!");
			npc.getDrop().use(this);
			return true;
		} else {
			System.out.println("\nYou have been defeated by " + npc.getName() + "!");
			return false;
		}
	}
	
	public boolean convince(NPC npc) {
		return this.getSpeech() >= npc.getSpeech();
	}
	
	public boolean sneakAround(NPC npc) {
		return this.getSneak() >= npc.getSneak();
	}
}
