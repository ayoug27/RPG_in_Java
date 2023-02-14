package items;

public class Armor extends Item{
	private int Defense;

	public Armor(int id, String name, String rarity, int defense) {
		super(id, name, rarity);
		Defense = defense;
	}
	
	public int getDefense() {
		return Defense;
	}

	public void setDefense(int defense) {
		Defense = defense;
	}

	@Override
	public String toString() {
		return getName()+ " : \n" + "Defense : " + this.Defense;
	}
}
