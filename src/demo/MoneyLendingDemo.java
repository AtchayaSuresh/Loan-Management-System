package demo;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import utilities.Lender;

import businessLogic.RegistrationValidation;
import businessLogic.ValidateLender;

public class MoneyLendingDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		System.out.println("Welcome to Money Lending Management System");
		
		//Store Registration Details
		HashMap<String,String> registrationDetails=new HashMap<>();
		
		//Store Login Details
		HashMap<String,String> loginDetails=new HashMap<>();
		
		//List of the Lenders (LenderId, Lender)
		HashMap<String,Lender> lenderList=new HashMap<>();
		
		
		int lenderIntId;
		String emailId,password,confirmPassword;
		String lenderId;
		
		while(true){
			System.out.println("Enter\n1.Login\n2.SignUp\n3.Exit");
			
			int choice=sc.nextInt();
			
			//Login
			if(choice==1)
			{
				System.out.println("Enter Login Details\nEnter lenderIntId: ");
				lenderId=sc.next();
				System.out.println("Enter password: ");
				password=sc.next();
				
				ValidateLender validateLender=new ValidateLender();
				
				//Checking if lender is already registered
				if(validateLender.validate(lenderId,password,loginDetails))
				{
					System.out.println("Sign In Successful");
					
					//Getting details of lender account
					Lender lender=lenderList.get(lenderId);
					
					//Redirecting to borrowers details
					BorrowerDemo borrowerDemo=new BorrowerDemo();
					borrowerDemo.demo(lender,loginDetails);
				}
	
			}
			//SignUp
			else if(choice==2)
			{
				System.out.println("Enter SignUp Details\nEnter Email: ");
	
				emailId=sc.next();
				
				//Check if emailId is unique
				if(registrationDetails.containsKey(emailId))
					System.out.println("emailId already exists");
				
				System.out.println("Enter password: ");
				password=sc.next();
				System.out.println("Confirm password: ");
				confirmPassword=sc.next();
				
				RegistrationValidation registerValidate=
						new RegistrationValidation();
				
				//Check if the registration details are valid 
				if(registerValidate.checkUserDetails(emailId, password, confirmPassword))
				{
					//Register the new Lender
					registrationDetails.put(emailId,password);
					
					//Generate Lender Id
					lenderIntId=rand.nextInt(100000);
					lenderId = String.format("%05d", lenderIntId); 
					
					while(loginDetails.containsKey(lenderId))
					{
						lenderIntId=rand.nextInt(100000);
						lenderId = String.format("%05d", lenderIntId); 
					}
					
					//Create account for new Lender
					loginDetails.put(lenderId, password);
					lenderList.put(lenderId,new Lender(lenderId,emailId));
					System.out.println("Signup Successful. Your LenderID is "+lenderId);
				}
				
			}
			//Exit
			else if(choice==3)
			{
				sc.close();
				return;
			}
			else
				System.out.println("Invalid Choice");
		}
	}

}
