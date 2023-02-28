import java.util.*;  
import java.io.*;  
import java.lang.*;
import miscellaneous.*;

public class Dungeon {
	public static Tile[][] Dungeon = generateDungeon("res/dungeon");
	public static entities.Hero Hero = new entities.Hero(7,1);
	
	public static Tile[][] generateDungeon(String filename) {
		char[][] dungeon = new char[23][23];
		File file = new File(filename);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String line;
		int j = 0;
		try {
			while((line = br.readLine()) != null){
				for (int i = 0; i < dungeon[j].length ; ++i)
					dungeon[j][i] = line.charAt(i);
				++j;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Tile[][] dungeonTile = new Tile[23][23];
		for (int y = 0; y < dungeonTile.length; ++y) {
			for (int x = 0;x < dungeonTile[y].length; ++x) {
				if (dungeon[y][x] == 'X')
					dungeonTile[y][x] = new Tile(false, false, false, "Common");
				else if (dungeon[y][x] == 'P')
					dungeonTile[y][x] = new Tile(true, false, true, "Common");
				else if (dungeon[y][x] == 'c')
					dungeonTile[y][x] = new Tile(true, true, false, "Common");
				else if (dungeon[y][x] == 'C')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), true, "Common");
				else if (dungeon[y][x] == 'u')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), false, "Uncommon");
				else if (dungeon[y][x] == 'U')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), true, "Uncommon");
				else if (dungeon[y][x] == 'r')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), false, "Rare");
				else if (dungeon[y][x] == 'R')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), true, "Rare");
				else if (dungeon[y][x] == 'e')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), false, "Epic");
				else if (dungeon[y][x] == 'E')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), true, "Epic");
				else if (dungeon[y][x] == 'l')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), false, "Legendary");
				else if (dungeon[y][x] == 'L')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), true, "Legendary");
				else if (dungeon[y][x] == 'm')
					dungeonTile[y][x] = new Tile(true, Misc.booleanDiceRoll(1), false, "Mythic");
				else if (dungeon[y][x] == 'M')
					dungeonTile[y][x] = new Tile(true, false, true, "Mythic");
				else if (dungeon[y][x] == 'B')
					dungeonTile[y][x] = new Tile(true, true, false, "Mythic");
			}
		}
		return dungeonTile;
	}

	public static void heroMoveUp()
	{
		if (Dungeon[Hero.getY()+1][Hero.getX()].isAccessible)
				Hero.setY(Hero.getY()+1);
		else
			System.out.println("Vous ne pouvez pas aller ici !");
	}
	
	public static void heroMoveDown()
	{
		if (Dungeon[Hero.getY()-1][Hero.getX()].isAccessible)
				Hero.setY(Hero.getY()-1);
		else
			System.out.println("Vous ne pouvez pas aller ici !");
	}
	
	public static void heroMoveLeft()
	{
		if (Dungeon[Hero.getY()][Hero.getX()-1].isAccessible)
				Hero.setX(Hero.getX()-1);
		else
			System.out.println("Vous ne pouvez pas aller ici !");
	}
	
	public static void heroMoveRight()
	{
		if (Dungeon[Hero.getY()][Hero.getX()+1].isAccessible)
				Hero.setX(Hero.getX()+1);
		else
			System.out.println("Vous ne pouvez pas aller ici !");
	}

	public static void openGame(Scanner scanner) {
		while (true) {
			System.out.println("----------------------------------");
			if (Dungeon[Hero.getY()][Hero.getX()].hasEnnemy) {
				System.out.println("Il y a un ennemi !");
				Dungeon[Hero.getY()][Hero.getX()].fight = new Fight(Hero,Dungeon[Hero.getY()][Hero.getX()].ennemy, false);
				Dungeon[Hero.getY()][Hero.getX()].fight.showFight(scanner);
				continue;
			}
			else {
				System.out.println("Que voulez-vous faire ?");
				if (Dungeon[Hero.getY()][Hero.getX()].hasChest)
					System.out.println("Il y a un coffre.");
				System.out.println("up; down; left; right; openChest; map ; inventory");
				String prompt = scanner.nextLine();
				switch (prompt) {
				case "up":
					heroMoveUp(); continue;
				case "down":
					heroMoveDown(); continue;
				case "left":
					heroMoveLeft(); continue;
				case "right":
					heroMoveRight(); continue;
				case "openChest":
					if (Dungeon[Hero.getY()][Hero.getX()].hasChest)
						openChest(scanner);
					else
						System.out.println("Il n'y a pas de coffre ici.");
					continue;
				case "map":
					openMap(); continue;
				case "inventory":
					Hero.showInventory(scanner);
				}
			}
		}
	}

	public static void openMap()
	{
		for (int Y = 0; Y < Dungeon.length; ++Y) {
			for (int X = 0; X < Dungeon[Y].length; ++X) {
				if(X == Hero.getX() && Y == Hero.getY()) {
					System.out.print('P'); continue;}
				if (Dungeon[Y][X].isAccessible) {
					System.out.print(' '); continue;}
				else {
					System.out.print('X'); continue;}
				
			}
			System.out.print('\n');
		}
		return;
	}
	
    public static void openChest(Scanner scanner)
    {
    	while (true) {
			System.out.println("----------------------------------");
			for (int numberOfItems = 1; numberOfItems <= Dungeon[Hero.getY()][Hero.getX()].Chest.length; ++numberOfItems) {
				System.out.printf("%d : %s\n", numberOfItems,Dungeon[Hero.getY()][Hero.getX()].Chest[numberOfItems-1].getName());
			}
			System.out.println("Choisissez l'objet (numéro) que vous souhaitez prendre ou tapez exit.");
			String prompt = scanner.nextLine();
			switch (prompt) {
			case "exit" :
				return;
			default :
			int promptInt = Integer.parseInt(prompt);
			if (promptInt < Dungeon[Hero.getY()][Hero.getX()].Chest.length) {
				if (Dungeon[Hero.getY()][Hero.getX()].Chest[promptInt-1] instanceof items.Weapon && Hero.getInventory().getItemsInWeaponsPocket() <= Hero.getInventory().weaponsPocket.length) {
					Hero.getInventory().addWeaponInPocket((items.Weapon) Dungeon[Hero.getY()][Hero.getX()].Chest[promptInt-1]);
					Dungeon[Hero.getY()][Hero.getX()].removeFromChest(promptInt);
				}
				else if (Dungeon[Hero.getY()][Hero.getX()].Chest[promptInt-1] instanceof items.Potion && Hero.getInventory().getItemsInPotionsPocket() <= Hero.getInventory().potionsPocket.length) {
					Hero.getInventory().addPotionInPocket((items.Potion) Dungeon[Hero.getY()][Hero.getX()].Chest[promptInt-1]);
					Dungeon[Hero.getY()][Hero.getX()].removeFromChest(promptInt);
				}
				else if (Dungeon[Hero.getY()][Hero.getX()].Chest[promptInt-1] instanceof items.Artefact && Hero.getInventory().getItemsInArtefactsPocket() <= Hero.getInventory().potionsPocket.length) {
					Hero.getInventory().addArtefactInPocket((items.Artefact) Dungeon[Hero.getY()][Hero.getX()].Chest[promptInt-1]);
					Dungeon[Hero.getY()][Hero.getX()].removeFromChest(promptInt);
				}
				else if (Dungeon[Hero.getY()][Hero.getX()].Chest[promptInt-1] instanceof items.Armor && Hero.getInventory().getSpareArmor() == null) {
					Hero.getInventory().setSpareArmor((items.Armor) Dungeon[Hero.getY()][Hero.getX()].Chest[promptInt-1]);
					Dungeon[Hero.getY()][Hero.getX()].removeFromChest(promptInt);
				}
				else {
					System.out.println("Trop de place dans votre inventaire"); continue;
				}
			}
				
			}
		}
    }
}
