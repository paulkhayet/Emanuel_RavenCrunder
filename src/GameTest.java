import java.util.Scanner;

/*******************************
 * Driver program for the game.
 * @author Alec Bertoy
 * @version 3/5/2018
 ******************************/
public class GameTest {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Player player = new Player("", "Unknown Adventurer");

		//Game Intro
		player.clear();
		System.out.println("You awake in the middle of the woods.\n" + 
				"You don't know where you are or why you are here,\n" +
				"but you know who you are...");
		
		System.out.print("Enter your name: ");
		player.setName(input.nextLine());
		player.clear();
		System.out.println("\nWelcome, " + player.getName()
				+ ", to " + 
				"Emanuel RavenCrunder\n");

		//Garth Fields
		GarthFields garthF = new GarthFields();
		System.out.println("You follow a path through the trees\n" + 
				"and come across a man.");
		garthF.meet(player);
		player.gameBreak();
		player.clear();

		//Fergus
		System.out.println("You continue down the road and come across a large ogre\n");
		Fergus fergus = new Fergus();
		fergus.meet(player);
		
	}
}
