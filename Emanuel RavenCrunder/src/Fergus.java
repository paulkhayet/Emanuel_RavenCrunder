
public class Fergus extends NPC {
	
	public Fergus() {
		super("The Ogre", "The Monstrous Ogre", 3, 1, 10, 0);
		this.setItem(new Egg());
	}

	public void meet(Player p) {
		int option;

		System.out.println("1. Sneak around the ogre and continue on.");
		System.out.println("2. Approach the ogre and attempt to talk to him.");
		option = p.chooseOption(1, 2);
		System.out.println();
		if (option == 1) {
			if (p.sneakAround(this)) {
				System.out.println("\nYou successfully sneak around the ogre \n" + "and continue down the road.");
			} else {
				this.say("Don't try to sneak around me you tiny crumb of a man!");
				System.out.println("\nYou have been captured by the ogre.");
				System.out.println("He knocks you unconsious and locks you\n" + "in a cell in his cabin in the woods.");
				this.escapeTheCabin(p);
			}
		} else {
			
		}
	}

	public void escapeTheCabin(Player p) {
		
		int option;
		
		System.out.println("\nYou awake in a damp, cold cell.");
		System.out.println("You see a bedroll, a table, a painting and a lock.");
		
		
		boolean hasRod = false, hasBrick = false;
		while (true) {
			System.out.println("1. Look in the bedroll.");
			System.out.println("2. Examine the table.");
			System.out.println("3. Move the painting");
			System.out.println("4. Examine the lock.");
			
			option = p.chooseOption(1, 4);
			if(option == 1) {
				System.out.println("\nYou discover thousands of bedbugs in the bedroll.");
				System.out.println("Disgusting.");
			} else if(option == 2) {
				System.out.println("\nYou notice the table metal legs can be pryed off.");
				System.out.println("Do you want to pry the leg off?");
				if(p.chooseYesOrNo()) {
					hasRod = true;
				}
			} else if(option == 3){
				System.out.println("\nBehind the painting is a loose brick.");
				System.out.println("Do you want to take the brick?");
				if(p.chooseYesOrNo()) {
					hasBrick = true;
				}
			} else {
				if(hasBrick && hasRod) {
					System.out.println("\nDo you want to break the lock with the brick?");
					if(p.chooseYesOrNo()) {
						break;
					}
					System.out.println("\nDo you want to pry open the door with the table leg?");
					if(p.chooseYesOrNo()) {
						break;
					}
				}
				else if(hasBrick) {
					System.out.println("\nDo you want to break the lock with the brick?");
					if(p.chooseYesOrNo()) {
						break;
					}
				} else if(hasRod) {
					System.out.println("\nDo you want to pry open the door with the table leg?");
					if(p.chooseYesOrNo()) {
						break;
					}
				} else {
					System.out.println("You can't do anything to the lock with your bare hands.");
				}
			}
			System.out.println();
		}
		
		System.out.println("\nYou are now outside of the cell but still inside " 
				+ this.getName() + "'s cabin.");
		System.out.println("You see " + this.getName() + " sleeping, an egg on a table, " +
				"and the exit door.");
		
		System.out.println("1. Kill " + this.getName() + " in his sleep.");
		System.out.println("2. Take the egg.");
		System.out.println("3. Leave through the door.");
		option = p.chooseOption(1, 3);
		
		if(option == 1) {
			System.out.println("\nAs " + this.getName() + " lets out his last breath,");
			System.out.println("he opens his eye to get one last view at the world he is leaving.\n" +
					"He sheds a tear, and lets out a final word...\n\n");
			this.say("...d...dd....ddd..");
			System.out.println("\n");
			this.say("DONKEY!");
			System.out.println("\nYou exit his cabin, broken and ashamed.");
		} else if(option == 2){
			System.out.println("\nYou pick up the egg and put it carefully in your\n" +
					"totally-manly-and-definitely-not-a-purse satchel and walk out\n" +
					"into the cold, expanse of wilderness.");
			this.getDrop().use(p);
		} else {
			System.out.println("\nAs you exit his cabin, you feel a strange feeling\n" +
					"that urges you to stay with " + this.getName() + " forever.");
			System.out.println("He doesn't seem so bad anymore.");
			System.out.println("Maybe you've misunderstood him.");
			System.out.println("Maybe he's just trying to get by just like you.");
			System.out.println("Maybe he needs someone like you to change his path.");
			System.out.println("\nBut it's probably just Stockholm Syndrome " + 
					"so you get the hell outta there.");
			
		}
	}
}