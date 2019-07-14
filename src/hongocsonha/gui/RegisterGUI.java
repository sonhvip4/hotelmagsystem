package hongocsonha.gui;

import java.util.Scanner;

import hongocsonha.bus.UserBUS;

public class RegisterGUI {
	UserBUS _user;
	private Scanner scanner;
	public RegisterGUI() {
		_user = new UserBUS();
		scanner = new Scanner(System.in);
	}
	
	public void showRegisterForm()
	{
		String username;
		String password;
		final int IDROLE = 3;
		System.out.println("==================================");
		System.out.println("========  Register Form  =========");
		System.out.println("==================================");
		System.out.print("Username: ");
		username = scanner.nextLine();
		System.out.print("Password: ");
		password = scanner.nextLine();
		boolean result = UserBUS.AddUser(username, password, IDROLE);
		if(result)
		{
			System.out.println("Access to register!");
		}
		else
		{
			System.out.println("Failure to register!");
		}
	}
	
}
