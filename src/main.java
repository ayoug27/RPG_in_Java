import java.util.*;  
import java.io.*;  
import java.lang.*;
import items.*;
import entities.*;
import miscellaneous.*;



public class main {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		entities.Hero Hero = new Hero(0,0);
/*		Hero.getInventory().addWeaponInPocket(weaponDatabase[0][9]);
		Hero.getInventory().addPotionInPocket(potionDatabase[0][0]);
		Hero.getInventory().addArtefactInPocket(new Artefact("Talisman d'Attaque","Common","Attaque",5));
		System.out.println(Hero.getInventory().accessWeaponInPocket(1));
		System.out.println(Hero.getAttack());
		Hero.equipWeaponFromInventory(1);
		Hero.setEquippedArtefact(new Artefact("Talisman d'Attaque","Common","Attack",5));
		Hero.setAttack();
		System.out.println(Hero.getAttack());
		System.out.println(Hero.getInventory().getItemsInWeaponsPocket());
		entities.Hero Hero = new Hero(0,0);
		Tile dalle = new Tile(true, true, true, "Common");
		System.out.println(dalle.Chest[0]);*/
		Scanner scanner = new Scanner(System.in);
		Hero.setEquippedArtefact(Database.ARTEFACT_DATABASE[0][0]);
		Hero.setEquippedWeapon(Database.WEAPON_DATABASE[0][0]);
		Hero.getInventory().setSpareArmor(Database.ARMOR_DATABASE[0][0]);
		Hero.getInventory().addArtefactInPocket(Database.ARTEFACT_DATABASE[0][0]);
		Hero.getInventory().addWeaponInPocket(Database.WEAPON_DATABASE[0][5]);
		Hero.getInventory().addPotionInPocket(Database.POTION_DATABASE[0][0]);
//		Hero.showInventory(scanner);
		Fight fight = new Fight(Hero,Database.ENNEMY_DATABASE[0][0],false);
		fight.showFight(scanner);
	}
}

