import java.util.*;

import miscellaneous.Misc;

import java.io.*;  
import java.lang.*;

public class Fight {
	private entities.Hero Hero;
	private entities.Ennemy Ennemy; 
	boolean isFinished;
	
	public Fight(entities.Hero hero, entities.Ennemy ennemy, boolean isFinished) {
		Hero = hero;
		Ennemy = ennemy;
		this.isFinished = isFinished;
	}
		
	public void victory() {
		System.out.printf("Vous avez battu %s ! Le combat est terminé.\n",Ennemy.getName());
		Misc.wait(1000);
		if (this.Ennemy.isBoss()) {
			System.out.println("Vous avez gagné le jeu !");
			System.exit(0);
		}
		int xpWon = Misc.diceRoll(Ennemy.getMaxXPGiven(), Ennemy.getMinXPGiven());
		Hero.setXP(Hero.getXP()+xpWon);
		System.out.printf("Vous gagnez %d XP !\n",xpWon);
		Hero.levelUp();
		this.isFinished = true;
	}
	
	public void defeat() {
		System.out.printf("Vous n'avez plus de PV, %s vous a tué.\n", Ennemy.getName());
		this.isFinished = true;
		Misc.gameOver();
	}
	
	public void heroAttack() {
		int damage = Misc.diceRoll(Hero.getAttack(),1)-Misc.diceRoll(Ennemy.getBaseDefense(),0);
		if (damage > 0) {
			Ennemy.setHP(Ennemy.getHP()-damage);
			System.out.printf("Vous attaquez %s et lui enlevez %d PV. Il lui reste %d PV.\n",Ennemy.getName(),damage,Ennemy.getHP());
			Misc.wait(500);
		}
		else
			System.out.printf("%s a absorbe le choc ! \n",Ennemy.getName());
	}
	
	public void ennemyAttack() {
		int damage = Misc.diceRoll(Ennemy.getBaseAttack(),1)-Misc.diceRoll(Hero.getBaseDefense(),0);
		if (damage > 0) {
			Hero.setHP(Hero.getHP()-damage);
			System.out.printf("%s vous attaque et vous enleve %d PV. Il vous reste %d PV.\n",Ennemy.getName(),damage,Hero.getHP());
			Misc.wait(500);
		}
		else
			System.out.println("Vous absorbez le choc et ne recevez aucun degats !");
	}
	
	public void showAttack()
	{
		int speedHero = Misc.diceRoll(Hero.getSpeed(),1);
		int speedEnnemy = Misc.diceRoll(Ennemy.getBaseSpeed(),1);
		System.out.println("----------------------------------");
		if (speedHero >= speedEnnemy) {
			System.out.println("Vous etes plus rapide et attaquez en premier !");
			Misc.wait(500);
			heroAttack();
			Misc.wait(500);
			ennemyAttack();
			return;
		}
		else {
			System.out.printf("%s est plus rapide et vous attaque en premier !\n",Ennemy.getName());
			Misc.wait(500);			
			ennemyAttack();
			Misc.wait(500);
			heroAttack();
			return;
		}
	}
	
	public void showFight(Scanner scanner) {
		while (true) {
			if (Ennemy.getHP() <= 0) {
				victory();
				return;
			}
			if (Hero.getHP() <= 0)
				defeat();
			System.out.println("----------------------------------");
			System.out.printf("Vous êtes en combat avec %s !\n",Ennemy.getName());
			System.out.printf("Vos PV : %d/%d\n",Hero.getHP(),Hero.getMaxHP());
			System.out.printf("PV de l'ennemi : %d\n",Ennemy.getHP());
			System.out.println("attack; inventory");
	        String prompt = scanner.nextLine();
			switch (prompt) {
			case "attack":
				showAttack();
				Misc.wait(500); break;
			case "inventory":
				Hero.showInventory(scanner); break;
			default:
				System.out.println("Commande inconnue. Veuillez réessayer."); continue;
			}
		}
	}
}
