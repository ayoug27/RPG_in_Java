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
		items.Weapon[] weaponDatabase = Database.setWeaponDatabase("res/weaponDatabase.properties");
		items.Potion[] potionDatabase = Database.setPotionDatabase("res/potionDatabase.properties");
		System.out.println(potionDatabase[0].getName());
	}
}
