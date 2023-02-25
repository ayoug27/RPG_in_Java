import java.util.*;
import items.*;

import java.io.*;  

public class Database {
	public final entities.Ennemy[][] ENNEMY_DATABASE;
	public final items.Armor[][] ARMOR_DATABASE;
	public final items.Artefact[][] ARTEFACT_DATABASE;
	public final items.Potion[][] POTION_DATABASE;
	public final items.Weapon[][] WEAPON_DATABASE;

	private entities.Ennemy[] setEnnemyDatabase (String filename)
	{
		
	}
	
	public static items.Armor[][] setArmorDatabase (String filename) throws Exception
	{
	    FileReader reader = new FileReader(filename);        
	    Properties p=new Properties();  
	    p.load(reader);  
		items.Armor[][] armorDatabase = new items.Armor[6][];
		armorDatabase[0] = new items.Armor[Integer.parseInt(p.getProperty("commonItems"))]; 
		armorDatabase[1] = new items.Armor[Integer.parseInt(p.getProperty("uncommonItems"))]; 
		armorDatabase[2] = new items.Armor[Integer.parseInt(p.getProperty("rareItems"))];
		armorDatabase[3] = new items.Armor[Integer.parseInt(p.getProperty("epicItems"))]; 
		armorDatabase[4] = new items.Armor[Integer.parseInt(p.getProperty("legendaryItems"))]; 
		armorDatabase[5] = new items.Armor[Integer.parseInt(p.getProperty("mythicItems"))]; 
		int counter = 0;
		for (int i = 0; i < armorDatabase.length; ++i){
			for (int j = 0; j < armorDatabase[i].length;++j){
				String name = p.getProperty("name"+counter);
				String rarity = p.getProperty("rarity"+counter);
				int defense = Integer.parseInt(p.getProperty("defense"+counter));
				armorDatabase[i][j] = new Armor(name,rarity,defense);
				++counter;
			}
		}
		return armorDatabase;
	}
	
	public static items.Potion[][] setPotionDatabase (String filename) throws Exception
	{
	    FileReader reader = new FileReader(filename);        
	    Properties p=new Properties();  
	    p.load(reader);  
		items.Potion[][] potionDatabase = new items.Potion[6][];
		potionDatabase[0] = new items.Potion[Integer.parseInt(p.getProperty("commonItems"))]; 
		potionDatabase[1] = new items.Potion[Integer.parseInt(p.getProperty("uncommonItems"))]; 
		potionDatabase[2] = new items.Potion[Integer.parseInt(p.getProperty("rareItems"))];
		potionDatabase[3] = new items.Potion[Integer.parseInt(p.getProperty("epicItems"))]; 
		potionDatabase[4] = new items.Potion[Integer.parseInt(p.getProperty("legendaryItems"))]; 
		potionDatabase[5] = new items.Potion[Integer.parseInt(p.getProperty("mythicItems"))]; 
		int counter = 0;
		for (int i = 0; i < potionDatabase.length; ++i){
			for (int j = 0; j < potionDatabase[i].length;++j){
				String name = p.getProperty("name"+counter);
				String rarity = p.getProperty("rarity"+counter);
				int healthValue = Integer.parseInt(p.getProperty("healthValue"+counter));
				potionDatabase[i][j] = new Potion(name,rarity,healthValue);
				++counter;
			}
		}
		return potionDatabase;
	}
	
	public static items.Weapon[][] setWeaponDatabase (String filename) throws Exception
	{
	    FileReader reader = new FileReader(filename);        
	    Properties p=new Properties();  
	    p.load(reader);  
		items.Weapon[][] weaponDatabase = new items.Weapon[6][];
		weaponDatabase[0] = new items.Weapon[Integer.parseInt(p.getProperty("commonItems"))]; 
		weaponDatabase[1] = new items.Weapon[Integer.parseInt(p.getProperty("uncommonItems"))]; 
		weaponDatabase[2] = new items.Weapon[Integer.parseInt(p.getProperty("rareItems"))];
		weaponDatabase[3] = new items.Weapon[Integer.parseInt(p.getProperty("epicItems"))]; 
		weaponDatabase[4] = new items.Weapon[Integer.parseInt(p.getProperty("legendaryItems"))]; 
		weaponDatabase[5] = new items.Weapon[Integer.parseInt(p.getProperty("mythicItems"))]; 
		int counter = 0;
		for (int i = 0; i < weaponDatabase.length; ++i){
			for (int j = 0; j < weaponDatabase[i].length;++j){
				String name = p.getProperty("name"+counter);
				String rarity = p.getProperty("rarity"+counter);
				int attack = Integer.parseInt(p.getProperty("attack"+counter));
				weaponDatabase[i][j] = new Weapon(name,rarity,attack);
				++counter;
			}
		}
		return weaponDatabase;
	}

	public Database(String ennemyFileName, String armorFileName, String artefactFileName, String potionFileName, String weaponFileName) {
		ENNEMY_DATABASE = setEnnemyDatabase(ennemyFileName);
		ARMOR_DATABASE = setArmorDatabase(armorFileName);
		ARTEFACT_DATABASE = setArtefactDatabase(artefactFileName);
		POTION_DATABASE = setPotionDatabase(potionFileName);
		WEAPON_DATABASE = setWeaponDatabase(weaponFileName);
	}
}