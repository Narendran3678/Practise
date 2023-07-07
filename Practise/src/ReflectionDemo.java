import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TestClass
{
	private String str;
	public int num;
	public TestClass()
	{
		System.out.println("Default Constructor....");
	}
	public TestClass(int num,String str)
	{
		this.num=num;
		this.str=str;
		System.out.println("Parameterized Constructor....["+num+"] str["+str+"]");
	}
	public void method()
	{
		System.out.println("Method num["+num+"] str["+str+"]");
	}
	private void method(int num)
	{
		this.num=num;
		System.out.println("Number Alone set["+num+"]");
	}
	private void method(int num,String str)
	{
		this.num=num;
		this.str=str;
		System.out.println("Number and String set num["+num+"] str["+str+"]");
	}
	
	private String method2(int num,String str)
	{
		return num+str;
	}
}
public class ReflectionDemo {

	public static void main(String[] args)  
	{
		reflection1();
		//reflection2();
	}
	public static void reflection2()
	{
		try
		{
			Class cls=  Class.forName("	");
			Constructor[] cons= cls.getConstructors();
			System.out.println("List Of Constructor....");
			for(Constructor c:cons)
			{
				System.out.println(c.getName()+"-"+c.getParameterCount());
			}
			Class[] type= {int.class,String.class}; 
			Constructor constructor =  cls.getConstructor(type);
			TestClass tc = (TestClass) constructor.newInstance(1,"Naren");
			
			Method m1= cls.getDeclaredMethod("method");
			m1.invoke(tc);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void reflection1()
	{
		try
		{
			TestClass tc=new TestClass();
			Class cls= tc.getClass();
			Constructor[] cons= cls.getConstructors();
			System.out.println("List Of Constructor....");
			for(Constructor c:cons)
			{
				System.out.println(c.getName()+"-"+c.getParameterCount());
			}
			Constructor constructor= cls.getConstructor();
			constructor.newInstance();
			
			Constructor constructor1= cls.getConstructor(int.class,String.class);
			tc = (TestClass) constructor1.newInstance(1,"Tom");
			
			Method[] listOfMethod = cls.getDeclaredMethods();
			System.out.println("List Of Method....");
			for(Method m:listOfMethod)
			{
				System.out.println(m.getName()+"-"+m.getParameterCount());
			}
			Method m1= cls.getDeclaredMethod("method");
			m1.invoke(tc);
			
			m1= cls.getDeclaredMethod("method", int.class,String.class);
			m1.setAccessible(true);
			m1.invoke(tc, 2,"Naren");
			
			m1= cls.getDeclaredMethod("method2", int.class,String.class);
			m1.setAccessible(true);
			System.out.println(m1.invoke(tc, 2,"Naren"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
