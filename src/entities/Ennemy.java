package entities;
public class Ennemy extends Entity {
	private String name;
	private String Description;
	private String Rarity;
	private int MinXPGiven;
	private int MaxXPGiven;
	private boolean isBoss;

	public Ennemy(int hP, int baseAttack, int baseDefense, int baseSpeed, String name, String description,
			String rarity, int minXPGiven, int maxXPGiven, boolean isBoss) {
		super(hP, baseAttack, baseDefense, baseSpeed);
		this.name = name;
		Description = description;
		Rarity = rarity;
		MinXPGiven = minXPGiven;
		MaxXPGiven = maxXPGiven;
		this.isBoss = isBoss;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getRarity() {
		return Rarity;
	}
	public void setRarity(String rarity) {
		Rarity = rarity;
	}
	public int getMinXPGiven() {
		return MinXPGiven;
	}
	public void setMinXPGiven(int minXPGiven) {
		MinXPGiven = minXPGiven;
	}
	public int getMaxXPGiven() {
		return MaxXPGiven;
	}
	public void setMaxXPGiven(int maxXPGiven) {
		MaxXPGiven = maxXPGiven;
	}
	public boolean isBoss() {
		return isBoss;
	}
	public void setBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}

	@Override
	public String toString() {
		return "Ennemy [name=" + name + ", Description=" + Description + ", Rarity=" + Rarity + ", MinXPGiven="
				+ MinXPGiven + ", MaxXPGiven=" + MaxXPGiven + ", isBoss=" + isBoss + "]";
	}	
}
