package hongocsonha.dto;

import java.sql.Date;

public class SessionDTO {
	private int customer_id;
	private int room_id;
	private Date timeCheckIn;
	private Date timeCheckOut;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public Date getTimeCheckIn() {
		return timeCheckIn;
	}

	public void setTimeCheckIn(Date timeCheckIn) {
		this.timeCheckIn = timeCheckIn;
	}

	public Date getTimeCheckOut() {
		return timeCheckOut;
	}

	public void setTimeCheckOut(Date timeCheckOut) {
		this.timeCheckOut = timeCheckOut;
	}
	
}
