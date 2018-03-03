
public class Fergus extends NPC {
	public Fergus() {
		super("Fergus", "The Monstrous Ogre", 3, 1, 0, 0);
	}
	
	public void meet(Player p) {
		int option;
		
		option = p.chooseOption(1, 2);
		System.out.println("1. Sneak around the ogre and continue on.");
		System.out.println("2. Approach the ogre and attempt to talk to him.");
		
		if(option == 1) {
			
		} else {
			if(p.sneakAround(this)) {
				System.out.println("\nYou successfully sneak around the ogre \n" +
						"and continue down the road.");
			} else {
				this.say("Don't try to sneak around me tiny crumb boy!");
				System.out.println("You have been captured by the ogre.");
				System.out.println("He knocks you unconsious and locks you\n" +
						"in a cell in his cabin in the woods.");
				this.escapeTheCabin(p);
			}
		}
	}
	
	private void escapeTheCabin(Player p) {
		System.out.println("\nYou awake in a damp, cold cell.");
		System.out.println("You see a bedroll, a table and a painting.");
		
		System.out.println("1. Look in the bedroll.");
		System.out.println("2. Examine the table.");
		System.out.println("3. ");
	}
}
