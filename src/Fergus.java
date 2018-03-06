/*****************************
 * Represents the NPC Fergus.
 * @author Alec Bertoy
 * @version 3/5/2018
 ****************************/
public class Fergus extends NPC {
	
	public Fergus() {
		super("The Ogre", "The Monstrous Ogre", 2, 1, 1, 0);
	}

	/**
	 * Runs when the player first encounters Fergus.
	 * Leads to escapeTheCabin or hangWithFergus
	 * @param p the player object
	 */
	public void meet(Player p) {
		int option;
		System.out.println("1. Sneak around the ogre and continue on.");
		System.out.println("2. Approach the ogre and attempt to talk to him.");
		option = p.chooseOption(1, 2);

		if (option == 1) {
			if (p.sneakAround(this)) {
				System.out.println("\nYou successfully sneak around the ogre \n" + "and continue down the road.");
			} else {
				this.say("Don't try to sneak around me you tiny crumb of a man!");
				System.out.println("\nYou have been captured by the ogre.");
				System.out.println("He knocks you unconscious and locks you\n" + "in a cell in his cabin in the woods.");
				this.escapeTheCabin(p);
			}
		} else {
			System.out.println("You walk towards the ogre head on and he sees you.");
			this.setName("Fergus");
			this.say("Halt trespasser! This land belongs to I, Fergus the Ogre!");
			
			System.out.println("1. Attempt to sneak past him even though he undoubtedly sees you.");
			System.out.println("2. (Lie)\"Don't you know who I am?!?! I am Emanuel RavenCrunder!\n" +
					"   Ruler of this kingdom and therefore this land!\"");
			System.out.println("3. \"I don't recognize your ownership of this land because you \n" +
					"   have not shown me the proper paperwork proving said ownership of said land.\n" +
					"   If there's one thing I hate more than ogres, its unlawful seizing of land.\n" +
					"   Die!\" (attack)");
			option = p.chooseOption(1, 3);

			if(option == 1) {
				this.say("Come on man I see you. Don't even try to pretend you're good at this.\n" +
						"Stop covering your own eyes. Just because you can't see me doesn't mean\n" +
						"I can't see you! You're like my 5 year old nephew.\"");
				System.out.println("\nFergus hits you with a nearby fallen tree trunk and you are knocked unconscious.");
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
					this.say("If I'm a booger, than you're the upper respiratory viral infectious\n" +
							"disease that led to my existence! AHHHHHHHHHHH!");
					System.out.println("\nDue to Fergus's unexpected sensitivity to being\n" +
							"compared to a booger, he erupts in a fit of rage and screams\n" +
							"so loud you're whole body vibrates and you fall unconscious.");
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

	/**
	 * Runs if the player gets captured by Fergus.
	 * @param p the player object
	 */
	public void escapeTheCabin(Player p) {
		
		int option;

		p.gameBreak();

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
				System.out.println("\nYou notice the table metal legs can be pried off.");
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
			System.out.println("\nYou feel a sense of pride and accomplishment rise through your body,\n" +
				"Cleansing your spirit of any cuts and bruises left behind from years of suffering.\n" +
				"Finally, you are at peace.");
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

	/**
	 * Runs if the player befriends Fergus by lying to him
	 * @param p the player object
	 */
	public void hangWithFergus(Player p) {

		int option;

		p.gameBreak();

		System.out.println("You and Fergus travel to his cabin.\n");
		this.say("I believe this will help you on your top secret mission.");
		Sword sword = new Sword("Steel Sword", "strength has increased", 2);
		sword.use(p);
		System.out.println("\n1. \"Thank you but I must be on my way.\n" +
				"I must get back to my quest.\"");
		System.out.println("2. \"What is this? A pathetic steel sword? You are worthless\n" +
				"to me! Violence is never the answer you behemoth!\"");
		System.out.println("3. \"Aha! now that I have this sword, I can easily defeat you!\n" +
				"Emanuel RavenCrunder isn't even a real name! (attack)");
		
		option = p.chooseOption(1, 3);

		
		if(option == 1) {
			this.say("Before you go, would you please help me? I have lost my pet\n" +
					"goat Steven. He's out there all alone and I can't find him!");
			
			System.out.println("\n1. \"I'm sorry but I cannot stay. The world needs me.");
			System.out.println("2. \"I always help an ogre in distress! Where did you last see him?\"");
			
			option = p.chooseOption(1, 2);

			
			if(option == 1) {
				this.say("I understand. I'm just an old sad lonely ogre left to rot in this forest,\n" +
						"only kept company by my goat Steven. Without him I will truely die inside.\n" +
						"But your mission sounds much more important. Good luck and if you ever have a goat,\n" +
						"never let it go.");
				System.out.println("\nYou uncomfortably shuffle backwards out of his cabin and into the woods.");
			} else {
				this.say("Oh thank you so much! I last saw him out in the woods but I cannot remember where.");
				System.out.println("\nYou walk out into the woods and immediately see the goat. It seems\n" +
						"that Fergus is either visually or mentally impaired otherwise he would have easily found it.");
				System.out.println("\n1. Pick up the goat and bring it to Fergus.");
				System.out.println("2. Stab the goat with your sword and harvest its meat for sustenance.");
				System.out.println("3. Run away.");
				
				option = p.chooseOption(1, 3);

				if(option == 1) {
					System.out.println("You snatch the goat, put it under your arm and march back to Fergus.");
					System.out.println("The moment he sees you his eyes light up. You swear you hear angels singing,\n" +
						"but your skepticism forces you to blame it on the wind.\n");
					this.say("Oh Lord! Steven! I missed you so much!");
					System.out.println("\nFergus grabs hold of Steven and spins him around letting out an endless\n" +
						"stream of childlike laughter.\n");
					this.say("Thank you so much Emanuel! I am eternally indebted to you. If you ever are in trouble\n" +
						"just scream \"Beep Beep Daddy\" and I will be there to assist you. You must be on your way,\n" +
						"you have pressing matters to attend to.");
					System.out.println("\nYou say goodbye to Fergus and continue on the road ahead of you. Feeling a\n" +
						"growth of heart only matched by the Grinch.");
				} else if(option == 2) {
					System.out.println("You attack the goat and cut it into little pieces, each of which you\n" +
						"devour with the same unruly hunger for flesh as the last. \n" +
						"But it's not the same. Nothing is.\n" +
						"No animal will ever match the euphoria you felt when you sunk your teeth into a\n" +
						"delicious McDonald's" + (char)169 + " Big Mac" + (char)169 + ". Now only $3.99! Topped with lettuce,\n" +
						"tomato, pickles and their special Big Mac" + (char)169 + " sauce, you won't regret a single bite.\n" +
						"So head on down to your nearest McDonald's" + (char)169 + " and order up!");

				} else {
					System.out.println("You run away, heart racing, into the wilderness. Not Because you are\n" +
						"scared of goats or anything. You just remembered you left your oven on or something.\n" +
						"You aren't afraid of anything, let alone a stupid, silly, ugly, terrifying goat.");
				}
				
			}
		} else if(option == 2) {
			this.say("How dare you disrespect me? I let you in to my home and bestow\n" +
					"upon you all that I can. I don't care if you're Emanuel RavenCrunder,\n" +
					"you don't deserve my gift or my time!");
			sword.unUse(p);

			this.say("Now leave and never return!");
			System.out.println("\nAs you walk out, you turn back to see Fergus with his hand\n" +
					"in a formation that if this were not just a text-based game,\n" +
					"would have to be blurred out.");
		} else {
			p.fight(this);
			
			System.out.println("\nYou sheath your bloodied sword and exit the cabin,\n" +
					"feeling no remorse because you are a heartless monster with\n" +
					"no shred of compassion left within your hollow soul.");
		}
		
	}
}