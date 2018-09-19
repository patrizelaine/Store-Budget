package homework5;

import java.util.ArrayList;

public class Customer extends Person
{
	protected double spent;		//running total of total amount spent
	protected ArrayList<Double> purchases = new ArrayList<>();	//ArrayList of purchases of the curstomer
	
	public void setAmountSpent(double spe)
	{
		spent = spe;
	}
	
	public double getAmountSpent()
	{
		for(double s:purchases)
		{
			spent += s;	//increments total amount spent by their current purchase
		}
		return spent;
	}

	public void makePurchase(double amt)	//adds purchase to the purchases ArrayList
	{
		purchases.add(amt);
		System.out.println("Purchase successful");
	}
	
	@Override
	public String toString()
	{
		String first = super.toString();
		return first + "\nTotal Amount Spent: " + this.getAmountSpent();
	}
}
