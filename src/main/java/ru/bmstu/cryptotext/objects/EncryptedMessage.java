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
	private int countShifts;
	private int kof;
	
	
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
	public int getCountShifts() {
		return countShifts;
	}
	public void setCountShifts(int countShifts) {
		this.countShifts = countShifts;
	}
	public int getKof() {
		return kof;
	}
	public void setKof(int kof) {
		this.kof = kof;
	}
	
}
