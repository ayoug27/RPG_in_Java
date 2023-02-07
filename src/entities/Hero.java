package entities;
import items.*;

public class Hero extends Entity {
	private int Level;
	private int XP;
	private items.Weapon equippedWeapon;
	private items.Armor equippedArmor;
	private entities.Inventory Inventory;
	private boolean drankPotion;
	private Potion potionDrank;
	
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
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	public Armor getEquippedArmor() {
		return equippedArmor;
	}
	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}
	public Inventory getInventory() {
		return Inventory;
	}
	public void setInventory(Inventory inventory) {
		Inventory = inventory;
	}
	public boolean isDrankPotion() {
		return drankPotion;
	}
	public void setDrankPotion(boolean drankPotion) {
		this.drankPotion = drankPotion;
	}
	public Potion getPotionDrank() {
		return potionDrank;
	}
	public void setPotionDrank(Potion potionDrank) {
		this.potionDrank = potionDrank;
	}
}
