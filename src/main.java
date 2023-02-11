import entities.*;
import items.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		
		final String[] LIST_RAR = {"Common","Uncommon","Rare","Epic","Legendary","Mythic"};
		String rarity = "Common";
		for (String element : LIST_RAR) {
		    if (element == rarity) {
		        System.out.println("Present");
		    }
		}
		System.out.println("Absent");
*/
		entities.Hero Hero = new Hero(0,0);
		Hero.getInventory().potionsPocket[0] = new Potion(0, "Potion de Vie","Common",5);
		System.out.println(Hero.getInventory().potionsPocket[0].toString());
	}
}
