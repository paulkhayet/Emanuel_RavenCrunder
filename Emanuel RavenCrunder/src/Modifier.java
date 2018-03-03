
public class Modifier extends Item{
	
	private double strength, magic, sneak, speech;
	
	public Modifier(String name, String desc,
			double str, double m, double sn, double sp) {
		super(name, desc);
		strength = str;
		magic = m;
		sneak = sn;
		speech = sp;
	}
	
	public void use(Player p) {
		p.addStrength(strength);
		p.addMagic(magic);
		p.addSneak(sneak);
		p.addSpeech(speech);
	}
	
	public String toString() {
		String s = this.getName() + ": " + this.getDescription();
		if(strength > 0)
			s += "\nStrength: +" + strength;
		if(magic > 0)
			s += "\nMagic: +" + magic;
		if(sneak > 0)
			s += "\nSneak: +" + sneak;
		if(speech > 0)
			s += "\nSpeech: +" + speech;
		
		return s;
	}
}
