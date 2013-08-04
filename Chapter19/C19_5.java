class Result
{
	int hits;
	int pseHits;
}
public class C19_5 {

	public static Result getResult(String guess, String solution)
	{
		int solutionMask = 0;
		Result ret = new Result();
		for(int i = 0; i < solution.length(); i++)
		{
			solutionMask |= 1 << (solution.charAt(i) - 'A');
		}
		for(int i = 0; i < guess.length(); i++)
		{
			if(guess.charAt(i) == solution.charAt(i))
				ret.hits++;
			else if((solutionMask & (1<<(guess.charAt(i)-'A'))) != 0)
			{
				ret.pseHits++;
			}
		}
		return ret;
	}

}
