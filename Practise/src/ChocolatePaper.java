
public class ChocolatePaper {

	public static void main(String[] args)
	{
		int money =12;
		int unitCost=4;
		int exchangeOffer= 4;
		
		int chocoCount=money/unitCost;
		int chocoPaper=chocoCount;
		while(chocoPaper>=exchangeOffer)
		{
			chocoCount+=(chocoPaper/exchangeOffer);
			chocoPaper-=(chocoPaper/exchangeOffer);
		}
		System.out.println(chocoCount);
	}
}
 