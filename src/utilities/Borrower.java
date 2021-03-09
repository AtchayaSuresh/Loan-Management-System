package utilities;


import java.util.ArrayList;

import model.TransactionDetail;

public class Borrower {
	private String borrowerId;
	private String borrowerName;
	private String address;
	private String phoneNumber;
	private int balance;
	private  ArrayList<TransactionDetail>transaction=new ArrayList<>();
	
	public Borrower(String borrowerId,String borrowerName,
			String address,String phoneNumber)
	{
		this.borrowerId=borrowerId;
		this.borrowerName=borrowerName;
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.balance=0;
	}
	
	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Borrower() {
		this.balance=0;
	}

	public String getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(String borrowerId) {
		if(borrowerId==null)
			System.out.println("Invalid Borrower ID");
		else
			this.borrowerId = borrowerId;
	}

	public String getborrowerName() {
		return borrowerName;
	}

	public void setborrowerName(String borrowerName) {
		if(borrowerName==null)
			System.out.println("Invalid Borrower Name");
		else
			this.borrowerName = borrowerName;
	}

	public ArrayList<TransactionDetail> getTransaction() {
		return transaction;
	}

	public void setTransaction(ArrayList<TransactionDetail> transaction) {
		this.transaction = transaction;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(balance<0)
			System.out.println("Invalid Balance Amount");
		else
			this.balance = balance;
	}
	
	public void lendingTransaction(int amount)
	{
		TransactionDetail transaction=new TransactionDetail("Lending");
		if(transaction.setLoanAmount(amount))
		{	
			this.setBalance(amount+this.getBalance());
			this.transaction.add(transaction);
		}
	}
	
	public void repaymentTransaction(int amount)
	{
		TransactionDetail transaction=new TransactionDetail("Repayment");
		if(transaction.setRepaymentAmount(amount))
		{
			int balance=this.balance;
			
			if(balance<amount)
			{
				System.out.println("Amount to be repayed is more than amount to be paid");
				System.out.printf("Amount to be paid: %d\n"
						+ "Amount now repayed: %d",balance,amount);
				return;
			}
			else 
			{
				this.setBalance(balance-amount);
				if(balance==amount)
					System.out.println("Amount fully repayed");
				this.transaction.add(transaction);
			}
		}
	}

	public void printTransactionHistory()
	{
		int index=1;
		if(this.transaction.size()==0)
			System.out.println("No Transactions made");
		else 
		{
			System.out.println("Transaction Number  Transaction Type  Amount Borrowed  "
					+ "Amount Repayed Now");
			
			//Print transaction History
			for(TransactionDetail transaction:this.transaction)
			{
				System.out.println(index+"  "+transaction.getTransactionType()+"  "+
			transaction.getLoanAmount()+"  "+transaction.getRepaymentAmount());
				index++;
			}
			System.out.println("Balance Amount to be Repayed: "+this.getBalance());
		}
	}
}
