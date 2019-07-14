package hongocsonha.gui;

import java.util.Scanner;

public class HomeGUI {
	private static Scanner scanner ;
	private static LoginGUI login = new LoginGUI();
	private static RegisterGUI register = new RegisterGUI();
	
	public static void main(String[] args) {
		
		int choose;
		scanner = new Scanner(System.in);
		System.out.println("******Welcome to Hotel Manager System******");
		System.out.println("We have 2 options:");
		System.out.println("1.Login.");
		System.out.println("2.Register as a customer.");
		System.out.print("Your choose is :");
		choose = scanner.nextInt();
		if(choose == 1)
		{
			login.ShowLoginForm();
		}
		else if (choose == 2)
		{
			register.showRegisterForm();
		}
		else
		{
			System.out.println("Please choose again.");
		}
		//1 customer
		//2 registor
		//Another way:
		//3 Clerk
		//4 Admin
//		System.out.println("Choose a number corresponds your role: ");
//		System.out.println("1.Admin");
//		System.out.println("2.Clerk");
//		System.out.println("3.Customer");
//		System.out.print("Your role is: " );
		//redirect to login or register
	}
}
