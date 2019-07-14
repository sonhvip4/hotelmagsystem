package hongocsonha.dto;

public class RoomDTO {

	private int room_id;
	private String room_name;
	private int room_price;
	private boolean room_isActived;

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public boolean isRoom_isActived() {
		return room_isActived;
	}

	public void setRoom_isActived(boolean room_isActived) {
		this.room_isActived = room_isActived;
	}


}
