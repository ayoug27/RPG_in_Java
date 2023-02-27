import entities.Ennemy;
import items.Item;

public class Tile {
    boolean isAccessible;
    boolean hasEnnemy; 
    boolean hasChest;
    String Rarity;
    entities.Ennemy ennemyContained;
    Fight fight;
    items.Item[] Chest;
	
    items.Item[] generateChest(){
    	items.Item[] chest = new items.Item[Misc.diceRoll(5, 1)];
    	int iRarity = 0;
    	switch (this.Rarity) {
    		case "Common":
    			iRarity = 0; break;
    		case "Uncommon":
    			iRarity = 1; break;
    		case "Rare":
    			iRarity = 2; break;
    		case "Epic":
    			iRarity = 3; break;
    		case "Legendary":
    			iRarity = 4; break;
    		case "Mythic":
    			iRarity = 5; break;
    	}
    	for (int i = 0; i < chest.length; ++i) {
    		int iItemType = Misc.diceRoll(4,1);
    		switch (iItemType) {
    			case 1:
    				chest[i] = Database.ARMOR_DATABASE[iRarity][Misc.diceRoll(Database.ARMOR_DATABASE[iRarity].length-1,0)];
    			case 2:
    				chest[i] = Database.ARMOR_DATABASE[iRarity][Misc.diceRoll(Database.ARMOR_DATABASE[iRarity].length-1,0)];
//					chest[i] = Database.ARTEFACT_DATABASE[iRarity][Misc.diceRoll(Database.ARTEFACT_DATABASE[iRarity].length-1,0)];
    			case 3:
					chest[i] = Database.POTION_DATABASE[iRarity][Misc.diceRoll(Database.POTION_DATABASE[iRarity].length-1,0)];
    			case 4:
					chest[i] = Database.WEAPON_DATABASE[iRarity][Misc.diceRoll(Database.WEAPON_DATABASE[iRarity].length-1,0)];
    		}
    	}
    	return chest;
    }
    
    public Tile(boolean isAccessible, boolean hasEnnemy, boolean hasChest, String rarity, Ennemy ennemyContained) {
		super();
		this.isAccessible = isAccessible;
		this.hasEnnemy = hasEnnemy;
		this.hasChest = hasChest;
		Rarity = rarity;
		this.ennemyContained = ennemyContained;
		this.fight = null;
		Chest = generateChest();
	}

    
}
