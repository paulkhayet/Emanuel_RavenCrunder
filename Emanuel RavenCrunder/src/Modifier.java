
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
}
