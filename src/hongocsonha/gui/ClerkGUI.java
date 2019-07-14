package hongocsonha.gui;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import hongocsonha.bus.RoomBUS;
import hongocsonha.bus.SessionBUS;
import hongocsonha.bus.UserBUS;
import hongocsonha.dto.RoomDTO;

public class ClerkGUI {
	RoomBUS _room;
	UserBUS _user;
	SessionBUS _session;
	private Scanner scanner;
	public ClerkGUI() {
		_room = new RoomBUS();
		_user = new UserBUS();
		_session = new SessionBUS();
		scanner = new Scanner(System.in);
	}
	
	public void showOption() {
		int choose;  
		System.out.println("***Hello,Clerk. We have some options for you:***");
		System.out.println("1.Show all of rooms.");
		System.out.println("2.Show all of available room.");
		System.out.println("3.Get Information of room name.");
		System.out.println("4.Upate status room.");
		System.out.println("5.Add session.");
		System.out.println("6.Update checkout in session.");
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
			String name;
			System.out.print("Plese write room name: ");
			name = scanner.nextLine();
			getRoomByName(name);
			break;
		}
		case 4: 
		{
			int status,id_room;
			System.out.print("Please write id of room: ");
			id_room= scanner.nextInt();
			System.out.println();
			System.out.print("Please write the status of room(1:Booked , 0:Available) :");
			status= scanner.nextInt();
			if(status == 0 || status == 1)
			{
				ChangeStatus(status, id_room);
			}
			else
			{
				System.out.println("please choose number 1(booked) or 0(available).");
			}
			break;
		}
		case 5:
		{
			int id_customer, id_room;
			String temp;
			Date checkin;
			System.out.print("Write the id of the customer: ");
		    id_customer = scanner.nextInt();
		    System.out.println();
		    System.out.print("Write the id of the room: ");
		    id_room = scanner.nextInt();
		    System.out.println();
		    System.out.println("Write the date checkin: ");
		    temp = scanner.nextLine();
		    checkin = Date.valueOf(temp);
		    AddSession(id_customer, id_room, checkin);
			break;
		}
		case 6:
		{
			int id_customer, id_room;
			String temp;
			Date checkout;
			System.out.print("Write the id of the customer: ");
		    id_customer = scanner.nextInt();
		    System.out.println();
		    System.out.print("Write the id of the room: ");
		    id_room = scanner.nextInt();
		    System.out.println();
		    System.out.println("Write the date checkout: ");
		    temp = scanner.nextLine();
		    checkout = Date.valueOf(temp);
		    UpdateSession(checkout, id_room, id_customer);
			break;
		}
		default:
		{
			/////////////////////////////
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
	
	private void getRoomByName(String name)
	{
		List<RoomDTO> lstRoom = RoomBUS.getRoomByName(name);
		for(RoomDTO room: lstRoom)
		{
			System.out.println(room);
		}
	}
	
	private void ChangeStatus(int status , int id_room)
	{
		boolean result = RoomBUS.updateStatusRoom(status, id_room);
		if(result)
		{
			System.out.println("Success to update status");
		}
		else
		{
			System.out.println("Failure to update status");
		}
	}
	
	private void AddSession(int id_customer, int id_room, Date checkin)
	{
		boolean result = SessionBUS.AddSession(id_customer, id_room, checkin);
		if(result)
		{
			System.out.println("Success to add session");
		}
		else
		{
			System.out.println("Failure to add session");
		}
	}
	
	private void UpdateSession(Date checkout, int id_room, int id_customer)
	{
		boolean result = SessionBUS.updateCheckOut(checkout, id_room, id_customer);
		if(result)
		{
			System.out.println("Success to update session");
		}
		else
		{
			System.out.println("Failure to update session");
		}
	}
}
