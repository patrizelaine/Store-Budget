package homework5;

public class Employee extends Person
{
	private String id;			//employee's ID
	private String hireDate;	//employee's hire date
	private int salary;			//employee's weekly salary
	private int total;			//employee's total amount paid
	
	public boolean setId(String ident)
	{
		//checks length
		if(ident.length()<5 || ident.length()>5)
		{
			return false;
		}
		//checks first three indices to see if they're 0-9
		for(int i=0; i<3; i++)
		{
			if(ident.charAt(i)<48 || ident.charAt(i)>57) 
			{
				return false;
			}
		}
		//check the dash
		if(ident.charAt(3)!=45)
		{
			return false;
		}
		//checks to see if last number in ID is a number A-M
		if(ident.charAt(4)<65 || ident.charAt(4)>77)
		{
			return false;
		}
		//else
		//{
			id = ident;
			return true;
		//}
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setHire(String hire)
	{
		hireDate = hire;
	}
	
	public String getHire()
	{
		return hireDate;
	}
	
	public void setSalary(int sal)
	{
		salary = sal;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void setTotal(int tot)
	{
		total = tot;
	}
	
	public double getTotal()
	{
		return total;
	}
	
	public void payEmployee(double s)		//method to pay weekly salary
	{
		total += this.getSalary();
	}
	
	@Override
	public String toString()
	{
		String first = super.toString();
		return first + "\nID Number: " + this.getId() + "\nHire Date: " + this.getHire() + "\nWeekly Salary: " + this.getSalary() + "\nTotal Paid: " + this.getTotal();
	}
}
