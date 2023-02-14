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
		Hero.getInventory().addWeaponInPocket(new Weapon(0, "Epée en Bois","Common",1));
		Hero.getInventory().addWeaponInPocket(new Weapon(0, "Epée en Pierre","Uncommon",5));
		Hero.getInventory().addPotionInPocket(new Potion(0, "A","Common",5));
		Hero.getInventory().addPotionInPocket(new Potion(0, "B","Common",5));
		Hero.getInventory().addPotionInPocket(new Potion(0, "C","Common",5));
		Hero.getInventory().addPotionInPocket(new Potion(0, "D","Common",5));
		Hero.getInventory().addPotionInPocket(new Potion(0, "E","Common",5));
		System.out.println(Hero.getInventory().accessPotionInPocket(1).toString());
		System.out.println(Hero.getInventory().accessPotionInPocket(2).toString());
		System.out.println(Hero.getInventory().accessPotionInPocket(3).toString());
		System.out.println(Hero.getInventory().accessPotionInPocket(4).toString());
		System.out.println(Hero.getInventory().accessPotionInPocket(5).toString());
		System.out.println(Hero.getInventory().getItemsInPotionsPocket());
		Hero.getInventory().dropPotionInPocket(2);
		System.out.println();
		System.out.println(Hero.getInventory().accessPotionInPocket(1).toString());
		System.out.println(Hero.getInventory().accessPotionInPocket(2).toString());
		System.out.println(Hero.getInventory().accessPotionInPocket(3).toString());
		System.out.println(Hero.getInventory().accessPotionInPocket(4).toString());
		System.out.println(Hero.getInventory().getItemsInPotionsPocket());
	}
}
