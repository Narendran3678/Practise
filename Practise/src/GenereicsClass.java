import java.util.*;

class GenColc<T>
{
	T obj;
	public void add(T obj)
	{
		this.obj=obj;
	}
	T get()
	{
		return obj;
	}
	static <T> Collection<T> arrayConversion(T[] value1, Collection<T> value2)
	{
		for(T val:value1) {
			value2.add(val);
		}
		return value2;
	}
	static <T> T getValue()
	{
		return (T)"5";
	}
	void getValue(List<T> value)
	{
		System.out.println(value);
	}
}

public class GenereicsClass 
{
	
	public static void main(String args[])
	{
		GenColc gen=new GenColc();
		gen.add("1");
		gen.add(2);
		System.out.println(gen.get());
		
		List<Integer> list= new ArrayList<>();
		Integer[] arr= {1,2,3,4};
		gen.arrayConversion(arr,list);
	
		list.stream().forEach(System.out::println);
		
		GenColc<String> gen1=new GenColc<String>();
		List<String> list1= new ArrayList<>();
		String[] arr1= {"1","2","3","4"};
		gen1.arrayConversion(arr1,list1);
	
		list1.stream().forEach(System.out::println);
		
		
		Set<String> list2= new HashSet<>();
		String[] arr2= {"1","2","3","4","4"};
		gen1.arrayConversion(arr2,list2);
		list2.stream().forEach(System.out::println);
		
		int s=gen.getValue();
		System.out.println(s);
		List l=Arrays.asList(1,2,3,4);
		gen.getValue(l);
	}
}
