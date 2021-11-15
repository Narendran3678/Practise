
final class EmployeeDemo
{
	private int id;
	private String name;
	public EmployeeDemo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "EmployeeDemo [id=" + id + ", name=" + name + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
public class ImmutableClass {
	public static void main(String args[]) throws CloneNotSupportedException
	{
		EmployeeDemo demo=new EmployeeDemo(1,"Naren");
	}
}	
