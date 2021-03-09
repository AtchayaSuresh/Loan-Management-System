package model;

import java.time.LocalDate;

public class TransactionDetail{
	private LocalDate date;
	private String transactionType;
	private int loanAmount;
	private int repaymentAmount;
	
	public TransactionDetail()
	{
		this.date=LocalDate.now();
		this.loanAmount=0;
		this.repaymentAmount=0;
		this.transactionType=null;
	}
	
	public TransactionDetail(String transactionType)
	{
		this.date=LocalDate.now();
		this.loanAmount=0;
		this.repaymentAmount=0;
		this.transactionType=transactionType;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public boolean setTransactionType(String transactionType) {
		if(transactionType==null)
		{
			System.out.println("Invalid Transaction Type");
			return false;
		}
		this.transactionType = transactionType;
		return true;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public boolean setLoanAmount(int loanAmount) {
		if(loanAmount<=0)
		{
			System.out.println("Invalid Loan Amount");
			return false;
		}
		this.loanAmount = loanAmount;
		return true;
	}

	public int getRepaymentAmount() {
		return repaymentAmount;
	}

	public boolean setRepaymentAmount(int repaymentAmount) {
		if(repaymentAmount<=0)
		{
			System.out.println("Invalid Repayment Amount");
			return false;
		}
		this.repaymentAmount = repaymentAmount;
		return true;
	}

	
}
