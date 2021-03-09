package testing;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import businessLogic.ValidateLender;

public class TestValidateLender {
	ValidateLender vu = new ValidateLender();
	
	HashMap<String,String> testLender=new HashMap<>();
	
	@Test
	public void testValidate() {
		testLender.put("admin","admin");
		assertEquals(false,vu.validate("Amin@gmail.com","Amin@556",testLender));
		assertEquals(false,vu.validate("admin", "admin1",testLender));
		assertEquals(false,vu.validate("admin1", "admin",testLender));
		assertEquals(true,vu.validate("admin", "admin",testLender));
		testLender.clear();
		
		try {
			vu.validate(null, null,testLender);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}