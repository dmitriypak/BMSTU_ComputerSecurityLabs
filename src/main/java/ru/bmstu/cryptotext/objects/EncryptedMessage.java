package ru.bmstu.cryptotext.objects;

import java.io.Serializable;

public class EncryptedMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -692810901581556371L;
	
	private String message;
	private int shift;
	private String encmessage;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getShift() {
		return shift;
	}
	public void setShift(int shift) {
		this.shift = shift;
	}
	public String getEncmessage() {
		return encmessage;
	}
	public void setEncmessage(String encmessage) {
		this.encmessage = encmessage;
	}
	
}
