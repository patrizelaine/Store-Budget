package homework5;

public class PreferredCustomer extends Customer
{

	@Override
	public void makePurchase(double amt)
	{
		double total = this.getAmountSpent();	//sets total amount the customer has spent at the store
		double disc = amt;	//sets discount amount equal to the amount the customer will now be paying
		if(total>2000)
		{
			disc=amt*0.9;
		}
		else if(total>1500)
		{
			disc = amt*0.93;
		}
		else if(amt>1000)
		{
			disc = amt*0.94;
		}
		else if(total>500)
		{
			disc = amt*0.95;
		}
		purchases.add(disc);	//adds the discounted purchase to the purchases ArrayList
		System.out.println("Purchase successful.");	
	}
	
	@Override
	public String toString()
	{
		String first = super.toString();
		return "Preferred Customer:\n" + first;
	}
}
