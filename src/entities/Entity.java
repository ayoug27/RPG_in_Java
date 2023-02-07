package entities;
public class Entity {
	private int X;
	private int Y;
	private int HP;
	private int baseAttack;
	private int baseDefense;
	private int baseSpeed;
		
	public Entity(int x, int y, int hP, int baseAttack, int baseDefense, int baseSpeed) {
		super();
		X = x;
		Y = y;
		HP = hP;
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseSpeed = baseSpeed;
	}
	
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getBaseAttack() {
		return baseAttack;
	}
	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}
	public int getBaseDefense() {
		return baseDefense;
	}
	public void setBaseDefense(int baseDefense) {
		this.baseDefense = baseDefense;
	}
	public int getBaseSpeed() {
		return baseSpeed;
	}
	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}
}	

