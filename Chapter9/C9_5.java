
public class C9_5 {
	public static int findString(String[] array, String word, int start, int end)
	{
		if(start > end)
			return -1;
		int mid = (start + end) / 2;
		int noEmpty = mid;
		while(noEmpty <= end && array[noEmpty].equals(""))
		{
			noEmpty++;
		}
		if(noEmpty > end)
			return findString(array, word, start, mid-1);
		if(word.equals(array[noEmpty]))
			return noEmpty;
		else if(word.compareTo(array[noEmpty]) > 0)
			return findString(array, word, noEmpty, end);
		else return findString(array, word, start, mid-1);
	}
	public static void main(String[] args)
	{
		String word = "ball";
		String[] array = {"at",  "",  "",  "",  "ball",  "",  "",  "car",  "",  "",  "dad",  "",  ""};
		System.out.println("The word ball is in the position of: " + findString(array, word, 0, array.length-1));
	}
}
