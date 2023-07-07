import java.util.*;

public class TestCollection {
	public static void main(String args[]) {
		testHashMap();

	}

	public static void testHashMap() {
		Map subMap = new HashMap<Integer, String>();
		subMap.put(1231, "Amit");
		subMap.put(21, "Rahul");
		subMap.put(33, "Vijay");

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "Sam");
		map.put(4, "Naren");
		map.put(3, "John1");
		map.put(5, "John2");
		map.put(6, "John3");
		
		/*
		 * Set<Map.Entry<Integer, String>> mapEntry = map.entrySet(); for
		 * (Map.Entry<Integer, String> m : mapEntry) { System.out.println(m.getKey() +
		 * "-" + m.getValue()); }
		 */
		map.putAll(subMap);

		System.out.println();
		for (Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() + "-" + m.getValue());
		}
		/*
		 * System.out.println("List of Keys"); for (int m : map.keySet()) {
		 * System.out.println(m); }
		 */
		map= Collections.synchronizedMap(map);
		sortHashMap(map);
	}

	public static void sortHashMap(Map<Integer, String> map) {
		
		System.out.println("After Sorting Method 1 "); 
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(map);
		for (Map.Entry<Integer, String> m : treeMap.entrySet()) {
			System.out.println(m.getKey() + "-" + m.getValue());
		}
		
		System.out.println("After Sorting Method 2 ");
		List<Map.Entry<Integer, String>> listMap = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());
		System.out.println(listMap);
		/*Collections.sort(listMap, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				
				return  ((Comparable)((Map.Entry)o1).getValue()).compareTo(((Map.Entry)o2).getValue());
			}

		});*/
		Collections.sort(listMap,new ValueComparator());
		for(Map.Entry<Integer,String> me:listMap)
		{
			System.out.println(me.getKey()+"-"+me.getValue());
		}
	}

}
class ValueComparator implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {
		
		return   ((Comparable)((Map.Entry)o1).getValue()).compareTo(((Map.Entry)o2).getValue());
	}

	
}