package com.behavioral.chainofresponsibility;

interface RupeeChain
{
	public void nextChain();
	public void denominateRupee(int rupee);
	public void setRupeeChain(RupeeChain rupeeChain);
	public int getRupee();
}
class Rupees50Denomination implements RupeeChain
{
	private RupeeChain rupeeChain;
	private int rupee;
	@Override
	public void nextChain() {
		rupeeChain.denominateRupee(this.rupee);
	}
	@Override
	public void denominateRupee(int rupee) {
		int dnm = rupee / 50;
		rupee = rupee % 50;
		if(dnm>0)
		{
			System.out.println("Number of 50 Rupee Denomination..."+dnm);
		}
		if(rupee>0)
		{
			this.rupee = rupee;
			nextChain();
		}
	}
	public void setRupeeChain(RupeeChain rupeeChain) {
		this.rupeeChain = rupeeChain;
	}
	public int getRupee() {
		return rupee;
	}
}

class Rupees20Denomination implements RupeeChain
{
	private RupeeChain rupeeChain;
	private int rupee;
	@Override
	public void nextChain() {
		rupeeChain.denominateRupee(rupee);
	}

	@Override
	public void denominateRupee(int rupee) {
		int dnm = rupee / 20;
		rupee =  rupee % 20;
		if(dnm>0)
		{
			System.out.println("Number of 20 Rupee Denomination..."+dnm);
		}
		if(rupee>0)
		{
			this.rupee = rupee;
			nextChain();
		}
	}	
	public void setRupeeChain(RupeeChain rupeeChain) {
		this.rupeeChain = rupeeChain;
	}
	public int getRupee() {
		return rupee;
	}
}
class Rupees10Denomination implements RupeeChain
{
	private RupeeChain rupeeChain;
	private int rupee;
	@Override
	public void nextChain() {
		System.out.println("Changes Left..."+rupee);
		//rupeeChain.denominateRupee(rupee);
	}

	@Override
	public void denominateRupee(int rupee) {
		int dnm = rupee / 10;
		rupee = rupee % 10;
		if(dnm>0)
		{
			System.out.println("Number of 10 Rupee Denomination..."+dnm);
		}
		if(rupee>0)
		{
			this.rupee = rupee;
			nextChain();
		}
	}
	public void setRupeeChain(RupeeChain rupeeChain) {
		this.rupeeChain = rupeeChain;
	}
	public int getRupee() {
		return rupee;
	}
}

/*
* This Pattern sends data to an object and if this data can't used by the object, it will sent to any other object which can make use of
*/
public class ChainOfResponsibilityPattern {
	public static void main(String args[]) {
		RupeeChain chain50 = new Rupees50Denomination();
		RupeeChain chain20 = new Rupees20Denomination();
		RupeeChain chain10 = new Rupees10Denomination();
		
		chain50.setRupeeChain(chain20);
		chain20.setRupeeChain(chain10);		
		chain50.denominateRupee(1023);

	}
}
