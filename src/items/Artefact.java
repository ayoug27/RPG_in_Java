package items;

public class Artefact extends Item{
	private String buffedAbility;
	private int buffValue;
	
	public Artefact(int id, String name, String rarity, String buffedAbility, int buffValue) {
		super(id, name, rarity);
		this.buffedAbility = buffedAbility;
		this.buffValue = buffValue;
	}
	
	public String getBuffedAbility() {
		return buffedAbility;
	}
	public void setBuffedAbility(String buffedAbility) {
		this.buffedAbility = buffedAbility;
	}
	public int getBuffValue() {
		return buffValue;
	}
	public void setBuffValue(int buffValue) {
		this.buffValue = buffValue;
	}
	
	@Override
	public String toString() {
		return getName()+ " : \n" + buffedAbility + " : +" + this.buffValue;
	}
}
