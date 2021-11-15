import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable
{
	private final long serialVersionUID=1L;
	transient int id;
	String name;
	static String value;
	double percentage;
	public Student(int id, String name, double percentage) {
		super();
		this.id = id;
		this.name = name;
		this.percentage = percentage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public static String getValue() {
		return value;
	}
	public static void setValue(String value) {
		Student.value = value;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", percentage=" + percentage + "]";
	}
	
	
}
public class Serialization {
	static String fileName="Student.ser";
	public static void main(String[] args)  {
		//serializationCall();
		deSerializationCall();
		
	}
	public static void deSerializationCall()
	{
		ObjectInputStream objectInputStream = null;
		try
		{
			objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
			Student student = (Student) objectInputStream.readObject();
			System.out.println(student +"-"+student.getValue());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(objectInputStream!=null)
				{
					objectInputStream.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void serializationCall()
	{
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try
		{
			Student student= new Student(1,"Naren",72.90);
			Student.value="Test";
			fileOutputStream = new FileOutputStream(fileName);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(student);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(objectOutputStream!=null)
				{
					objectOutputStream.flush();
					objectOutputStream.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
