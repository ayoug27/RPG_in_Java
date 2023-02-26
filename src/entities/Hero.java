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
		this.equippedWeapon = null;
		this.equippedArmor = null;
		this.equippedArtefact = null;
		Attack = 1;
		Defense = 1;
		Speed = 1;
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
	public void setAttack() {
		int itemAttack = 0;
		if (this.equippedWeapon != null)
			itemAttack += this.equippedWeapon.getAttack();
		if (this.equippedArtefact != null && this.equippedArtefact.getBuffedAbility() == "Attack")
			itemAttack += this.equippedArtefact.getBuffValue();
		Attack = this.getBaseAttack()+itemAttack;	
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
		Defense = this.getBaseDefense()+itemDefense;	
	}
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed() {
		int itemSpeed = 0;
		if (this.equippedArtefact != null && this.equippedArtefact.getBuffedAbility() == "Speed")
			itemSpeed += this.equippedArtefact.getBuffValue();
		Speed = this.getBaseSpeed()+itemSpeed;	
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
	public void equipWeaponFromInventory(int i)
	{
		if (i <= this.getInventory().getItemsInWeaponsPocket()){
			if (this.equippedWeapon == null) {
				this.equippedWeapon = this.getInventory().accessWeaponInPocket(i);
				this.getInventory().dropWeapon(i);
			}
			else {
				items.Weapon actualEquippedWeapon = this.equippedWeapon;
				this.equippedWeapon = this.getInventory().accessWeaponInPocket(i);
				this.getInventory().dropWeapon(i);
				this.getInventory().addWeaponInPocket(actualEquippedWeapon);
			}
		}
		else {
			System.err.println("Vous n'avez pas d'objet a cet endroit !");
			return;
		}
	}	
	public void equipArtefactFromInventory(int i)
	{
		if (i <= this.getInventory().getItemsInArtefactsPocket()){
			if (this.equippedArtefact == null) {
				this.equippedArtefact = this.getInventory().accessArtefactInPocket(i);
				this.getInventory().dropArtefact(i);
			}
			else {
				items.Artefact actualEquippedArtefact = this.equippedArtefact;
				this.equippedArtefact = this.getInventory().accessArtefactInPocket(i);
				this.getInventory().dropArtefact(i);
				this.getInventory().addArtefactInPocket(actualEquippedArtefact);
			}
		}
		else {
			System.err.println("Vous n'avez pas d'objet a cet endroit !");
			return;
		}
	}
	public void equipArmorFromInventory()
	{
		if (this.getInventory().getSpareArmor() != null){
			if (this.equippedArmor == null) {
				this.equippedArmor = this.getInventory().getSpareArmor();
				this.getInventory().setSpareArmor(null);
			}
			else {
				items.Armor actualEquippedArmor = this.equippedArmor;
				this.equippedArmor = this.getInventory().getSpareArmor();
				this.getInventory().setSpareArmor(actualEquippedArmor);
			}
		}
		else {
			System.err.println("Vous n'avez pas d'objet a cet endroit !");
			return;
		}
	}
}
