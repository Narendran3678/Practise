
public class Mail 
{
	public static void main(String args[])
	{
		String str="narendran@yahoo.com";
		
		String strArr[]= str.split("@");
		String userMail= strArr[0];
		String mail	   = strArr[1]; 
		System.out.println(userMail+"-"+mail);
		String userMailArr[]= userMail.split("");
		if(userMailArr.length>1)
		{
			for(int i=1;i<userMailArr.length-2;i++)
			{
				userMailArr[i]="*";
			}
		}
		String mailArr[]= mail.split("");
		for(int i=1;i<mailArr.length-1;i++)
		{
			if(mailArr[i].equals("."))
				break;
			else
				mailArr[i]="*";
		}
		
		String finalValue="";
		for(int i=0;i<userMailArr.length-1;i++)
		{
			finalValue+=userMailArr[i];
		}
		finalValue+="@";
		for(int i=0;i<mailArr.length;i++)
		{
			finalValue+=mailArr[i];
		}
		System.out.println(finalValue);
	}
}
