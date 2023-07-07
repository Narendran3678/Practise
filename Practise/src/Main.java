
import java.util.*;
import java.io.*;

public class Main { 
    public static Map<String,Integer> processData(ArrayList<String> array) {
  
       Map<String,Integer> retVal = new HashMap<String,Integer>();
       Set<String> constituencySet =new HashSet<String>();
       for(int i=0;i<array.size();i++)
       {
    	   String[] str= array.get(i).split(",");
    	   constituencySet.add(str[2].trim());
       }
       Iterator<String> itr= constituencySet.iterator();
	   while(itr.hasNext())
	   {
		   String cons="";
		   int constId=0;
		   List<String> list= new ArrayList<>();
		   String constituency=itr.next();
	       for(int i=0;i<array.size();i++)
	       {   
	    	   String[] str= array.get(i).split(",");
    		   if(constituency.trim().equals(str[2].trim()))
    		   {
    			   list.add(array.get(i));
    		   }
    	   }
	       int max=0; 
	       for(int i=0;i<list.size();i++)
	       {
	    	   
	    	   String[] str= list.get(i).split(",");
	    	   if(Integer.valueOf(str[3].trim())>max)
	    	   {
	    		   cons=str[2];
	    		   constId=Integer.valueOf(str[0].trim());
	    		   max =Integer.valueOf(str[3].trim());
	    	   }
	       }
	       retVal.put(cons, constId);
    	   
       }
       return retVal;
    }
    static boolean isAnagram(String a, String b) {
        char[] ach=a.toLowerCase().toCharArray();
        char[] bch=b.toLowerCase().toCharArray();
        java.util.Arrays.sort(ach);
        java.util.Arrays.sort(bch);
        if(String.valueOf(ach).equals(String.valueOf(bch)))
        	return true;
        else
        	return false;
    }
    static void StringToken()
    {
    	String str="He is a very very good boy, isn't he?";
    	String strArr[]=str.split("\\s");
    	System.out.println(Arrays.toString(strArr));
    }
    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        StringToken();
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            
            Map<String,Integer> retVal = processData(inputData);
            
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
