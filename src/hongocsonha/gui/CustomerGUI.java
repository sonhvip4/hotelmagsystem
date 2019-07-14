package hongocsonha.gui;

import java.util.List;
import java.util.Scanner;

import hongocsonha.bus.RoomBUS;
import hongocsonha.bus.UserBUS;
import hongocsonha.dto.RoomDTO;

public class CustomerGUI {
	RoomBUS _room;
	UserBUS _user;
	private Scanner scanner;
	public CustomerGUI() {
		_room = new RoomBUS();
		_user = new UserBUS();
		scanner = new Scanner(System.in);
	}
	
	public void showOption() {
		int choose;  
		System.out.println("***Hello,Customer. We have some options for you:***");
		System.out.println("1.Show all of rooms.");
		System.out.println("2.Show all of available room");
		System.out.println("3.Booking a room");
		System.out.println("Your choose is: ");
		choose = scanner.nextInt();
		System.out.println();
		switch(choose)
		{
		case 1:
		{
			showValidRoom();
			break;
		}
		case 2:
		{
			showAvailableRoom();
			break;
		}
		case 3:
		{
			int id_choose;
			System.out.print("Please write the id of room you want to book: ");
			id_choose = scanner.nextInt();
			System.out.println();
			bookRoom(id_choose);
			break;
		}
		default:
		{
			/////////////////////////////////////////////////////////
		}
		}
		
	}
	
	private void showValidRoom() 
	{
		List<RoomDTO> lstRoom = RoomBUS.getAllRoom();
		for(RoomDTO room : lstRoom)
		{
			System.out.println(room);
		}
	}
	
	private void showAvailableRoom()
	{
		List<RoomDTO> lstRoom = RoomBUS.getRoomByStatus(0);
		for(RoomDTO room : lstRoom)
		{
			System.out.println(room);
		}
	}
	
	private void bookRoom(int id_choose)
	{
		int check = RoomBUS.getStatusRoom(id_choose);
		if (check == 0)
		{
			boolean result = RoomBUS.updateStatusRoom(1, id_choose);
			if(result)
			{
				System.out.println("Success to book room");
			}
			else
			{
				System.out.println("Failure to book room");
			}
		}
		else
		{
			System.out.println("That room was booked, Plese book an other room!");
		}
	}
}
