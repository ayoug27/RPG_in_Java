import entities.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Entity goblin = new Entity(0,0,20,5,2,2);
		System.out.println(goblin.getHP());
		goblin.setHP(19);
		System.out.println(goblin.getHP());
	}

}
