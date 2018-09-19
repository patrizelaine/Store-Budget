package homework5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; 

public class Driver 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		double totalStore = 0;	//field of amount of money the store has
		double totalPay = 0;	//total amount store needs to pay employees	
		String input;
		ArrayList<Customer> customer = new ArrayList<>();
		ArrayList<Employee> employee = new ArrayList<>();
		
		do {
				System.out.println("What would you like to do?");
				System.out.println("1. Add a new customer into the system\n2. Add a new preferred customer into the system");
				System.out.println("3. Add a new employee into the system\n4. Change an employee's salary");
				System.out.println("5. Pay all employees\n6. Record purchase for a customer or preferred customer");
				System.out.println("7. Print out all customers\n8. Print out all employees");
				System.out.println("9. Quit");
			
				input = scan.nextLine();
				
			if(input.equals("1"))
			{
				Customer one = new Customer();
				System.out.println("Enter the customer name:");	//customer name
				String userName = scan.nextLine();
				one.setName(userName);
				System.out.println("Enter the customer phone number:");	//customer phone number
				String userNumber = scan.nextLine();
				one.setNumber(userNumber);
				System.out.println("Enter the customer email:");	//customer email
				String userEmail = scan.nextLine();
				one.setEmail(userEmail);
				customer.add(one);
				Collections.sort(customer);
			}
			
			if(input.equals("2"))
			{
				PreferredCustomer p = new PreferredCustomer();
				System.out.println("Enter the preferred customer name:");	//preferred customer name
				String userName = scan.nextLine();
				p.setName(userName);
				System.out.println("Enter the preferred customer phone number:");	//preferred customer phone number
				String userNumber = scan.nextLine();
				p.setNumber(userNumber);
				System.out.println("Enter the preferred customer email:");	//preferred customer email
				String userEmail = scan.nextLine();
				p.setEmail(userEmail);
				customer.add(p);
				Collections.sort(customer);
			}
			
			if(input.equals("3"))
			{
				Employee e = new Employee();
				
				System.out.println("Enter the employee name:");	//employee name
				String userName = scan.nextLine();
				e.setName(userName);
				System.out.println("Enter the employee phone number:");	//employee number
				String userNumber = scan.nextLine();
				e.setNumber(userNumber);
				System.out.println("Enter the employee email:");	//employee email
				String userEmail = scan.nextLine();
				e.setEmail(userEmail);
			
				System.out.println("Enter the employee ID:");	//employee ID
				String userID = scan.nextLine();
				if(e.setId(userID)==false)
				{
					do	//keeps doing this until the userID flag is true
					{
						System.out.println("That is an invalid ID. Try again:");
						userID=scan.nextLine();
					}while(e.setId(userID)==false);
				}
				e.setId(userID);
	
				System.out.println("Enter the employee's hire date:");	//employee hire date
				String userHire = scan.nextLine();
				e.setHire(userHire);
				System.out.println("Enter the employee's salary:");	//employee salary
				int userSalary = scan.nextInt();
				e.setSalary(userSalary);
				System.out.println("Enter the employee's total income:");	//employee total income
				int userTotal = scan.nextInt();
				scan.nextLine();
				e.setTotal(userTotal);
				employee.add(e);
				Collections.sort(employee);
			}
			
			if(input.equals("4"))
			{
				System.out.println("Enter the employee name:");
				String name = scan.nextLine();
				for(Employee s:employee)	//searches for employee name in Employee ArrayList
				{
					if(s.getName().equalsIgnoreCase(name))
					{
						System.out.println("What is the salary change?");
						int newSalary = scan.nextInt();
						s.setSalary(newSalary);
						System.out.println("The new salary is now " + newSalary);
					}
				}
			}
			
			if(input.equals("5"))
			{
				if(totalStore==0)
				{
					System.out.println("Cannot pay employees. Your store doesn't have any money.");
				}
				for(Employee e:employee)	//calculates how much it would be to pay all employees in the Employee ArrayList
				{
					totalPay += e.getSalary();
				}
				
				try {
					validatePay(totalPay, totalStore);	//validates to make sure there is enough money to pay the employees
					if(totalPay<=totalStore)	//if the pay is less than how much money the store has, then they pay
					{
						for(Employee e:employee)
						{
							e.payEmployee(e.getSalary());
						}
					
					totalStore -= totalPay;
					System.out.println("Paid employees successfully!");
					System.out.println("The store now has a total of: $" + totalStore);
					}
					
				}
				catch(IllegalArgumentException e)	//if not, throws exception
				{
					System.out.println("You can't pay your employees.");
					System.out.println("The store has a total of: $" + totalStore);
				}
			}
			
			if(input.equals("6"))		//records purchase
			{
				String name = "";
				double price = 0;
				
				System.out.println("Amount of purchase: ");
				price = scan.nextInt();
				scan.nextLine();
				totalStore += price;
				System.out.println("Name of customer: ");
				name = scan.nextLine();
				
				for(Customer c: customer)
				{
					if(c.getName().equalsIgnoreCase(name))
					{
						c.makePurchase(price);
					}
				}
			}
			
			if(input.equals("7"))	//prints out all Customers
			{
				for(int i=0; i<customer.size(); i++)
				{
					System.out.println(customer.get(i));
				}
			}
			
			if(input.equals("8"))	//prints out all Employees
			{
				for(int i=0; i<employee.size(); i++)
				{
					System.out.println(employee.get(i));
				}
			}
			
			if(input.equals("9"))
			{
				System.out.println("Quitting program.");
			}
			}while((input.equals("1"))||(input.equals("2"))||(input.equals("3"))||(input.equals("4"))||(input.equals("5"))||(input.equals("6"))||(input.equals("7"))||(input.equals("8")));
	}
	
	public static void validatePay(double a, double b)
	{
		if(a>b)
		{
			throw new IllegalArgumentException("You don't have enough money to pay your employees.");
		}
	}
}
