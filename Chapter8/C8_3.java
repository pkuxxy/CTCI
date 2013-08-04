import java.util.ArrayList;
import java.util.Set;


public class C8_3 {
	public static ArrayList<ArrayList<Integer>> getAllSubSet1(int index, ArrayList<Integer> set)
	{
		if(null == set)
			return null;
		if(set.size() == index)
		{
			ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
			ret.add(new ArrayList<Integer>());
			return ret;
		}
		ArrayList<ArrayList<Integer>> allSubSets = getAllSubSet1(index + 1, set);
		Integer item = set.get(index);
		ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> subSet : allSubSets)
		{
			ArrayList<Integer> newSubSet = (ArrayList<Integer>)subSet.clone();
			newSubSet.add(item);
			moreSubSets.add(newSubSet);
		}
		allSubSets.addAll(moreSubSets);
		return allSubSets;
	}
	
	public static ArrayList<ArrayList<Integer>> getAllSubSet2(ArrayList<Integer> set)
	{
		if(null == set)
			return null;
		int max = 1 << set.size();
		ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < max; i++)
		{
			ArrayList<Integer> newSubSet = new ArrayList<Integer>();
			int pos = i;
			int index = 0;
			while(pos > 0)
			{
				if((pos & 1) == 1)
					newSubSet.add(set.get(index));
				pos >>= 1;
				index++;
			}
			allSubSets.add(newSubSet);
		}
		return allSubSets;
	}
	public static void main(String[] args)
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < 3; i++)
		{
			array.add(i);
		}
		ArrayList<ArrayList<Integer>> ret = getAllSubSet1(0, array);
		System.out.println("getAllSubSets1 result:");
		printSet(ret);
		System.out.println();
		ret = getAllSubSet2(array);
		System.out.println("getAllSubSets2 result:");
		printSet(ret);
		
	}

	private static void printSet(ArrayList<ArrayList<Integer>> set) {
		for(ArrayList<Integer> s : set)
		{
			System.out.print("(");
			for(Integer i : s)
			{
				System.out.print(i+" ");
			}
			System.out.println(")");
		}
		
	}
}

