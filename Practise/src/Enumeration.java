interface EnumTypes
{
	public String alternateType(Days value);
}
enum Days implements EnumTypes
{
	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(7);
	public int dayCount;
	Days(int dayCount)
	{
		this.dayCount=dayCount;
	}
	@Override
	public String alternateType(Days day) 
	{
		enum Alternative
		{
			MONDAY("MON"),
			TUESDAY("TUE"),
			WEDNESDAY("WED"),
			THURSDAY("THU"),
			FRIDAY("FRI"),
			SATURDAY("SAT"),
			SUNDAY("SUN");
			String alternateVal="";
			Alternative(String alternateVal)
			{
				this.alternateVal=alternateVal;
			}
		}
		
		return Alternative.valueOf(day.toString()).alternateVal;
	}
}
public class Enumeration 
{
	public static void main(String args[])
	{
		System.out.println("Enum Values...");
		for(Days d: Days.values())
		{
			System.out.println(d+"-"+d.dayCount+"-"+d.alternateType(d));
		}
		
		//System.out.println(days.enumType());
		
	}
}
