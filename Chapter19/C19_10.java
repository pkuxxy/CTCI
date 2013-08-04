import java.util.Random;


public class C19_10 {

	public static int rand7()
	{
		int rand = 0;
		do
		{
			rand = 5*rand5() + rand5();
		}while(rand > 21);
		return rand % 7;
	}

	private static int rand5() {
		Random rand = new Random();
		return 1 + rand.nextInt(5);
	}
}
