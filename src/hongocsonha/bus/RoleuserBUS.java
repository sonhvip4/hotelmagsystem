package hongocsonha.bus;

import java.util.ArrayList;
import hongocsonha.dao.RoleuserDAO;
import hongocsonha.dto.RoleUserDTO;

public class RoleuserBUS {

	public static ArrayList<RoleUserDTO> getAllRoleuser() {
		return RoleuserDAO.getAllRoleuser();
	}
}

