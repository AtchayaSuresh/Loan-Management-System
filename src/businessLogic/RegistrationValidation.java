package businessLogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation {
	
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private Pattern pattern;
	private Matcher matcher1,matcher2;
	
	public boolean checkUserDetails(String email,String password,String confirmPassword) {
		if(validEmail(email) && validPassword(password,confirmPassword))
			return true;
		else
			return false;
	}

	private boolean validPassword(String password, String confirmPassword) {
		
		if(password==null||confirmPassword==null)
		{
			System.out.println("Invalid Password");
			return false;
		}
		
		 pattern = Pattern.compile(PASSWORD_PATTERN);
		 if(password.equals(confirmPassword)) 
		 {
			 matcher1 = pattern.matcher(password);
			 matcher2 = pattern.matcher(confirmPassword);
			 
			 boolean passwordMatch=matcher2.matches() && matcher1.matches();
			 
			 if(!passwordMatch)
				 System.out.println("Password not matching");
			 return passwordMatch;
		 }
		 System.out.println("Password not matching");
		return false;
		 
	}

	private boolean validEmail(String email) {
		if(email==null)
		{
			 System.out.println("Enter valid emailID");
			 return false;
		}
		 String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		
		 boolean validate=email.matches(regex);
		 if(!validate)
			 System.out.println("Enter valid emailId");
		 
		 return validate;
		 
	}
}
