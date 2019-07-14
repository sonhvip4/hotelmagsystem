package hongocsonha.bus;

import java.util.ArrayList;
import hongocsonha.dao.CustomerDAO;
import hongocsonha.dto.CustomerDTO;

public class CustomerBUS {

	public static ArrayList<CustomerDTO> getAllCustomer() {
		return CustomerDAO.getAllCustomer();
	}

	public static ArrayList<CustomerDTO> getCustomerById(int id_customer) {
		return CustomerDAO.getCustomerById(id_customer);
	}

	public static ArrayList<CustomerDTO> getCustomerByPhone(String phone_customer) {
		return CustomerDAO.getCustomerByPhone(phone_customer);
	}

	public static boolean AddCustomer(String customer_name, String phone) {
		return CustomerDAO.AddCustomer(customer_name, phone);
	}

}
