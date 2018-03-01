
public class GarthFields extends NPC{
	public GarthFields() {
		super("Man", "Average Joe", 0, 0, 0, 0);
		setItem(new Note("To Grandma", 
				"You will find this note attached to a gift basket.\n"+
				"I hope it makes you feel better since I cannot attend\n" +
				"your Birthday Party. It's too bad that I'm your only\n" +
				"living relative. I promise to be home for Chirstmas.\n" +
				"Love,\nGarth Fields\n"));
	}
	
	public void meet(Player p) {
		System.out.println();
		this.say("Greetings traveler");
		
		System.out.println("1. \"Who are you?\"");
		System.out.println("2. \"I don't like your tone...\" (attack)");
		
		int n = p.chooseOption(1, 2);
		System.out.println();
		if(n == 1) {
			((Entity)this).setName("Garth Fields");
			this.say("My name is Garth Fields, I'm a traveler");
			
			System.out.println("1. \"Goodbye\"");
			System.out.println("2. \"That's a nice note you got, you don't need it do you?\" (speech)");
			System.out.println("3. \"That's a ripoff of the famous comic strip!\" (attack)");
			n = p.chooseOption(1, 3);
			System.out.println();
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
		this.say("Prepare to die");
		p.fight(this);
	}
}
