/***********************************
 * Represents the NPC Garth Fields.
 * @author Alec Bertoy
 * @version 3/5/2018
 **********************************/
public class GarthFields extends NPC{
	public GarthFields() {
		super("Mystery Man", "Average Joe", 0, 0, 0, 0);
		setItem(new Note("To Grandma", 
				"You will find this note attached to a gift basket.\n"+
				"I hope it makes you feel better since I cannot attend\n" +
				"your Birthday Party. It's too bad that I'm your only\n" +
				"living relative. I promise to be home for Chirstmas.\n" +
				"Love,\nGarth Fields"));
	}

	/**
	 * Runs when the player meets Garth Fields
	 * @param p the player object
	 */
	public void meet(Player p) {

		this.say("Greetings traveler");
		
		System.out.println("1. \"Who are you?\"");
		System.out.println("2. \"I don't like your tone...\" (attack)");
		
		int n = p.chooseOption(1, 2);

		if(n == 1) {
			this.setName("Garth Fields");
			this.say("My name is Garth Fields, I'm a traveler");
			
			System.out.println("1. \"Goodbye\"");
			System.out.println("2. \"That's a nice note you got, you don't need it do you?\" (speech)");
			System.out.println("3. \"That's a ripoff of the famous comic strip!\" (attack)");
			n = p.chooseOption(1, 3);

			if(n == 1) {
				this.say("Farewell!");
				return;
			} else if (n == 2) {
				if(p.convince(this)) {
					this.say("Now that you mention it, I don't really need it...");
					this.say("Here");
					this.getDrop().use(p);
					this.say("Farewell!");
					return;
				} else {
					System.out.println("Don't try to pull anything on me!\n" + 
							"Get out of my sight!");
					return;
				}
			}
			
		}
		//Runs if the player challenges Garth Fields at any time
		this.say("Prepare to die");
		p.fight(this);
	}
}
