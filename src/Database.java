import java.util.*;
import items.*;

import java.io.*;  

public class Database {
	public final entities.Ennemy[] ENNEMY_DATABASE;
	public final items.Armor[] ARMOR_DATABASE;
	public final items.Artefact[] ARTEFACT_DATABASE;
	public final items.Potion[] POTION_DATABASE;
	public final items.Weapon[] WEAPON_DATABASE;

	private entities.Ennemy[] setEnnemyDatabase (String filename)
	{
		
	}
	
	private items.Armor[] setArmorDatabase (String filename)
	{
		
	}
	
	private items.Armor[] setArtefactDatabase (String filename)
	{
		
	}
	
	public static items.Potion[] setPotionDatabase (String filename) throws Exception
	{
	    FileReader reader = new FileReader(filename);        
	    Properties p=new Properties();  
	    p.load(reader);  
		items.Potion[] potionDatabase = new items.Potion[p.size()/3];
		for (int i = 0; i < potionDatabase.length; ++i)
		{
			String name = p.getProperty("name"+i);
			String rarity = p.getProperty("rarity"+i);
			int healthValue = Integer.parseInt(p.getProperty("healthValue"+i));
			potionDatabase[i] = new Potion(i,name,rarity,healthValue);
		}
		return potionDatabase;		
	}
	
	public static items.Weapon[] setWeaponDatabase (String filename) throws Exception
	{
	    FileReader reader = new FileReader(filename);        
	    Properties p=new Properties();  
	    p.load(reader);  
		items.Weapon[] weaponDatabase = new items.Weapon[p.size()/3];
		for (int i = 0; i < weaponDatabase.length; ++i)
		{
			String name = p.getProperty("name"+i);
			String rarity = p.getProperty("rarity"+i);
			int attack = Integer.parseInt(p.getProperty("attack"+i));
			weaponDatabase[i] = new Weapon(i,name,rarity,attack);
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
