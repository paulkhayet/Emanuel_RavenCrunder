/******************************************
 * Represents a sword that gives the user
 * extra strength.
 * @author Alec Bertoy
 * @version 3/5/2018
 *****************************************/
public class Sword extends Item{

    private double strength;

    public Sword(String name, String desc,
                    double str) {
        super(name, desc);
        strength = str;
    }

    /**
     * Adds strength to the player
     * @param p the player object is passed so items can alter the player
     */
    public void use(Player p) {
        p.addStrength(strength);

        System.out.println("\nYou have received a " + this.getName());
        System.out.println("Your " + this.getDescription());

    }

    /**
     * Takes away the strength the item added to the player
     * @param p the player object
     */
    public void unUse(Player p) {
        p.addStrength(-strength);

        System.out.println("\nYou have lost your " + this.getName());
    }
}
