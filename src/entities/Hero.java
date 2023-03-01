package entities;

import miscellaneous.*;
import java.util.Scanner;

public class Hero extends Entity {
	private int maxHP;
	private int X;
	private int Y;
	private int Level;
	private int XP;
	private int Attack;
	private int Defense;
	private int Speed;
	private items.Weapon equippedWeapon;
	private items.Armor equippedArmor;
	private items.Artefact equippedArtefact;
	private entities.Inventory Inventory;

	public Hero(int x, int y) {
		super(10, 1, 1, 1);
		maxHP = this.getHP();
		X = x;
		Y = y;
		Level = 1;
		XP = 0;
		this.equippedWeapon = null;
		this.equippedArmor = null;
		this.equippedArtefact = null;
		Attack = 1;
		Defense = 1;
		Speed = 1;
		Inventory = new Inventory();
	}
	
	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public int getXP() {
		return XP;
	}

	public void setXP(int xP) {
		XP = xP;
	}

	public int getAttack() {
		return Attack;
	}

	public void setAttack() {
		int itemAttack = 0;
		if (this.equippedWeapon != null)
			itemAttack += this.equippedWeapon.getAttack();
		if (this.equippedArtefact != null && this.equippedArtefact.getBuffedAbility() == "Attack")
			itemAttack += this.equippedArtefact.getBuffValue();
		Attack = this.getBaseAttack() + itemAttack;
	}

	public int getDefense() {
		return Defense;
	}

	public void setDefense() {
		int itemDefense = 0;
		if (this.equippedArmor != null)
			itemDefense += this.equippedArmor.getDefense();
		if (this.equippedArtefact != null && this.equippedArtefact.getBuffedAbility() == "Defense")
			itemDefense += this.equippedArtefact.getBuffValue();
		Defense = this.getBaseDefense() + itemDefense;
	}

	public int getSpeed() {
		return Speed;
	}

	public void setSpeed() {
		int itemSpeed = 0;
		if (this.equippedArtefact != null && this.equippedArtefact.getBuffedAbility() == "Speed")
			itemSpeed += this.equippedArtefact.getBuffValue();
		Speed = this.getBaseSpeed() + itemSpeed;
	}

	public items.Weapon getEquippedWeapon() {
		return equippedWeapon;
	}

	public void setEquippedWeapon(items.Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
		this.setAttack();
	}

	public items.Armor getEquippedArmor() {
		return equippedArmor;
	}

	public void setEquippedArmor(items.Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
		this.setDefense();
	}

	public items.Artefact getEquippedArtefact() {
		return equippedArtefact;
	}

	public void setEquippedArtefact(items.Artefact equippedArtefact) {
		this.equippedArtefact = equippedArtefact;
		this.setAttack();
		this.setDefense();
		this.setSpeed();
	}

	public entities.Inventory getInventory() {
		return Inventory;
	}

	public void setInventory(entities.Inventory inventory) {
		Inventory = inventory;
	}

	public void equipWeaponFromInventory(int i) {
		if (i <= this.getInventory().getItemsInWeaponsPocket()) {
			if (this.equippedWeapon == null) {
				this.setEquippedWeapon(this.getInventory().accessWeaponInPocket(i));
				this.getInventory().dropWeapon(i);
			} else {
				items.Weapon actualEquippedWeapon = this.equippedWeapon;
				this.setEquippedWeapon(this.getInventory().accessWeaponInPocket(i));
				this.getInventory().dropWeapon(i);
				this.getInventory().addWeaponInPocket(actualEquippedWeapon);
			}
		} else {
			System.err.println("Vous n'avez pas d'objet a cet endroit !");
			return;
		}
	}

	public void equipArtefactFromInventory(int i) {
		if (i <= this.getInventory().getItemsInArtefactsPocket()) {
			if (this.equippedArtefact == null) {
				this.setEquippedArtefact(this.getInventory().accessArtefactInPocket(i));
				this.getInventory().dropArtefact(i);
			} else {
				items.Artefact actualEquippedArtefact = this.equippedArtefact;
				this.setEquippedArtefact(this.getInventory().accessArtefactInPocket(i));
				this.getInventory().dropArtefact(i);
				this.getInventory().addArtefactInPocket(actualEquippedArtefact);
			}
		} else {
			System.err.println("Vous n'avez pas d'objet a cet endroit !");
			return;
		}
	}

	public void equipArmorFromInventory() {
		if (this.getInventory().getSpareArmor() != null) {
			if (this.equippedArmor == null) {
				this.setEquippedArmor(this.getInventory().getSpareArmor());
				this.getInventory().setSpareArmor(null);
			} else {
				items.Armor actualEquippedArmor = this.equippedArmor;
				this.setEquippedArmor(this.getInventory().getSpareArmor());
				this.getInventory().setSpareArmor(actualEquippedArmor);
			}
		} else {
			System.err.println("Vous n'avez pas d'objet a cet endroit !");
			return;
		}
	}

	public void levelUp() {
		if (this.XP >= this.Level * 10) {
			this.XP -= this.Level * 10;
			this.Level += 1;
			skillLevelUp(this.getLevel());
		}
		else
			System.out.printf("Il vous reste %d XP avant de monter de niveau.\n",this.Level*10-this.XP);
	}

	public void skillLevelUp(int level)
	{
		while (true) {
			System.out.println("Vous êtes monté de niveau ! Choisissez maintenant la compétence que vous allez améliorer.");
			System.out.println("hp; attack; defense; speed");
			Scanner scanner = new Scanner(System.in);
			String prompt = scanner.nextLine();
			switch (prompt) {
			case "hp" :
				this.setMaxHP(this.getMaxHP()+5*(int)(level/2)); 
				System.out.println("Vous vous sentez plus résistant ! Votre vie maximale est à "+this.getMaxHP());
				return;
			case "attack":
				this.setBaseAttack(this.getAttack()+(int)(level/2)); 
				System.out.println("Vous vous sentez plus fort ! Votre attaque est à "+this.getBaseAttack());
				return;
			case "defense":
				this.setBaseDefense(this.getDefense()+(int)(level/2)); 
				System.out.println("Vous vous sentez plus résistant ! Votre défense est à "+this.getBaseDefense());
				return;       	
			case "speed":
				this.setBaseAttack(this.getAttack()+(int)(level/2)); 
				System.out.println("Vous vous sentez plus vif et rapide ! Votre vitesse est à "+this.getBaseSpeed());
				return;
			default:
				System.out.println("Commande inexistante. Veuillez réessayer."); continue;
			}
		}
	}
	
	public void usePotion(items.Potion potion) {
		this.setHP(this.getHP()+potion.getHealthValue());
		if (this.getHP() > this.getMaxHP())
			this.setHP(this.getMaxHP());
	}
	
	public void showInventory(Scanner scanner) {
		while (true) {
			System.out.println("----------------------------------");
			System.out.println("Quel poche voulez-vous regarder ?");
			System.out.println("armor; artefact; potion; weapon; exit");
			String prompt = scanner.nextLine();
			switch (prompt) {
				case "armor":
					showSpareArmor(scanner);
					continue;
				case "artefact":
					showArtefactPocket(scanner);
					continue;
				case "potion":
					showPotionPocket(scanner);
					continue;
				case "weapon":
					showWeaponPocket(scanner);
					continue;
				case "exit":
					return;
				default:
					System.out.println("Commande introuvable, Veuillez Réessayer.");
					continue;
			}
		}
	}

	public void showSpareArmor(Scanner scanner) {
		while (true) {
			System.out.println("----------------------------------");
			if (this.getInventory().getSpareArmor() == null) {
				System.out.println("Vous n'avez pas d'armure dans votre inventaire.");
				Misc.wait(1000);
				return;
			}
			System.out.println(this.getInventory().getSpareArmor());
			System.out.println("equip ; drop ; exit");
			String prompt = scanner.nextLine();
			switch (prompt) {
				case "equip":
					System.out.printf("Vous avez équipé %s.\n", this.getInventory().getSpareArmor().getName());
					Misc.wait(1000);
					this.equipArmorFromInventory();
					break;
				case "drop":
					System.out.printf("Vous avez jeté %s.\n", this.getInventory().getSpareArmor().getName());
					Misc.wait(1000);
					this.getInventory().setSpareArmor(null);
					break;
				case "exit":
					return;
				default:
					System.out.println("Commande introuvable, Veuillez Réessayer.");
					continue;
			}
		}
	}

	public void showArtefactPocket(Scanner scanner) {
		while (true) {
			System.out.println("----------------------------------");
			if (this.getInventory().getItemsInArtefactsPocket() == 0) {
				System.out.println("Vous n'avez pas d'artefacts dans votre inventaire.");
				Misc.wait(1000);
				return;
			}
			for (int numberOfItems = 1; numberOfItems <= this.getInventory()
					.getItemsInArtefactsPocket(); ++numberOfItems) {
				System.out.printf("%d : %s\n", numberOfItems,this.getInventory().accessArtefactInPocket(numberOfItems).getName());
				System.out.println("Choisissez l'objet (numéro) avec lequel vous souhaitez interagir ou tapez exit.");
				String prompt = scanner.nextLine();
				if (prompt == "exit") {
					return;
				}
				int promptInt = Integer.parseInt(prompt);
				if (promptInt > this.getInventory().getItemsInArtefactsPocket()) {
					System.out.println("Objet inexistant. Veuillez réessayer");
					continue;
				}
				showArtefact(scanner,promptInt);
			}
		}
	}
	
	public void showArtefact(Scanner scanner, int promptInt)
	{
		while(true) {
			System.out.println("----------------------------------");
			System.out.println(this.getInventory().accessArtefactInPocket(promptInt));
			System.out.println("equip ; drop ; exit");
			String prompt = scanner.nextLine();
			switch (prompt) {
			case "equip":
				System.out.printf("Vous avez équipé %s.\n",this.getInventory().accessArtefactInPocket(promptInt).getName());
				Misc.wait(1000);
				this.equipArtefactFromInventory(promptInt);
				return;
			case "drop":
				System.out.printf("Vous avez jeté %s.\n",this.getInventory().accessArtefactInPocket(promptInt).getName());
				Misc.wait(1000);
				this.getInventory().dropArtefact(promptInt);
				return;
			case "exit":
				return;
			default:
				System.out.println("Commande introuvable, Veuillez Réessayer.");
				continue;
			}
		}
	}
	
	public void showWeaponPocket(Scanner scanner) {
		while (true) {
			System.out.println("----------------------------------");
			if (this.getInventory().getItemsInWeaponsPocket() == 0) {
				System.out.println("Vous n'avez pas d'armes dans votre inventaire.");
				Misc.wait(1000);
				return;
			}
			for (int numberOfItems = 1; numberOfItems <= this.getInventory()
					.getItemsInWeaponsPocket(); ++numberOfItems) {
				System.out.printf("%d : %s\n", numberOfItems,this.getInventory().accessWeaponInPocket(numberOfItems).getName());
				System.out.println("Choisissez l'objet (numéro) avec lequel vous souhaitez interagir ou tapez exit.");
				String prompt = scanner.nextLine();
				if (prompt == "exit") {
					return;
				}
				int promptInt = Integer.parseInt(prompt);
				if (promptInt > this.getInventory().getItemsInWeaponsPocket()) {
					System.out.println("Objet inexistant. Veuillez réessayer");
					continue;
				}
				showWeapon(scanner,promptInt);
			}
		}
	}
	
	public void showWeapon(Scanner scanner, int promptInt)
	{
		while(true) {
			System.out.println("----------------------------------");
			System.out.println(this.getInventory().accessWeaponInPocket(promptInt));
			System.out.println("equip ; drop ; exit");
			String prompt = scanner.nextLine();
			switch (prompt) {
			case "equip":
				System.out.printf("Vous avez équipé %s.\n",this.getInventory().accessWeaponInPocket(promptInt).getName());
				Misc.wait(1000);
				this.equipWeaponFromInventory(promptInt);
				return;
			case "drop":
				System.out.printf("Vous avez jeté %s.\n",this.getInventory().accessWeaponInPocket(promptInt).getName());
				Misc.wait(1000);
				this.getInventory().dropWeapon(promptInt);
				return;
			case "exit":
				return;
			default:
				System.out.println("Commande introuvable, Veuillez Réessayer.");
				continue;
			}
		}
	}
	
	public void showPotionPocket(Scanner scanner) {
		while (true) {
			System.out.println("----------------------------------");
			if (this.getInventory().getItemsInPotionsPocket() == 0) {
				System.out.println("Vous n'avez pas de potions dans votre inventaire.");
				Misc.wait(1000);
				return;
			}
			for (int numberOfItems = 1; numberOfItems <= this.getInventory().getItemsInPotionsPocket(); ++numberOfItems) {
				System.out.printf("%d : %s\n", numberOfItems,this.getInventory().accessPotionInPocket(numberOfItems).getName());
				System.out.println("Choisissez l'objet (numéro) avec lequel vous souhaitez interagir ou tapez exit.");
				String prompt = scanner.nextLine();
				if (prompt == "exit")
					return;
				int promptInt = Integer.parseInt(prompt);
				if (promptInt > this.getInventory().getItemsInPotionsPocket()) {
					System.out.println("Objet inexistant. Veuillez réessayer");
					continue;
				}
				showPotion(scanner,promptInt);
			}
		}
	}
	
	public void showPotion(Scanner scanner, int promptInt)
	{
		while(true) {
			System.out.println("----------------------------------");
			System.out.println(this.getInventory().accessPotionInPocket(promptInt));
			System.out.println("use ; drop ; exit");
			String prompt = scanner.nextLine();
			switch (prompt) {
			case "use":
				this.usePotion(this.getInventory().accessPotionInPocket(promptInt));
				System.out.printf("Vous avez bu %s, vous avez maintenant %d PV.\n",this.getInventory().accessPotionInPocket(promptInt).getName(),this.getHP());
				this.getInventory().dropPotion(promptInt);
				Misc.wait(1000);
				return;
			case "drop":
				System.out.printf("Vous avez jeté %s.\n",this.getInventory().accessPotionInPocket(promptInt).getName());
				Misc.wait(1000);
				this.getInventory().dropPotion(promptInt);
				return;
			case "exit":
				return;
			default:
				System.out.println("Commande introuvable, Veuillez Réessayer.");
				continue;
			}
		}
	}

	public void showSkills(Scanner scanner) {
		System.out.printf("PV : %d/%d\n",this.getHP(),this.getMaxHP());
		System.out.println("Attaque : "+this.getAttack());
		System.out.println("Défense : "+this.getDefense());
		System.out.println("Vitesse : "+this.getSpeed());
	}
}