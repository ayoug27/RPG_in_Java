import java.util.*;  
import java.io.*;  
import items.*;
import entities.*;

public class main {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
/*
		entities.Hero Hero = new Hero(0,0);
		Hero.getInventory().addWeaponInPocket(new Weapon(0, "Epée en Bois","Common",1));
		Hero.getInventory().addPotionInPocket(new Potion(0, "Potion de Vie","Common",5));
		Hero.getInventory().addArtefactInPocket(new Artefact(0, "Talisman d'Attaque","Common","Attaque",5));
		System.out.println(Hero.getInventory().accessPotionInPocket(1).toString());
		System.out.println(Hero.getInventory().accessWeaponInPocket(1).toString());
		System.out.println(Hero.getInventory().accessArtefactInPocket(1).toString());
		Hero.getInventory().dropArtefact(1);
		System.out.println(Hero.getInventory().getItemsInArtefactsPocket());
*/
	    FileReader reader = new FileReader("weaponDatabase.properties");  
	      
	    Properties p=new Properties();  
	    p.load(reader);  
	      
/*	    System.out.println(p.getProperty("id0"));  
	    System.out.println(p.getProperty("name0"));  
	    System.out.println(p.getProperty("rarity0"));  
	    System.out.println(p.getProperty("attack0"));  
	    System.out.println(p.size()/4);*/
		items.Weapon[] weaponDatabase = new items.Weapon[p.size()/4];
		int id = Integer.parseInt(p.getProperty("id"+0));
		for (int i = 0; i < weaponDatabase.length; ++i)
		{
			weaponDatabase[i] = new Weapon (Integer.parseInt(p.getProperty("id"+i)),p.getProperty("name"+i),p.getProperty("rarity"+i),Integer.parseInt(p.getProperty("attack"+i)));
		}

	}
}
