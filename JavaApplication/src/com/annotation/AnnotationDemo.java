package com.annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class AnnotationDemo 
{
	public static void main(String args[])
	{
		try
		{
			Class<?> dbInstanceClazz = Class.forName("com.annotation.DatabaseInstance");
			if(dbInstanceClazz.isAnnotationPresent(DBType.class))
			{
				System.out.println("@DBType Annotation Present");
				DatabaseInstance dbInstance = (DatabaseInstance) dbInstanceClazz.getDeclaredConstructor().newInstance();
				for(Field field:dbInstance.getClass().getDeclaredFields())
				{
					if(field.isAnnotationPresent(DbUrl.class))
					{
						field.set(dbInstance,"jdbc:mysql://localhost:3306/devdb");
					}

					if(field.isAnnotationPresent(DbUser.class))
					{
						field.set(dbInstance,"root");
					}
					
					if(field.isAnnotationPresent(DbPassword.class))
					{
						field.set(dbInstance,"root");
					}
					if(field.isAnnotationPresent(DbDriver.class)) 
					{
						field.set(dbInstance,new String("com.mysql.cj.jdbc.Driver"));
					}
					System.out.println("@DbUrl, @DbUser, @DbPassword, @DbDriver Set");
				}
				for(Method method:dbInstanceClazz.getMethods())
				{
					if(method.isAnnotationPresent(DbConnection.class))
					{
						System.out.println("@DbConnection Set");
						method.invoke(dbInstance);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
