package miscellaneous;

public class Misc {
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREENBACKGROUND = "\u001B[42m"; 
    public static final String ANSI_WHITEBACKGROUND = "\u001B[47m";
    public static final String ANSI_REDBACKGROUND = "\u001B[41m";
    public static final String ANSI_PURPLEBACKGROUND = "\u001B[45m";
    public static final String ANSI_YELLOWBACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUEBACKGROUND = "\u001B[44m";
    public static final String ANSI_SCREENRESET = "\033[H\033[2J";
	
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
	
	public static boolean booleanDiceRoll(int value)
	{
		if ((int)(Math.random()*3 +1) == value)
			return true;
		else
			return false;
	}
}
