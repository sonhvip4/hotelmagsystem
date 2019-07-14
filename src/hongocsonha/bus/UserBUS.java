package hongocsonha.bus;

import java.util.ArrayList;
import hongocsonha.dao.UserDAO;
import hongocsonha.dto.UserDTO;

public class UserBUS {

	public static ArrayList<UserDTO> getAllUser() {
		return UserDAO.getAllUser();
	}

	public static ArrayList<UserDTO> getUserByName(String username) {
		return UserDAO.getUserByName(username);
	}

	public static ArrayList<UserDTO> getUserByUserAndPass(String username, String password) {
		return UserDAO.getUserByUserAndPass(username, password);
	}

	public static boolean AddUser(String username, String password, int roleuser_id) {
		return UserDAO.AddUser(username, password, roleuser_id);
	}

	public static boolean updatePassword(String password, String username) {
		return UserDAO.updatePassword(password, username);
	}
	
	public static int getIdByUserAndRole(String username, int id_role) {
		return UserDAO.getIdByUserAndRole(username,id_role);
	}
}
