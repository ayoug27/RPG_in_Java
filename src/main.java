import java.util.*;  
import java.io.*;  
import java.lang.*;
import items.*;
import entities.*;


public class main {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*		entities.Hero Hero = new Hero(0,0);
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
		entities.Hero Hero = new Hero(0,0);
		entities.Ennemy rat = new Ennemy(5, 1, 1, 1, "Rat d'egout", "Un rat d'egout trop cracra","Common", 1, 3, false);
		Fight fight = new Fight(Hero,rat,false);
		fight.fightTurn();*/
		Tile dalle = new Tile(true, false, true, "Common", null);
		System.out.println(dalle.Chest[0]);
	}
}
