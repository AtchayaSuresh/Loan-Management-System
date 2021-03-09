package businessLogic;

import java.util.HashMap;

public class ValidateLender {
	

	public boolean validate(String lenderId, String password,HashMap<String,String>loginDetails) {
		
	
		if(lenderId==null||password==null)
		{
			System.out.println("Enter lenderId and password");
			return false;
		}
		else if(loginDetails.containsKey(lenderId)&&loginDetails.get(lenderId).equals(password))
		{
			System.out.println("Login Successful");
			return true;
		}
		else 
		{
			System.out.println("Invalid lenderId or password");
			return false;
		}
	}

}
