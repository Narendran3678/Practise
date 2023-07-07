import java.util.*;
public class CurlyBraces
{
	public static void main(String []arg)
	{
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) 
		{
			
			String input=sc.next();  
			//String input="{}()))(()()({}}{}";
			int flag=0;
			char str[]=input.toCharArray();
			
			Stack<Character> stack = new Stack<Character>();
			
			for(int i=0;i<str.length;i++)
			{
				char c= str[i];
				
				if(c=='{' || c=='[' || c=='(')
				{
					stack.push(str[i]);
				}	
				else if(c==']')
				{
					if(stack.empty())
					{
						System.out.println("false");
						flag=1;
						break;
					}
					if( !stack.empty() && stack.peek()=='[' )
					{
						stack.pop();
					}

				}	
				else if(c==')')
				{
					if(stack.empty())
					{
						flag=1;
						System.out.println("false");
						break;
					}
					if( !stack.empty() && stack.peek()=='(' )
					{
						stack.pop();
					}
				}	
				else if(c=='}')
				{
					if(stack.empty())
					{
						flag=1;
						System.out.println("false");
						break;
					}
					if(!stack.empty() && stack.peek()=='{' )
					{
						stack.pop();
					}
				}	
			}
			if(flag==0)
			{
				if(stack.size()==0)
				{
					System.out.println("true");
				}
				else
				{
					System.out.println("false");
				}
			}
		}
	}
}



