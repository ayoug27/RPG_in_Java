package entities;

public class Inventory {
	private items.Armor spareArmor;
	private items.Weapon[] weaponsPocket;
	private int itemsInWeaponsPocket;
	private items.Artefact[] artefactsPocket;
	private int itemsInArtefactsPocket;
	private items.Potion[] potionsPocket;
	private int itemsInPotionsPocket;

	public Inventory() {
		spareArmor = null;
		this.weaponsPocket = new items.Weapon[2];
		itemsInWeaponsPocket = 0;
		this.artefactsPocket = new items.Artefact[3];
		itemsInArtefactsPocket = 0;
		this.potionsPocket = new items.Potion[5];
		itemsInPotionsPocket = 0;
	}

	public items.Armor getSpareArmor() {
		return spareArmor;
	}

	public void setSpareArmor(items.Armor spareArmor) {
		this.spareArmor = spareArmor;
	}

	public int getItemsInWeaponsPocket() {
		return itemsInWeaponsPocket;
	}

	public void setItemsInWeaponsPocket(int itemsInWeaponsPocket) {
		this.itemsInWeaponsPocket = itemsInWeaponsPocket;
	}

	public int getItemsInArtefactsPocket() {
		return itemsInArtefactsPocket;
	}

	public void setItemsInArtefactsPocket(int itemsInArtefactsPocket) {
		this.itemsInArtefactsPocket = itemsInArtefactsPocket;
	}

	public int getItemsInPotionsPocket() {
		return itemsInPotionsPocket;
	}

	public void setItemsInPotionsPocket(int itemsInPotionsPocket) {
		this.itemsInPotionsPocket = itemsInPotionsPocket;
	}

	public void addWeaponInPocket(items.Weapon weaponToAdd)
	{
		if (itemsInWeaponsPocket < weaponsPocket.length) {
			this.weaponsPocket[itemsInWeaponsPocket] = weaponToAdd;
			++this.itemsInWeaponsPocket;
		}
		else
			System.err.println("Votre poche est remplie !");
	}
	
	public items.Weapon accessWeaponInPocket(int i) {
		if (i <= itemsInWeaponsPocket)
			return this.weaponsPocket[i-1];
		else {
			System.err.println("Vous n'avez pas d'objet à cet emplacement ! Voici le dernier objet que vous avez récupéré :");
			return this.weaponsPocket[itemsInWeaponsPocket-1];
		}
	}
	
	public void dropWeapon(int i)
	{
		int I = i-1;
		if (i <= itemsInWeaponsPocket || weaponsPocket[I] != null) {
			for (int j = 0; j < itemsInWeaponsPocket-i; ++j) {
				weaponsPocket[I+j] = weaponsPocket[I+j+1];
			}
			weaponsPocket[itemsInWeaponsPocket-1] = null;
			--itemsInWeaponsPocket;
		}
		else 
			System.err.println("Vous n'avez pas d'objet à cet emplacement !");
	}
	
	public void addPotionInPocket(items.Potion potionToAdd)
	{
		if (itemsInPotionsPocket < potionsPocket.length) {
			this.potionsPocket[itemsInPotionsPocket] = potionToAdd;
			++this.itemsInPotionsPocket;
		}
		else
			System.err.println("Votre poche est remplie !");
	}
	
	public items.Potion accessPotionInPocket(int i) {
		if (i <= itemsInPotionsPocket)
			return this.potionsPocket[i-1];
		else {
			System.err.println("Vous n'avez pas d'objet à cet emplacement ! Voici le dernier objet que vous avez récupéré :");
			return this.potionsPocket[itemsInWeaponsPocket-1];
		}
	}
	
	public void dropPotion(int i)
	{
		int I = i-1;
		if (i <= itemsInPotionsPocket || potionsPocket[I] != null) {
			for (int j = 0; j < itemsInPotionsPocket-i; ++j) {
				potionsPocket[I+j] = potionsPocket[I+j+1];
			}
			potionsPocket[itemsInPotionsPocket-1] = null;
			--itemsInPotionsPocket;
		}
		else 
			System.err.println("Vous n'avez pas d'objet à cet emplacement !");
	}
	
	public void addArtefactInPocket(items.Artefact artefactToAdd)
	{
		if (itemsInArtefactsPocket < artefactsPocket.length) {
			this.artefactsPocket[itemsInArtefactsPocket] = artefactToAdd;
			++this.itemsInArtefactsPocket;
		}
		else
			System.err.println("Votre poche est remplie !");
	}
	
	public items.Artefact accessArtefactInPocket(int i) {
		if (i <= itemsInArtefactsPocket)
			return this.artefactsPocket[i-1];
		else {
			System.err.println("Vous n'avez pas d'objet à cet emplacement ! Voici le dernier objet que vous avez récupéré :");
			return this.artefactsPocket[itemsInArtefactsPocket-1];
		}
	}
	
	public void dropArtefact(int i)
	{
		int I = i-1;
		if (i <= itemsInArtefactsPocket || artefactsPocket[I] != null) {
			for (int j = 0; j < itemsInArtefactsPocket-i; ++j) {
				artefactsPocket[I+j] = artefactsPocket[I+j+1];
			}
			artefactsPocket[itemsInArtefactsPocket-1] = null;
			--itemsInArtefactsPocket;
		}
		else 
			System.err.println("Vous n'avez pas d'objet à cet emplacement !");
	}
}
