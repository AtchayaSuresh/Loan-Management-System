package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import utilities.Borrower;
import utilities.Lender;

public class TestLender {
Lender lender = new Lender("12345","Atchaya");
	
	@Test
	public void TestSetAndGetMethods() {
		lender.setLenderId("56720");
		lender.setLenderName("Atchaya");
	
		assertEquals("56720",lender.getLenderId());
		assertEquals("Atchaya",lender.getLenderName());
		
		try {
			lender.setLenderId(null);
			lender.setLenderName(null);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testCreateBorrowerMethod() {
		Borrower borrower=new Borrower("12344","Atchaya","Flat-D","9444711292");
		
		lender.createBorrower("12344","Atchaya","Flat-D","9444711292");
		
		assertEquals(true,lender.getBorrowerList().containsKey("12344")&&
				lender.getBorrowerList().get("12344").equals(borrower));
		assertEquals("Atchaya",lender.getLenderName());
		
		try {
			lender.setLenderId(null);
			lender.setLenderName(null);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testDeleteBorrowerMethod() {
		lender.deleteBorrower("12344");
		
		assertEquals(false,lender.getBorrowerList().containsKey("12344"));
		
		try {
			lender.deleteBorrower(null);
			lender.deleteBorrower("12333");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}
