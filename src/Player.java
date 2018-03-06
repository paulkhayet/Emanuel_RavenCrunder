import java.util.Scanner;
/***************************************************************
 * Represents tha player. The player is the center of all user
 * control as it collects all input and choices.
 **************************************************************/
public class Player extends Entity {
	
	private Scanner input;

	public Player(String n, String d) {
		super(n, d, 0,0, 0);
		input = new Scanner(System.in);
	}

	public String toString() {
		return "\n" + this.getName() + ":" + 
				"\nStrength: " + this.getStrength() +
				"\nSneak: " + this.getSneak() + 
				"\nSpeech: " + this.getSpeech();
	}

	/**
	 * Gives the user a break in the game before they go
	 * to the next section.
	 */
	public void gameBreak() {
		System.out.print("\nEnter any key to continue...");
		input.nextLine();
		this.clear();
	}

	/**
	 * Collects the user's choice and makes sure it's
	 * within the parameters
	 * @param min minimum choice value
	 * @param max maximum choice value
	 * @return returns the user's choice
	 */
	public int chooseOption(int min, int max) {
		int n;
		while(true) {
			System.out.print("Choice: ");
			n = input.nextInt();
			input.nextLine();
			
			if(n < min || n > max) {
				System.out.println("\nNot an option");
			} else {
				this.clear();
				return n;
			}
		}
	}

	/**
	 * Prompts the user yes or no
	 * @return returns the user's choice as a boolean
	 */
	public boolean chooseYesOrNo() {
		System.out.println("1. Yes");
		System.out.println("2. No");
		
		int n = chooseOption(1, 2);
		return n == 1;
	}

	/**
	 * Compares the player's strength to an NPC's
	 * and decides who wins
	 * @param npc the NPC the player is fighting
	 * @return returns true if the player won
	 */
	public boolean fight(NPC npc) {
		if(this.getStrength() >= npc.getStrength()) {
			System.out.println("\nYou have defeated " + npc.getName() + "!");
			
			if(npc.hasDropItem())
				npc.getDrop().use(this);
			
			return true;
		} else {
			System.out.println("\nYou have been defeated by " + npc.getName() + "!");
			return false;
		}
	}

	/**
	 * Compares player's speech to an NPC's
	 * @param npc the NPC the player is convincing
	 * @return returns true if the NPC is convinced
	 */
	public boolean convince(NPC npc) {
		return this.getSpeech() >= npc.getSpeech();
	}

	/**
	 * Compares player's sneak to an NPC's
	 * @param npc the NPC the player is sneaking around
	 * @return returns true if the player successfully sneaks
	 */
	public boolean sneakAround(NPC npc) {
		return this.getSneak() >= npc.getSneak();
	}
}
