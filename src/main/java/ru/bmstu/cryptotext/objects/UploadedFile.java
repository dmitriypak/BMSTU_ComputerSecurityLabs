package ru.bmstu.cryptotext.objects;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {

	private MultipartFile file;
	private String message;
	private String path;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}