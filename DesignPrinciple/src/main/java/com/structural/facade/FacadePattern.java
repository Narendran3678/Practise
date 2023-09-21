package com.structural.facade;

class AccountLogin {
	private String acc_name="naren";
	private String acc_password="naren";
	
	public AccountLogin(String name,String password) throws Exception
	{
		if(! (acc_name.equals(name) && acc_password.equals(password)) )
		{
			throw new Exception("Account Login Failed");
		}
		else
		{
			System.out.println("Account Login Successful Username["+name+"] password["+password+"]");
		}
	}
}

class Fund {
	
	private static double amount =1000;
	
	public boolean isFundAvailable(double cur_amount)
	{
		if(amount>=cur_amount)
		{
			return true;
		}
		return false;
	}
	public double withdraw(double withdraw_amount) throws Exception
	{
		if(isFundAvailable(withdraw_amount))
		{
			amount =  amount - withdraw_amount;
		}
		else
			throw new Exception("Insufficient Fund");
		return amount;
	}
	public double deposit(double deposit_amount)
	{
		amount =  amount + deposit_amount;
		return amount;
	}
}

class BankFacade {
	Fund fund;
	public BankFacade(String name,String password) throws Exception
	{
		new AccountLogin(name,password);
		fund = new Fund();
	}
	public double withdraw(double withdraw_amount) throws Exception
	{
		double amount = fund.withdraw(withdraw_amount);
		System.out.println("After Withdraw Account Balance..."+ amount);
		return amount;
	}
	public double deposit(double deposit_amount)
	{
		double amount = fund.deposit(deposit_amount);
		System.out.println("After Deposit Account Balance..."+ amount);
		return amount;
	}
	
}
/*
 * Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
 */
public class FacadePattern {
	public static void main(String args[]) throws Exception {
		BankFacade facade = new BankFacade("naren","naren");
		facade.withdraw(200);
		facade.deposit(2000);
	}
}
