package hongocsonha.gui;

import java.util.List;
import java.util.Scanner;

import hongocsonha.bus.RoleuserBUS;
import hongocsonha.bus.UserBUS;
import hongocsonha.dto.RoleUserDTO;

public class AdminGUI {
	RoleuserBUS _role;
	UserBUS _user;
	private Scanner scanner;
	public AdminGUI() {
		_role = new RoleuserBUS();
		_user = new UserBUS();
		scanner = new Scanner(System.in);
	}
	
	public void showOption() {
		int choose;  
		System.out.println("***Hello,Admin. We have some options for you:***");
		System.out.println("1.Show all of roleuser.");
		System.out.println("2.Add new User.");
		System.out.println("3.Change password for user.");
		System.out.println("Your choose is: ");
		choose = scanner.nextInt();
		System.out.println();
		switch(choose)
		{
		case 1:
		{
			showAllRole();
			break;
		}
		case 2:
		{
			String username;
			String password;
			int id_roleuser;
			System.out.print("Write username: ");
			username = scanner.nextLine();
			System.out.print("Write password: ");
			password = scanner.nextLine();
			System.out.print("Set roleuser: ");
			id_roleuser = scanner.nextInt();
			System.out.println();
			addUser(username, password, id_roleuser);
			break;
		}
		case 3:
		{
			String username;
			String password;
			System.out.print("Write username you want to choose: ");
			username = scanner.nextLine();
			System.out.print("Write password you want to change: ");
			password = scanner.nextLine();
			changePassword(password, username);
			break;
		}
		default:
		{
			///////////////////////////////////////
		}
		}
	}
	private void showAllRole()
	{
		List<RoleUserDTO> lstRole = RoleuserBUS.getAllRoleuser();
		for (RoleUserDTO role : lstRole) {
			System.out.println(role);
		}
	}
	
	private void addUser(String username, String password, int id_roleuser)
	{
		boolean result = UserBUS.AddUser(username, password, id_roleuser);
		if(result)
		{
			System.out.println("Success to add user");
		}
		else
		{
			System.out.println("Failure to add user");
		}
	}
	
	private void changePassword(String password, String username)
	{
		boolean result = UserBUS.updatePassword(password, username);
		if(result)
		{
			System.out.println("Success to update password");
		}
		else
		{
			System.out.println("Failure to update password");
		}
	}
}
