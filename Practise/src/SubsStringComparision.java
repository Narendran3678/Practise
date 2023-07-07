import java.util.*;

public class SubsStringComparision {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();
		//String s ="fsdfsDLJFSJGIHEKHIPEINNNFIGHKkjgksfgjrotyotoyjtkjkLJOIOEHEKHKKDJGKFGJkfjhglfhjtrhkjfkhjnfglhkjflgjhtrljhfljhfgljhfgljhfgljhtrklyjhtrkjhfgkljhfgjhfljhtrljlfjhfgljhfglkjhflyjtljtrlyjhtryjtrtykhrktherktjhtrkyjhkujhtykhtryhrthHKLJHLHRLHTLRHLKHTRLKHLHRLHLKHLKHKLHLKHLHKLHKHJKHKJHKJHJKHKHJKHKHHLHLHLHKHKJHKJKKHKHKHKHKHHKHKHKHKHkhktryhtlhtklhtrkyhtrkyhtrkjyhtrkyhrekthtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkrtkyhtrklyhjrOEOHKDHFksdhfklHLHKHLHKKJHJHKGKLHLHJLJHLHLHLHLHHLHLHLHH";
		//int k=100;
		System.out.println(getSmallestAndLargest(s, k));
		
	}

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "zzzzzzzzzzzzzzz";
		String largest = "";

		for(int i=97;i<123;i++)
		{
			char ch=(char)i;
			String str[]=s.split("");
			for(int j=0;j<str.length-(k-1);j++)
			{
				if(str[j].equals(String.valueOf(ch)))
				{
					if(smallest.compareTo(s.substring(j,j+k))>0)
						smallest =s.substring(j,j+k);
					if(largest.compareTo(s.substring(j,j+k))<0)
						largest =s.substring(j,j+k);
				}
			}
		}		
		
		for(int i=65;i<90;i++)
		{
			char ch=(char)i;
			String str[]=s.split("");
			for(int j=0;j<str.length-(k-1);j++)
			{
				if(str[j].equals(String.valueOf(ch)))
				{
					if(smallest.compareTo(s.substring(j,j+k))>0)
						smallest =s.substring(j,j+k);
					if(largest.compareTo(s.substring(j,j+k))<0)
						largest =s.substring(j,j+k);
				}
			}
		}		
		
		return smallest + "\n" + largest;
	}
}
