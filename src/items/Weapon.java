package items;

public class Weapon extends Item{
	int Attack;

	public Weapon(int id, String name, String rarity, int attack) {
		super(id, name, rarity);
		Attack = attack;
	}

	public int getAttack() {
		return Attack;
	}

	public void setAttack(int attack) {
		Attack = attack;
	}
}