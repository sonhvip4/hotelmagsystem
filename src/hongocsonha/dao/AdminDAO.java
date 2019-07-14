package hongocsonha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hongocsonha.dto.AdminDTO;
import hongocsonha.util.MysqlDataAccessHelper;

public class AdminDAO {
	
	public static ArrayList<AdminDTO> getAllAdmin()
	{
		ArrayList<AdminDTO> arr = new ArrayList<AdminDTO>();
		String sql = "select * from admin";
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql);
			while(rs.next())
			{
				AdminDTO ad = new AdminDTO();
				ad.setAdmin_id(rs.getInt("admin_id"));
				ad.setAdmin_name(rs.getString("admin_name"));
				ad.setAdmin_id_user(rs.getInt("admin_id_user"));
				arr.add(ad);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			dt.close();
		}
		return arr;
	}
	
}
