package hongocsonha.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hongocsonha.dto.SessionDTO;
import hongocsonha.util.MysqlDataAccessHelper;

public class SessionDAO {
	public static ArrayList<SessionDTO> getAllSession() {
		ArrayList<SessionDTO> arr = new ArrayList<SessionDTO>();
		String sql = "select * from session";
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql);
			while (rs.next()) {
				SessionDTO se = new SessionDTO();
				se.setCustomer_id(rs.getInt("id_Customer"));
				se.setRoom_id(rs.getInt("id_Room"));
				se.setTimeCheckIn(rs.getDate("checkIn"));
				se.setTimeCheckOut(rs.getDate("checkOut"));
				arr.add(se);
			}
		} catch (SQLException e) {
			return null;
		} finally {
			dt.close();
		}
		return arr;
	}

	public static ArrayList<SessionDTO> getSessionByIdCustomer(int id_customer) {
		String sql = "Select * from session where id_Customer = ?";
		List<Object> params = new ArrayList<>();
		params.add(id_customer);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql, params);
			ArrayList<SessionDTO> arr = new ArrayList<SessionDTO>();
			while (rs.next()) {
				SessionDTO se = new SessionDTO();
				se.setCustomer_id(rs.getInt("id_Customer"));
				se.setRoom_id(rs.getInt("id_Room"));
				se.setTimeCheckIn(rs.getDate("checkIn"));
				se.setTimeCheckOut(rs.getDate("checkOut"));
				arr.add(se);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return null;
	}

	public static ArrayList<SessionDTO> getSessionByIdRoom(int id_room) {
		String sql = "Select * from session where id_Room = ?";
		List<Object> params = new ArrayList<>();
		params.add(id_room);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql, params);
			ArrayList<SessionDTO> arr = new ArrayList<SessionDTO>();
			while (rs.next()) {
				SessionDTO se = new SessionDTO();
				se.setCustomer_id(rs.getInt("id_Customer"));
				se.setRoom_id(rs.getInt("id_Room"));
				se.setTimeCheckIn(rs.getDate("checkIn"));
				se.setTimeCheckOut(rs.getDate("checkOut"));
				arr.add(se);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return null;
	}

	public static boolean AddSession(int customer_id, int room_id ,Date checkin) {
		String sql = "insert into session (id_Customer,id_Room,checkIn) " + "values (?,?,?)";
		List<Object> params = new ArrayList<>();
		params.add(customer_id);
		params.add(room_id);
		params.add(checkin);
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

	public static boolean updateCheckOut(Date checkout, int room_id, int customer_int) {
		String sql = "update session set " + "checkOut = ?" + "Where id_Room = ? and id_Customer = ? ";
		List<Object> params = new ArrayList<>();
		params.add(checkout);
		params.add(room_id);
		params.add(customer_int);
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

	// getbyidCustomer
	// getbyidRoom
	// updateCheckIn
	// updateCheckOut
}
