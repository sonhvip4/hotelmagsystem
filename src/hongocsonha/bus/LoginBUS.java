package hongocsonha.bus;

import hongocsonha.dao.LoginDAO;

public class LoginBUS {
	
	LoginDAO login = new LoginDAO();
	public boolean getLogin(String username, String password, int id_role)
	{
		return login.getLogin(username, password, id_role);
	}
}
