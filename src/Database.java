import java.util.*;  
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
	
	private items.Potion[] setPotionDatabase (String filename)
	{
		
	}
	
	private items.Weapon[] setWeaponDatabase (String filename) throws Exception
	{
		FileReader reader=new FileReader(filename);  	      
	    Properties p=new Properties();  
	    p.load(reader);  
		items.Weapon[] weaponDatabase = new items.Weapon[p.size()/4];
		
	}

	public Database(String ennemyFileName, String armorFileName, String artefactFileName, String potionFileName, String weaponFileName) {
		ENNEMY_DATABASE = setEnnemyDatabase(ennemyFileName);
		ARMOR_DATABASE = setArmorDatabase(armorFileName);
		ARTEFACT_DATABASE = setArtefactDatabase(artefactFileName);
		POTION_DATABASE = setPotionDatabase(potionFileName);
		WEAPON_DATABASE = setWeaponDatabase(weaponFileName);
	}
}
