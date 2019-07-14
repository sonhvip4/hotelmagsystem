package hongocsonha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hongocsonha.dto.CustomerDTO;
import hongocsonha.util.MysqlDataAccessHelper;

public class CustomerDAO {

	public static ArrayList<CustomerDTO> getAllCustomer() {
		ArrayList<CustomerDTO> arr = new ArrayList<CustomerDTO>();
		String sql = "select * from customer";
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql);
			while (rs.next()) {
				CustomerDTO cu = new CustomerDTO();
				cu.setCustomer_id(rs.getInt("customer_id"));
				cu.setCustomer_name(rs.getString("customer_name"));
				cu.setCustomer_phone(rs.getString("customer_phone"));
				cu.setCustomer_id_user(rs.getInt("customer_id_user"));
				arr.add(cu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return arr;
	}

	public static ArrayList<CustomerDTO> getCustomerById(int id_customer) {
		String sql = "Select * from customer where id = ?";
		List<Object> params = new ArrayList<>();
		params.add(id_customer);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.excuteQuery(sql, params);
			ArrayList<CustomerDTO> arr = new ArrayList<CustomerDTO>();
			while (rs.next()) {
				CustomerDTO cu = new CustomerDTO();
				cu.setCustomer_id(rs.getInt("customer_id"));
				cu.setCustomer_name(rs.getString("customer_name"));
				cu.setCustomer_phone(rs.getString("customer_phone"));
				cu.setCustomer_id_user(rs.getInt("customer_id_user"));
				arr.add(cu);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return null;
	}

	public static ArrayList<CustomerDTO> getCustomerByPhone(String phone_customer) {
		String sql = "Select * from customer where phone = ?";
//		List<Object> params = new ArrayList<>();
//		params.add(phone_customer);
		MysqlDataAccessHelper dt = new MysqlDataAccessHelper();
		try {
			dt.open();
			ResultSet rs = dt.searchExcuteQuery(sql, phone_customer);
			ArrayList<CustomerDTO> arr = new ArrayList<CustomerDTO>();
			while (rs.next()) {
				CustomerDTO cu = new CustomerDTO();
				cu.setCustomer_id(rs.getInt("customer_id"));
				cu.setCustomer_name(rs.getString("customer_name"));
				cu.setCustomer_phone(rs.getString("customer_phone"));
				cu.setCustomer_id_user(rs.getInt("customer_id_user"));
				arr.add(cu);
			}
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dt.close();
		}
		return null;
	}

	public static boolean AddCustomer(String customer_name, String phone) {
		String sql = "insert into customer (customerName,phone) " + "values (?,?)";
		List<Object> params = new ArrayList<>();
		params.add(customer_name);
		params.add(phone);
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
	// addCustomer
	// getCustomerById
	// get....
}
