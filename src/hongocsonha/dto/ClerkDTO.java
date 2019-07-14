package hongocsonha.dto;

public class ClerkDTO {
	private int clerk_id;
	private String clerk_name;
	private int clerk_id_user;
	private boolean isDisable;

	public int getClerk_id() {
		return clerk_id;
	}

	public void setClerk_id(int clerk_id) {
		this.clerk_id = clerk_id;
	}

	public String getClerk_name() {
		return clerk_name;
	}

	public void setClerk_name(String clerk_name) {
		this.clerk_name = clerk_name;
	}

	public int getClerk_id_user() {
		return clerk_id_user;
	}

	public void setClerk_id_user(int clerk_id_user) {
		this.clerk_id_user = clerk_id_user;
	}

	public boolean isDisable() {
		return isDisable;
	}

	public void setDisable(boolean isDisable) {
		this.isDisable = isDisable;
	}
	

}
