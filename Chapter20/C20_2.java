
public class C20_2 {

	public static void shuffle(int[] cards)
	{
		for(int i = 0; i < cards.length; i++)
		{
			int swapCard = (int)(Math.random()*(cards.length-i)) + i;
			int temp = cards[i];
			cards[i] = cards[swapCard];
			cards[swapCard] = temp;
		}
	}

}
