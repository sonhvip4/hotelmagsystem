package hongocsonha.dto;

public class UserDTO {

	private int user_id;
	private String username;
	private String password;
	private int id_roleuser;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId_roleuser() {
		return id_roleuser;
	}
	public void setId_roleuser(int id_roleuser) {
		this.id_roleuser = id_roleuser;
	}
	
}
