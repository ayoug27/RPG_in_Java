package entities;
public class Ennemy extends Entity {
	private String Description;
	private String Rarity;
	private int MinXPGiven;
	private int MaxXPGiven;
	
	public Ennemy(int hP, int baseAttack, int baseDefense, int baseSpeed, String description,
			String rarity, int minXPGiven, int maxXPGiven) {
		super(hP, baseAttack, baseDefense, baseSpeed);
		Description = description;
		Rarity = rarity;
		MinXPGiven = minXPGiven;
		MaxXPGiven = maxXPGiven;
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
	
	
}
