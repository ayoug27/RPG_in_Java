package items;

public class Item {
	private String Name;
	private String Rarity;

	private boolean checkRarity (String rarity){
		final String[] LIST_RAR = {"Common","Uncommon","Rare","Epic","Legendary","Mythic"};
		for (String element : LIST_RAR) {
		    if (element.equals(rarity)) {
		        return true;
		    }
		}
		return false;
	}
	
	public Item(String name, String rarity) {
		if (checkRarity(rarity)){
			Name = name;
			Rarity = rarity;
		}
		else
			System.err.println("This rarity doesn't exist.");
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRarity() {
		return Rarity;
	}
	
	
	public void setRarity(String rarity) {
		if (checkRarity(rarity))
			Rarity = rarity;
	}
}
