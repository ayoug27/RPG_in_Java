
public class Misc {
	public static int diceRoll(int max, int min)
	{
		return (int)(Math.random() * (max - min + 1) + min);  
	}
	
	public static void gameOver()
	{
		System.out.println("Vous avez perdu tout vos PV ! Vous avez succombé aux ennemis du donjon...");
		System.out.println("GAME OVER");
		System.exit(0);
	}
	
	public static void wait(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
