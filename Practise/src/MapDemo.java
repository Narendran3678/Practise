import java.util.*;
class Employee implements Comparable {
	private long id=0;
	private String name="";
	private String salary="";
	public Employee(long id,String name,String salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public int compareTo(Object o) {
		Employee emp=(Employee)o;
		if(this.id==emp.id)
			return 0;
		else if(this.id>emp.id)
			return 1;
		else
			return -1;
	}
}
class NameComparator implements Comparator 
{

	@Override
	public int compare(Object o1, Object o2) {
		Employee emp1=(Employee)o1;
		Employee emp2=(Employee)o2;
		return emp1.getName().compareTo(emp2.getName());
	}
	
}
public class MapDemo 
{
	public static void main(String args[])
	{
		//mapDemo();
		//customHashSet();
		customComparator();
	}
	public static void customComparator()
	{
		List<Employee> list=new ArrayList<>();
		Employee emp1=new Employee(3,"Naren1","20000");
		Employee emp2=new Employee(1,"Naren","3000");
		Employee emp3=new Employee(2,"Naren3","30000");
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		Collections.sort(list);
		NameComparator nameComp=new NameComparator();
		//Collections.sort(list,nameComp);
		for(Employee e:list)
		{
			System.out.println(e.getId()+"-"+e.getName());
		}
	}
	public static void customHashSet()
	{
		Employee emp1=new Employee(1,"Naren","20000");
		Employee emp2=new Employee(1,"Naren","20000");
		System.out.println(emp1.hashCode()+"/"+emp2.hashCode()+"-"+emp1.equals(emp2));
	}
	public static void mapDemo()
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("Naren1","Naren1");
		map.put("Naren","Naren");
		map.put("Naren3","Naren3");
		map.put("Naren4","Naren3");
		map.put("Naren2","Naren2");
		
		List<String> keyList=new ArrayList<>();
		List<String> valueList=new ArrayList<>();
		for(Map.Entry<String, String> eMap:map.entrySet())
		{
			if(!keyList.contains(eMap.getKey()))
			{
				keyList.add(eMap.getKey());
			}
			if(!valueList.contains(eMap.getValue()))
			{
				valueList.add(eMap.getValue());
			}
		}
		System.out.println("KeyList...");
		keyList.stream().forEach(System.out::println);
		System.out.println("ValueList...");
		valueList.stream().forEach(System.out::println);
	}

}
