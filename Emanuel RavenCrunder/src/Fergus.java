
public class Fergus extends NPC {
	
	public Fergus() {
		super("The Ogre", "The Monstrous Ogre", 3, 1, 10, 0);
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
			System.out.println("You walk towards the ogre head on and he sees you.");
			this.setName("Fergus");
			this.say("Halt trespasser! This land belongs to I, Fergus the Ogre!");
			
			System.out.println("1. Attempt to sneak past him even though he undoubtably sees you.");
			System.out.println("2. (Lie)\"Don't you know who I am?!?! I am Emanuel RavenCrunder!\n" +
					"   Ruler of this kingdom and therefore this land!\"");
			System.out.println("3. \"I don't recognize your ownership of this land because you \n" +
					"   have not shown me the proper paperwork proving said ownership of said land.\n" +
					"   If there's one thing I hate more than ogres, its unlawful seizing of land.\n" +
					"   Die!\" (attack)");
			option = p.chooseOption(1, 3);
			System.out.println();
			if(option == 1) {
				this.say("Come on man I see you. Don't even try to pretend you're good at this.\n" +
						"Stop covering your own eyes. Just because you can't see me doesn't mean\n" +
						"I can't see you! You're like my 5 year old nephew.\"");
				System.out.println("\nFergus hits you with a nearby fallen tree trunk and you are knocked unconsious.");
				this.escapeTheCabin(p);
			} else if(option == 2) {
				this.say("Hmmm, that name does sound familiar...");
				this.say("But how come you aren't wearing any royal clothing?");
				this.say("You are dressed like a lowly commoner.");
				
				System.out.println("1. \"Casual friday?\"");
				System.out.println("2. \"I am undercover on a top secret mission the nature of\n" +
						"which you cannot know.\"");
				System.out.println("3. \"At least I don't look like a sentient booger!\" (attack)");
				option = p.chooseOption(1, 3);
				System.out.println();
				
				if(option == 1) {
					this.say("I don't know how to use a calender, but I'm going to assume\n" +
							"it isn't actually Friday. That makes you a liar. Just like that\n" +
							"no good life-wrecking devil of a woman Rhonda! Why? Why did you\n" +
							"have to go and throw all we had away? All I wanted was a lifelong\n" +
							"partner. All you wanted someone to puppeteer. You used me!\n" +
							"You witch! You evil dirty rotten...");
					System.out.println("\nWhile Fergus has a mental breakdown, you are able\n" +
							"to sneak right past him. He is blinded by the pure seething hatred\n" +
							"he feels for that alleged \'devil of a woman\'. You can't help\n" + 
							"but feel a little sorry for him, especially since it actually is Friday.");
				} else if(option == 2) {
					this.say("Oh wow you sound serious. You don't seem at all like\n" +
							"you are using a made up name and a made up story to\n" +
							"avoid a conflict. Let me invite you to my cabin in the woods.\n" +
							"I want nothing more than to help you on your extremely\n" +
							"legitimate and immensely important secret mission.");
					System.out.println("\nFergus's erie switch of tone makes it impossible\n" +
							"for you to decline his offer. You travel with him to his house.");
					this.hangWithFergus(p);
				} else {
					this.say("If I'm a booger, than you're the upper respiratory viral infectuous\n" +
							"disease that led to my existence! AHHHHHHHHHHH!");
					System.out.println("\nDue to Fergus's unexpected sensitivity to being\n" +
							"compared to a booger, he erupts in a fit of rage and screams\n" +
							"so loud you're whole body vibrates and you fall unconsious.");
					this.escapeTheCabin(p);
				}
			} else {
				System.out.println("Fergus easily knocks you to the ground. I mean,\n" +
						"he's an ogre. What were you thinking?\n");
				this.say("HAHA! You fool! I've been carrying the paperwork this entire time!\n" +
						"Just because I'm an ogre you expect me to not follow the law?\n" +
						"Bullfiddle!");
				System.out.println("\nOvercome with shock at the poor font choice on his\n" +
						"legal documents, you faint.");
				this.escapeTheCabin(p);
			}
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
			p.getEgg();
		} else {
			System.out.println("\nAs you exit his cabin, you feel a strange feeling\n" +
					"that urges you to stay with " + this.getName() + " forever.");
			System.out.println("He doesn't seem so bad anymore.");
			System.out.println("Maybe you've misunderstood him.");
			System.out.println("Maybe he's just trying to get by just like you.");
			System.out.println("Maybe he needs someone like you to change his path.");
			System.out.println("\nBut it's probably just Stockholm Syndrome " + 
					"so you get the hell outta there and never look back.");
			
		}
	}
	
	public void hangWithFergus(Player p) {
		
	}
}