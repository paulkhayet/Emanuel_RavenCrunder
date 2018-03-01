import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Player player = new Player("", "Unknown Adventurer");
		
		System.out.println("You awake in the middle of the woods.\n" + 
				"You don't know where you are or why you are here,\n" +
				"but you know who you are...");
		
		System.out.print("Enter your name: ");
		player.setName(player.acceptString());
		System.out.println("\nWelcome, " + player.getName()
				+ ", to " + 
				"Emanuel RavenCrunder\n");
		
		GarthFields garthF = new GarthFields();
		System.out.println("You follow a path through the trees\n" + 
				"and come across a man.");
		garthF.meet(player);
		
		System.out.print("\nEnter any key to continue...");
		input.nextLine();
		
		clear();
		System.out.println("To Be continued...");
	}
	
	public static void clear() {
		for(int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
}
