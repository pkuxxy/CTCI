import java.util.HashMap;


public class C19_8 {

	public static HashMap<String, Integer> initFreqMap(String[] book)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String word : book)
		{
			if(!map.containsKey(word))
			{
				map.put(word, 0);
			}
			map.put(word, map.get(word)+1);
		}
		return map;
	}
	public static int getFreq(HashMap<String, Integer> freqMap, String word)
	{
		if(null == freqMap || null == word)
			return -1;
		if(freqMap.containsKey(word))
			return freqMap.get(word);
		return 0;
	}
}
