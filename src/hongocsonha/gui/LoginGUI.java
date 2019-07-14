2package hongocsonha.gui;

import java.util.Scanner;
import hongocsonha.bus.LoginBUS;

public class LoginGUI {
	public LoginBUS _login;
	private Scanner scanner;

	public LoginGUI() {
		scanner = new Scanner(System.in);
		_login = new LoginBUS();
	}
	public void ShowLoginForm() {
		String username;
		String password;
		int idrole;
		System.out.println("==================================");
		System.out.println("=========  Login Form   ==========");
		System.out.println("==================================");
		System.out.print("Username: ");
		username = scanner.nextLine();
		System.out.print("Password: ");
		password = scanner.nextLine();
		System.out.println("Choose a number corresponds your role: ");
		System.out.println("1.Admin");
		System.out.println("2.Clerk");
		System.out.println("3.Customer");
		System.out.print("Your role is: " );
		idrole= scanner.nextInt();
		System.out.println();
		boolean isValidUser= _login.getLogin(username, password, idrole);
		if(isValidUser)
		{
			switch(idrole)
			{
			case 1:
			{
				//admin
				break;
			}
			case 2:
			{
				//clerk
				break;
			}
			case 3:
			{
				//customer
				
				break;
			}
			}
		}
		else
		{
			System.out.println("Login Failed! Please login again.");
		}
		
		// boolean isValidUser = _login.accessUser(username, password);
		/* if(isValidUser) {
		 * when login success, show option of type of user
		 * userBus.getRoleOfUSer(user) => 1,2,3 
		 * 
		 * => CustomerGUI
		 * => AdmingUI
		 * => ClerkGUI
		 * } else { 
		 * System.out.println("Login Failed! Please ,fkeof"); 
		 * ShowLoginForm(); 
		 *  press ESC to exit
		 * }
		
		*/
	}
}
