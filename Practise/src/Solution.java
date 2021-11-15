import java.util.*;
import java.util.stream.Collectors;

public class Solution 
{
	public static void main(String args[])
	{
		String higherBound="200";
		List<String> higherBoundArr=new ArrayList<>(Arrays.asList(higherBound.split("")));
		int[] arr= {1,2,3};
		List<Integer> arrList=new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		
		int firstHighBound =Integer.valueOf(higherBoundArr.get(0));
		int lastMax=arr[0];
		int index=0;
		for(int i=0;i<arrList.size();i++)
		{
			if(arrList.get(i)<=firstHighBound && lastMax<=arrList.get(i))
			{
				index=i;
				lastMax =arrList.get(i);
			}
		}
		arrList.remove(index);
		Collections.reverse(arrList);
		arrList.add(0,lastMax);
		System.out.println(arrList);
	}
}