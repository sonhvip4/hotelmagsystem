package hongocsonha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hongocsonha.dto.ClerkDTO;
import hongocsonha.util.MysqlDataAccessHelper;

public class ClerkDAO {

	public static ArrayList<ClerkDTO> getAllClerk()
	{
		ArrayList<ClerkDTO> arr = new ArrayList<ClerkDTO>();
		String sql = "select * from clerk";
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql);
			while(rs.next())
			{
				ClerkDTO cl = new ClerkDTO();
				cl.setClerk_id(rs.getInt("clerk_id"));
				cl.setClerk_name(rs.getString("clerk_name"));
				cl.setClerk_id_user(rs.getInt("clerk_id_user"));
				cl.setDisable(rs.getBoolean("isDisable"));
				arr.add(cl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		
		return arr;
	}
	
	public static ArrayList<ClerkDTO> getCleckById(int id_clerk)
	{
		String sql = "Select * from clerk where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(id_clerk);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql, params);
			ArrayList<ClerkDTO> arr = new ArrayList<ClerkDTO>();
			while(rs.next())
			{
				ClerkDTO cl = new ClerkDTO();
				cl.setClerk_id(rs.getInt("clerk_id"));
				cl.setClerk_name(rs.getString("clerk_name"));
				cl.setClerk_id_user(rs.getInt("clerk_id_user"));
				cl.setDisable(rs.getBoolean("isDisable"));
				arr.add(cl);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return null;
	}
	
	public static boolean updateDisableClerk(int disable , int id_clerk)
	{
		String sql = "update clerk set "
				+ "disable = ?"
				+ "Where id = ?";
		List<Object> params= new ArrayList<>();
		params.add(disable);
		params.add(id_clerk);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			boolean action = dt.executeUpdate(sql, params);
			return action;	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return false;		
	}
	
//	public static boolean AddClerk(ClerkDTO clerk)
//	{
//		String sql="insert into clerk (clerkName,id_User,disable) "
//				+ "values (?,?)";
//		List<Object> params = new ArrayList<>();
//		params.add(clerk.getClerk_name());
//		params.add(clerk.getClerk_id_user());
//		params.add(clerk.isDisable());
//		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
//		try {
//			dt.open();
//			boolean action = dt.executeUpdate(sql, params);
//			return action;	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	
	// get
	// update - disable staff when be fired
}
