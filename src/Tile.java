import java.util.*;  
import java.io.*;  
import java.lang.*;
import entities.Ennemy;
import items.Item;
import miscellaneous.Misc;

public class Tile {
    boolean isAccessible;
    boolean hasEnnemy; 
    boolean hasChest;
    String Rarity;
    entities.Ennemy ennemy;
    Fight fight;
    items.Item[] Chest;
	
    private int getIndexOfRarity() {
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
    	return iRarity;
    }
    
    items.Item[] generateChest(){
    	items.Item[] chest = new items.Item[Misc.diceRoll(5, 1)];
    	int iRarity = getIndexOfRarity();
    	for (int i = 0; i < chest.length; ++i) {
    		int iItemType = Misc.diceRoll(4,1);
    		switch (iItemType) {
    			case 1:
    				chest[i] = Database.ARMOR_DATABASE[iRarity][Misc.diceRoll(Database.ARMOR_DATABASE[iRarity].length-1,0)]; break;
    			case 2:
					chest[i] = Database.ARTEFACT_DATABASE[iRarity][Misc.diceRoll(Database.ARTEFACT_DATABASE[iRarity].length-1,0)]; break;
    			case 3:
					chest[i] = Database.POTION_DATABASE[iRarity][Misc.diceRoll(Database.POTION_DATABASE[iRarity].length-1,0)]; break;
    			case 4:
					chest[i] = Database.WEAPON_DATABASE[iRarity][Misc.diceRoll(Database.WEAPON_DATABASE[iRarity].length-1,0)]; break;
    		}
    	}
    	return chest;
    }
    
    entities.Ennemy generateEnnemy(){
    	int iRarity = getIndexOfRarity();
    	 return Database.ENNEMY_DATABASE[iRarity][Misc.diceRoll(Database.ENNEMY_DATABASE[iRarity].length-1, 0)];
    }
    
    public Tile(boolean isAccessible, boolean hasEnnemy, boolean hasChest, String rarity) {
		super();
		this.isAccessible = isAccessible;
		this.hasEnnemy = hasEnnemy;
		this.hasChest = hasChest;
		Rarity = rarity;
		if (this.hasChest)
			Chest = generateChest();
		else
			Chest = null;
		if (this.hasEnnemy)
			this.ennemy = generateEnnemy();
		else
			this.ennemy = null;
		this.fight = null;
	}
    
    public void showTile(scanner Scanner) {
    	
    }
}
