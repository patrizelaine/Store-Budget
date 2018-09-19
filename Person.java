package homework5;

public class Person implements Comparable<Person>
{
	protected String name;		//person's name
	protected String number;		//person's phone number
	protected String email;	//person's email address
	
	@Override
	public int compareTo(Person other)	//overrides compareTo
	{
		int comp = this.getName().compareToIgnoreCase(other.getName());	//compares name to name being compared to
		if(comp==0)
		{
			return 0;
		}
		if(comp<0)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	public void setName(String nam)
	{
		name = nam;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setNumber(String num)
	{
		number = num;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public void setEmail(String ema)
	{
		email = ema;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + this.getName() + "\nNumber: " + this.getNumber() + "\nEmail:" + this.getEmail();
	}
}
