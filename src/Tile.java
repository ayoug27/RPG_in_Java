import java.util.*;  
import java.io.*;  
import java.lang.*;
import entities.Ennemy;
import items.*;
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
    				items.Armor armor = Database.ARMOR_DATABASE[iRarity][Misc.diceRoll(Database.ARMOR_DATABASE[iRarity].length-1,0)];
    				chest[i] = new items.Armor(armor.getName(),armor.getRarity(),armor.getDefense());
    				break;
    			case 2:
    				items.Artefact artefact = Database.ARTEFACT_DATABASE[iRarity][Misc.diceRoll(Database.ARTEFACT_DATABASE[iRarity].length-1,0)]; 
    				chest[i] = new items.Artefact(artefact.getName(), artefact.getRarity(), artefact.getBuffedAbility(), artefact.getBuffValue());
    				break;
    			case 3:
    				items.Potion potion = Database.POTION_DATABASE[iRarity][Misc.diceRoll(Database.POTION_DATABASE[iRarity].length-1,0)];
    				chest[i] = new items.Potion(potion.getName(),potion.getRarity(),potion.getHealthValue());
    				break;
    			case 4:
    				items.Weapon weapon = Database.WEAPON_DATABASE[iRarity][Misc.diceRoll(Database.WEAPON_DATABASE[iRarity].length-1,0)];
    				chest[i] = new items.Weapon(weapon.getName(),weapon.getRarity(),weapon.getAttack());
    				break;
    		}
    	}
    	return chest;
    }
    
    entities.Ennemy generateEnnemy(){
    	int iRarity = getIndexOfRarity();
    	ennemy = Database.ENNEMY_DATABASE[iRarity][Misc.diceRoll(Database.ENNEMY_DATABASE[iRarity].length-1, 0)];
    	return new Ennemy(ennemy.getHP(),ennemy.getBaseAttack(),ennemy.getBaseDefense(),ennemy.getBaseSpeed(),ennemy.getName(),ennemy.getDescription(),ennemy.getRarity(),ennemy.getMinXPGiven(),ennemy.getMaxXPGiven(),ennemy.isBoss());
    }

    public Tile(boolean isAccessible, boolean hasEnnemy, boolean hasChest, String rarity, entities.Hero Hero) {
		super();
		this.isAccessible = isAccessible;
		this.hasEnnemy = hasEnnemy;
		this.hasChest = hasChest;
		Rarity = rarity;
		if (this.hasChest)
			Chest = generateChest();
		else
			Chest = null;
		if (this.hasEnnemy) {
			this.ennemy = generateEnnemy();
			this.fight = new Fight(Hero,this.ennemy,false);
		}
		else {
			this.ennemy = null;
			this.fight = null;
		}
	}
    
    public Item getItemFromChest(int i) {
    	int index = i-1;
        Item item = this.Chest[index];
        if (item.getClass() == Armor.class) {
            return (Armor) item;
        } else if (item.getClass() == Weapon.class) {
            return (Weapon) item;
        } else if (item.getClass() == Artefact.class) {
            return (Artefact) item;
        } else {
            return null;
        }
    }
    
    public void removeFromChest(int index){
		items.Item[] newChest = new items.Item[this.Chest.length-1];
		for (int i = 0, k = 0; i < newChest.length;){
			if (this.Chest[k].equals(this.getItemFromChest(index))) {
				++k;
			}
			newChest[i]=this.Chest[k];
			++i;
			++k;
		}
		this.Chest = newChest;
    }
}
