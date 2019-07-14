package hongocsonha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hongocsonha.dto.UserDTO;
import hongocsonha.util.MysqlDataAccessHelper;

public class UserDAO {

	public static ArrayList<UserDTO> getAllUser() {
		ArrayList<UserDTO> arr = new ArrayList<UserDTO>();
		String sql = "select * from user";
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql);
			while (rs.next()) {
				UserDTO us = new UserDTO();
				us.setUser_id(rs.getInt("user_id"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				us.setId_roleuser(rs.getInt("id_roleuser"));
				arr.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return arr;
	}

	public static ArrayList<UserDTO> getUserByName(String username) {
		String sql = "Select * from user where userName = ?";
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.searchExcuteQuery(sql, username);
			ArrayList<UserDTO> arr = new ArrayList<UserDTO>();
			while (rs.next()) {
				UserDTO us = new UserDTO();
				us.setUser_id(rs.getInt("user_id"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				us.setId_roleuser(rs.getInt("id_roleuser"));
				arr.add(us);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return null;
	}

	public static ArrayList<UserDTO> getUserByUserAndPass(String username, String password) {
		String sql = "Select * from user where userName = ?" + "and password = ?";
		List<Object> params = new ArrayList<>();
		params.add(username);
		params.add(password);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql, params);
			ArrayList<UserDTO> arr = new ArrayList<UserDTO>();
			while (rs.next()) {
				UserDTO us = new UserDTO();
				us.setUser_id(rs.getInt("user_id"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				us.setId_roleuser(rs.getInt("id_roleuser"));
				arr.add(us);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return null;
	}
	
	public static int getIdByUserAndRole(String username, int id_role) {
		String sql = "Select id from user where userName = ?"
				+ "and id_Roleuser = ?";
		List<Object> params = new ArrayList<>();
		params.add(username);
		params.add(id_role);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql, params);
			while (rs.next()) {
				UserDTO us = new UserDTO();
				us.setUser_id(rs.getInt("user_id"));
				return us.getUser_id();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return 0;
	}

	public static boolean AddUser(String username, String password, int roleuser_id) {
		String sql = "insert into user (userName,password,id_roleuser) " + "values (?,?,?)";
		List<Object> params = new ArrayList<>();
		params.add(username);
		params.add(password);
		params.add(roleuser_id);
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

	public static boolean updatePassword(String password, String username) {
		String sql = "update user set " + "password = ?" + "Where userName = ? ";
		List<Object> params = new ArrayList<>();
		params.add(password);
		params.add(username);
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

	// getByUsername - search
	// getByUserAndPassword
	// addUser - Customer, admin
	// updatePasswordUser
}
