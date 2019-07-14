package hongocsonha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import hongocsonha.dto.RoleUserDTO;
import hongocsonha.util.MysqlDataAccessHelper;

public class RoleuserDAO {

	public static ArrayList<RoleUserDTO> getAllRoleuser()
	{
		ArrayList<RoleUserDTO> arr = new ArrayList<RoleUserDTO>();
		String sql = "select * from roleuser" ;
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql);
			while(rs.next()) {
				RoleUserDTO ru = new RoleUserDTO();
				ru.setRoleuser_id(rs.getInt("roleuser_id"));
				ru.setRoleuser_name(rs.getString("roleuser_name"));
				arr.add(ru);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return arr;
	}
}
