package testing;


import static org.junit.Assert.*;
import org.junit.Test;

import utilities.Borrower;

public class TestBorrower {
	Borrower borrower = new Borrower();
	
	@Test
	public void TestSetAndGetMethods() {
		borrower.setBalance(5000);;
		borrower.setBorrowerId("56720");;
		borrower.setborrowerName("Atchaya");
		
		assertEquals(5000,borrower.getBalance());
		assertEquals("56720",borrower.getBorrowerId());
		assertEquals("Atchaya",borrower.getborrowerName());
		
		try {
			borrower.setBalance(0);
			borrower.setBalance(-10);
			borrower.setBorrowerId(null);
			borrower.setborrowerName(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testLendingTransactionMethod() {
		borrower.lendingTransaction(500);
		assertEquals(500, borrower.getBalance());
		borrower.lendingTransaction(500);
		assertEquals(1000, borrower.getBalance());
		
		try {
			borrower.lendingTransaction(0);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	public void testRepaymentTransactionMethod() {
		borrower.repaymentTransaction(500);
		assertEquals(500, borrower.getBalance());
		borrower.repaymentTransaction(500);
		assertEquals(0, borrower.getBalance());
		
		try {
			borrower.repaymentTransaction(0);
			borrower.repaymentTransaction(500);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}

