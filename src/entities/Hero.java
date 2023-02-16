package entities;

public class Hero extends Entity {
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
		super(x, y, 10, 1, 1, 1);
		Level = 1;
		XP = 0;
		Attack = 1;
		Defense = 1;
		Speed = 1;
		this.equippedWeapon = null;
		this.equippedArmor = null;
		this.equippedArtefact = null;
		Inventory = new Inventory();
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
	public void setAttack(int attack) {
		Attack = attack;
	}
	public int getDefense() {
		return Defense;
	}
	public void setDefense(int defense) {
		Defense = defense;
	}
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed(int speed) {
		Speed = speed;
	}
	public items.Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	public void setEquippedWeapon(items.Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	public items.Armor getEquippedArmor() {
		return equippedArmor;
	}
	public void setEquippedArmor(items.Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}
	public items.Artefact getEquippedArtefact() {
		return equippedArtefact;
	}
	public void setEquippedArtefact(items.Artefact equippedArtefact) {
		this.equippedArtefact = equippedArtefact;
	}
	public entities.Inventory getInventory() {
		return Inventory;
	}
	public void setInventory(entities.Inventory inventory) {
		Inventory = inventory;
	}
	
	
}
