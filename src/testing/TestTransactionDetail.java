package testing;


import static org.junit.Assert.*;
import org.junit.Test;

import model.TransactionDetail;
public class TestTransactionDetail {
	TransactionDetail transaction = new TransactionDetail();
	
	@Test
	public void TestSetAndGetMethods() {
		transaction.setLoanAmount(122);
		transaction.setRepaymentAmount(500);
		transaction.setTransactionType("Lending");
		
		assertEquals(122,transaction.getLoanAmount());
		assertEquals(500,transaction.getRepaymentAmount());
		assertEquals("Lending",transaction.getTransactionType());
		
		try {
			transaction.setLoanAmount(0);
			transaction.setRepaymentAmount(0);
			transaction.setTransactionType(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

