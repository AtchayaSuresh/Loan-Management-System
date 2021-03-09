package demo;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import utilities.Borrower;
import utilities.Lender;

public class BorrowerDemo {

	public void demo(Lender lender,HashMap<String,String> loginDetails) {
		
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		int borrowerChoice;
		while(true) {
			System.out.println("Enter Choice\n1.Create Borrower Account\n2.View Borrowers Details"
					+ "\n3.Delete Borrower Account\n4.View Transaction Details\n5.Exit");
			
			borrowerChoice=sc.nextInt();
			String borrowerId;
			
			switch(borrowerChoice)
			{
				//Create Borrower
				case 1:
					System.out.println("Enter Borrower Details\nEnter BorrowerName: ");
					
					String borrowerName=sc.next();
					
					System.out.println("Enter Borrower Address: ");
					String borrowerAddress=sc.next();
					
					System.out.println("Enter Borrower Phone Number: ");
					String borrowerPhoneNumber=sc.next();
					//Generate BorrowerId
					int borrowerIntId=rand.nextInt(100000);
					borrowerId = String.format("%05d", borrowerIntId); 
					
					while(loginDetails.containsKey(borrowerId))
					{
						borrowerIntId=rand.nextInt(100000);
						borrowerId = String.format("%05d",borrowerIntId); 
					}
					
					//Create new Borrower Account
					lender.createBorrower(borrowerId,borrowerName,
							borrowerAddress,borrowerPhoneNumber);
					
					System.out.println("Borrower created successfully. The Borrower"
							+ "id is "+borrowerId);
					break;
				case 2:
					//Print the List of Borrower and their balance details
					lender.printBorrower();
					break;
				case 3:
					borrowerId=sc.next();
					
					//delete the borrower if present
					if(lender.deleteBorrower(borrowerId))
						System.out.println("Borrower deleted successfully");
					else
						System.out.println("Borrower not found");
					break;
				case 4:
					
					//View transaction Details of Borrower
					System.out.println("Enter Borrower ID: ");
					
					HashMap<String, Borrower> borrowerList = lender.getBorrowerList();
					
					borrowerId=sc.next();
					
					//Check if the borrower is available
					if(borrowerList.size()==0||!borrowerList.containsKey(borrowerId))
					{	System.out.println("Borrower not available");
						break;
					}
					
					
					TransactionDemo transaction=new TransactionDemo();
					
					//Navigating to borrower details
					Borrower borrower=borrowerList.get(borrowerId);
					
					//Redirecting to the menu in the Transaction
					transaction.demo(borrower);
					break;
				case 5:
					//Exit
					sc.close();
					return;
			}
		}
		

	}

}
