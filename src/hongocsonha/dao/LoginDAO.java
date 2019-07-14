package hongocsonha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hongocsonha.util.MysqlDataAccessHelper;

public class LoginDAO {
	
	private final String sql = "Select * from clerk where id = ?" + "and password = ?"+ "and id_roleuser = ?";
	public boolean getLogin(String username, String password, int id_role)
	{
		boolean check = false;
		List<Object> params = new ArrayList<>();
		params.add(username);
		params.add(password);
		params.add(id_role);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql, params);
			if(rs != null && rs.next())
			{
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dt.close();
		}
		return check;
	}
}
