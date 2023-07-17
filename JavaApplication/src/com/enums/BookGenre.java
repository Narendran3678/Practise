package com.enums;

interface TestEnum1 
{
	public void testIntfMethod();
}
enum TestEnum implements TestEnum1
{
	TESTENUM1,
	TESTENUM2,
	TESTENUM3;
	TestEnum()
	{
		System.out.println(this.toString());
	}
	@Override
	public void testIntfMethod() {
		System.out.println("Overrided Test Method");
	}
}
public enum BookGenre 
{
	HORROR(100)
	{
		public int kidFriendlyLimit()
		{
			return 18;
		}
	},
	COMEDY(101)
	{
		public int kidFriendlyLimit()
		{
			return 15;
		}
	};
	abstract int kidFriendlyLimit();
	public enum BookSubGenre
	{
		HORROR_THRILL,
		COMEDY_COMMERICAL;
	}
	private int genreId=0;
	
	BookGenre(int genreId) {
		this.genreId=genreId;
	}	

	
	public int getGenreId() {
		return genreId;
	}
	public static void main(String args[]) throws CloneNotSupportedException
	{
		TestEnum.TESTENUM1.testIntfMethod();
		System.out.println( BookGenre.BookSubGenre.COMEDY_COMMERICAL);
		
		for(BookSubGenre bg:BookSubGenre.values())
		{
			System.out.print(bg.ordinal()+" ");
			System.out.print(bg.name()+" ");
			System.out.print(bg.getDeclaringClass()+" ");
			System.out.print(bg.hashCode()+" ");
			System.out.println();
		}
		for(BookGenre bg:BookGenre.values())
		{
			System.out.print(bg.ordinal()+" ");
			System.out.print(bg.getGenreId()+" ");
			System.out.print(bg.name()+" ");
			System.out.print(bg.kidFriendlyLimit()+" ");
			System.out.print(bg.getDeclaringClass()+" ");
			System.out.print(bg.hashCode()+" ");
			System.out.println();
		}	
	}
}
