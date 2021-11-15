import java.util.*;
import java.util.function.Predicate;

public class StreamApi 
{
	public static void main(String[] args) 
	{
		
		List<Integer> list= Arrays.asList(2,1,3,5,4,6);
		list.stream().map(i->i*i).filter((j)->j%2==0).sorted().forEach(System.out::println);
		
		Predicate<String> predicate = (str)->str.startsWith("N");
		List<String> list1= Arrays.asList("Naren","Hello","Nova");
		list1.stream().filter(predicate).map((str)->str+"-").sorted().forEach(System.out::println);
		System.out.println();
		
		List<String> list2= Arrays.asList("Naren","Hello","Nova","Naren");
		list1.stream().distinct().forEach(System.out::println);
		
	}
}
 