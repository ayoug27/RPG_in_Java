package items;

public class Item {
	private String Name;
	private String Rarity;

	private boolean checkRarity (String rarity){
		final String[] LIST_RAR = {"Common","Uncommon","Rare","Epic","Legendary","Mythic"};
		for (String element : LIST_RAR) {
		    if (element == rarity) {
		        return true;
		    }
		}
		return false;
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
