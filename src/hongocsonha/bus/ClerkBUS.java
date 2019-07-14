package hongocsonha.bus;

import java.util.ArrayList;
import hongocsonha.dao.ClerkDAO;
import hongocsonha.dto.ClerkDTO;

public class ClerkBUS {

	public static ArrayList<ClerkDTO> getAllClerk() {
		return ClerkDAO.getAllClerk();
	}

	public static ArrayList<ClerkDTO> getCleckById(int id_clerk) {
		return ClerkDAO.getCleckById(id_clerk);
	}

	public static boolean updateDisableClerk(int disable, int id_clerk) {
		return ClerkDAO.updateDisableClerk(disable, id_clerk);
	}

}
