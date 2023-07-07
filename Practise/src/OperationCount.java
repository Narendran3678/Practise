import java.util.*;

public class OperationCount 
{
	public static void main(String args[])
	{
		String source="geeks";
		String target="gttmc";
		int output=0;
		List<String> sourceList= new ArrayList<>(Arrays.asList(source.split("")));
		List<String> targetList= new ArrayList<>(Arrays.asList(target.split("")));
	
		if(targetList.size()<sourceList.size())
		{
			output = sourceList.size()-targetList.size();
		}
		for(int i=0;i<sourceList.size();i++)
		{
			String sStr=sourceList.get(i);
			for(int j=0;j<targetList.size();j++)
			{
				String tStr=targetList.get(j);
				if(sStr.trim().equals(tStr))
				{
					sourceList.remove(i);
					targetList.remove(j);
					i=-1;
					break;
				}
			}
		}
		output+=targetList.size();
		System.out.println(output);
		
	}
}
