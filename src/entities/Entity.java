package entities;
public class Entity {
	private int X;
	private int Y;
	private int HP;
	private int Attack;
	private int Defense;
	private int Speed;
	
// Getters
	public int getX(){
		return X;
	}
	
	public int getY(){
		return Y;
	}
	
	public int getHP(){
		return HP;
	}
	
	public int getAttack(){
		return Attack;
	}
	
	public int getDefense(){
		return Defense;
	}
	
	public int getSpeed(){
		return Speed;
	}

// Setters
	public void setX(int X){
		this.X = X;
	}
	
	public void setY(int Y){
		this.Y = Y;
	}
		
	public void setHP(int HP){
		this.HP = HP;
	}

	public void setAttack(int Attack){
		this.Attack = Attack;
	}	
	
	public void setDefense(int defense) {
		Defense = defense;
	}

	public void setSpeed(int speed) {
		Speed = speed;
	}	
}	

