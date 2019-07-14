package hongocsonha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hongocsonha.dto.RoomDTO;
import hongocsonha.util.MysqlDataAccessHelper;

public class RoomDAO {

	public static ArrayList<RoomDTO> getAllRoom() {
		ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
		String sql = "select * from room";
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql);
			while (rs.next()) {
				RoomDTO ro = new RoomDTO();
				ro.setRoom_id(rs.getInt("room_id"));
				ro.setRoom_name(rs.getString("room_name"));
				ro.setRoom_price(rs.getInt("room_price"));
				ro.setRoom_isActived(rs.getBoolean("room_isActived"));
				arr.add(ro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}

		return arr;
	}

	public static ArrayList<RoomDTO> getRoomByName(String room_name) {
		String sql = "Select * from room where phone = ?";
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.searchExcuteQuery(sql, room_name);
			ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
			while (rs.next()) {
				RoomDTO ro = new RoomDTO();
				ro.setRoom_id(rs.getInt("room_id"));
				ro.setRoom_name(rs.getString("room_name"));
				ro.setRoom_price(rs.getInt("room_price"));
				ro.setRoom_isActived(rs.getBoolean("room_isActived"));
				arr.add(ro);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return null;
	}

	public static ArrayList<RoomDTO> getRoomByStatus(int status) {
		String sql = "Select * from room where status = ?";
		List<Object> params = new ArrayList<>();
		params.add(status);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql, params);
			ArrayList<RoomDTO> arr = new ArrayList<RoomDTO>();
			while (rs.next()) {
				RoomDTO ro = new RoomDTO();
				ro.setRoom_id(rs.getInt("room_id"));
				ro.setRoom_name(rs.getString("room_name"));
				ro.setRoom_price(rs.getInt("room_price"));
				ro.setRoom_isActived(rs.getBoolean("room_isActived"));
				arr.add(ro);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return null;
	}

	public static boolean updateStatusRoom(int status, int room_id) {
		String sql = "update room set " + "status = ?" + "Where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(status);
		params.add(room_id);
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
	
	public static int getStatusRoom(int room_id)
	{
		String sql = "Select status from room where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(room_id);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql, params);
			if (rs.next() && rs.getBoolean("room_isActived")) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return 0;
	}

	// getByRoomName
	// getByStatus
	// getByPrice(low = 0,high = maxInt) (Updating)
	// updateStatusRoom
}
