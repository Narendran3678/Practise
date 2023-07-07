abstract class AdaptorPattern
{
	public abstract String getDesignPatternType();
}
class SingletonClass extends AdaptorPattern
{
	private static SingletonClass singletonClass;
	private SingletonClass()
	{
		
	}
	public static SingletonClass getInstance()
	{
		if(singletonClass==null)
		{
			singletonClass = new SingletonClass();
		}
		return singletonClass;
	}
	@Override
	public String getDesignPatternType() {
		
		return "Singleton Pattern";
	}
	
}

public class DesignPatternType {

	public static void main(String[] args) 
	{
		singletonPattern();	
		
	}
	public static void singletonPattern()
	{
		AdaptorPattern	 designPattern= SingletonClass.getInstance();
		System.out.println(designPattern.getDesignPatternType());
	}
}
