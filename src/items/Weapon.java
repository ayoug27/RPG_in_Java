package items;

public class Weapon extends Item{
	private int Attack;

	public Weapon(String name, String rarity, int attack) {
		super(name, rarity);
		Attack = attack;
	}

	public int getAttack() {
		return Attack;
	}

	public void setAttack(int attack) {
		Attack = attack;
	}
	
	@Override
	public String toString() {
		return getName()+ " : \n" + "Attaque : " + this.Attack;
	}
}