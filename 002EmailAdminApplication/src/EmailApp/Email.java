package EmailApp;

import java.util.*;

public class Email {
	//declare variables
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int dfltPwLength = 8;
	private String alternateEmail;
	private String companySuffix = "domain.com";
	
	//constructor to receive first name & last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//	System.out.println("Email Created: "+this.firstName+" "+this.lastName);
		
		//call method to ask for department & return
		this.department = setDept();
		//	System.out.println("Department: "+this.department);
		
		//call password generation method
		this.password = rndmPassword(dfltPwLength);
			System.out.println("Your password is: "+this.password);
		
		//generate email
		email = firstName.toLowerCase()+lastName.toLowerCase()+"@"+department+"."+companySuffix;
			//System.out.println("Your email is: "+email);
	}
	
	//ask for department method
	private String setDept() {
		Scanner in;
		int deptChoice= -1;
		while (true) {
		try {	
			System.out.println("\nNew worker: "+ firstName+ ". Enter your department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
			in = new Scanner(System.in);
			deptChoice = in.nextInt();
			if (deptChoice >= 0 && deptChoice <=3) {
				switch(deptChoice)
				{
				case 1:
					in.close();
					return "sales";
										
				case 2:
					in.close();
					return "dev";
					
				case 3:
					in.close();
					return "acct";

				case 0:
					in.close();
					return "";
				}
			}
			System.out.println("Invalid entry. Please enter valid department");
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid entry. Please enter a number.");
			}
		}
		
	}

	//generate random password method
	private String rndmPassword(int length) {
		String pwSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rng = (int) (Math.random()*pwSet.length());
			password[i] = pwSet.charAt(rng);
		}
		return new String(password);
	}
	
	//set mailbox capacity method
	public void setMBCapacity(int capacity) {
		this.mailboxCapacity= capacity;
	}
		
	//set alternate email method
	public void setAltEmail(String altEmail) {
		this.alternateEmail=altEmail;
	}
		
	//change pw method
	public void changePW(String password) {
		this.password = password;
	}

	public int getMBCapacity() {return mailboxCapacity;}
	public String getAltEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " "+lastName +
				"\nCOMPANY EMAIL: "+email+
				"\nMAILBOX CAPACITY: "+mailboxCapacity+"mb";
	}
}	
	
	