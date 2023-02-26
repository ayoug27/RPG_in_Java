import java.util.*;  
import java.io.*;  
import items.*;
import entities.*;


public class main {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		items.Weapon[][] weaponDatabase = Database.setWeaponDatabase("res/weaponDatabase.properties");
		items.Potion[][] potionDatabase = Database.setPotionDatabase("res/potionDatabase.properties");
		items.Armor[][] armorDatabase = Database.setArmorDatabase("res/armorDatabase.properties");
		entities.Hero Hero = new Hero(0,0);
		Hero.getInventory().addWeaponInPocket(weaponDatabase[0][9]);
		Hero.getInventory().addPotionInPocket(potionDatabase[0][0]);
		Hero.getInventory().addArtefactInPocket(new Artefact("Talisman d'Attaque","Common","Attaque",5));
		System.out.println(Hero.getInventory().accessWeaponInPocket(1));
		System.out.println(Hero.getAttack());
		Hero.equipWeaponFromInventory(1);
		Hero.setEquippedArtefact(new Artefact("Talisman d'Attaque","Common","Attack",5));
		Hero.setAttack();
		System.out.println(Hero.getAttack());
		System.out.println(Hero.getInventory().getItemsInWeaponsPocket());
	}
}
