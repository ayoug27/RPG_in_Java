package entities;
import items.*;

public class Inventory {
	private items.Armor spareArmor;
	public items.Weapon[] weaponsPocket;
	public items.Artefact[] artefactsPocket; 
	public items.Potion[] potionsPocket;
	
	public Inventory() {
		spareArmor = null;
		this.weaponsPocket = new items.Weapon[2];
		this.artefactsPocket = new items.Artefact[3];
		this.potionsPocket = new items.Potion[5];
	}

	public items.Armor getSpareArmor() {
		return spareArmor;
	}

	public void setSpareArmor(items.Armor spareArmor) {
		this.spareArmor = spareArmor;
	}
}
