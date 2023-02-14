package entities;
import items.*;

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
}
