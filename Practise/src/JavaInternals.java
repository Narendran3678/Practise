
public class JavaInternals {
	public static void main(String args[])
	{
		String string="String";
		Message msg = new Message("Message");
		System.out.println(msg.getClass().getClassLoader());
		System.out.println(string.getClass().getClassLoader());
		
	}
}
