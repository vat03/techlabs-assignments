package com.aurionpro.crud.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class studentErrorMessage {
	private String message;
	private int status;
	private long time;
	
	public studentErrorMessage() {
		super();
	}

	public studentErrorMessage(String message, int status, long time) {
		super();
		this.message = message;
		this.status = status;
		this.time = time;
	}
	
	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public long getTime() {
		return time;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "studentErrorMessage [message=" + message + ", status=" + status + ", time=" + time + "]";
	}
}
