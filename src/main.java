import entities.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[] LIST_RAR = {"Common","Uncommon","Rare","Epic","Legendary","Mythic"};
		String rarity = "Common";
		for (String element : LIST_RAR) {
		    if (element == rarity) {
		        System.out.println("Present");
		    }
		}
		System.out.println("Absent");
	}

}
