import java.io.*;

class Result 
{
    public static void staircase(int n) 
    {
    	for(int i=0;i<n;i++)
     	{
     		for(int j=0;j<n;j++)
         	{
         		if(j>=((n-1)-i))
         		{
         			System.out.print("#");
         		}
         		else
         		{
         			System.out.print(" ");
         		}
         	}
     		System.out.println();
     	}
    }
}

public class StairCase {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        Result.staircase(n);
        bufferedReader.close();
    }
}
