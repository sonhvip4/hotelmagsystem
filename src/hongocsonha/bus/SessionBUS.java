package hongocsonha.bus;

import java.sql.Date;
import java.util.ArrayList;
import hongocsonha.dao.SessionDAO;
import hongocsonha.dto.SessionDTO;

public class SessionBUS {

	public static ArrayList<SessionDTO> getAllSession() {
		return SessionDAO.getAllSession();
	}

	public static ArrayList<SessionDTO> getSessionByIdCustomer(int id_customer) {
		return SessionDAO.getSessionByIdCustomer(id_customer);
	}

	public static ArrayList<SessionDTO> getSessionByIdRoom(int id_room) {
		return SessionDAO.getSessionByIdRoom(id_room);
	}

	public static boolean AddSession(int customer_id, int room_id ,Date checkin) {

		return SessionDAO.AddSession(customer_id, room_id, checkin);
	}

	public static boolean updateCheckOut(Date checkout, int room_id, int customer_int) {
		return SessionDAO.updateCheckOut(checkout,room_id,customer_int);
	}
}
