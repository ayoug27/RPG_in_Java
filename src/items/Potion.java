package items;

public class Potion extends Item{
	private int healthValue;

	
	public Potion(int id, String name, String rarity, int healthValue) {
		super(id, name, rarity);
		this.healthValue = healthValue;
	}

	public int getHealthValue() {
		return healthValue;
	}

	public void setHealthValue(int healthValue) {
		this.healthValue = healthValue;
	}

	@Override
	public String toString() {
		return getName()+ " : \n" + "Vie : " + healthValue;
	}

	
}
