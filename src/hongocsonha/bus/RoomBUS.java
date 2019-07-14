package hongocsonha.bus;

import java.util.ArrayList;
import hongocsonha.dao.RoomDAO;
import hongocsonha.dto.RoomDTO;

public class RoomBUS {

	public static ArrayList<RoomDTO> getAllRoom() {
		return RoomDAO.getAllRoom();
	}

	public static ArrayList<RoomDTO> getRoomByName(String room_name) {
		return RoomDAO.getRoomByName(room_name);
	}

	public static ArrayList<RoomDTO> getRoomByStatus(int status) {
		return RoomDAO.getRoomByStatus(status);
	}

	public static boolean updateStatusRoom(int status, int room_id) {
		return RoomDAO.updateStatusRoom(status, room_id);
	}
	public static int getStatusRoom(int room_id)
	{
		return RoomDAO.getStatusRoom(room_id);
	}
}
