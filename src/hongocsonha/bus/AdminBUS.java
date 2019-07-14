package hongocsonha.bus;

import java.util.ArrayList;
import hongocsonha.dao.AdminDAO;
import hongocsonha.dto.AdminDTO;

public class AdminBUS {

	public static ArrayList<AdminDTO> getAllAdmin() {
		return AdminDAO.getAllAdmin();
	}
}
