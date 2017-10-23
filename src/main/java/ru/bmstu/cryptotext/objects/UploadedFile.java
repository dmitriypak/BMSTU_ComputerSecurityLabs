package ru.bmstu.cryptotext.objects;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile implements Serializable {
	private static final long serialVersionUID = 7730377931313245319L;
	private transient MultipartFile file;
	private String message;
	private String path;

//	private byte[] fileContent;
//
//	public byte[] getFileContent() {
//		return fileContent;
//	}

//	public void setFile(MultipartFile file) {
//		try {
//			this.fileContent = file.getBytes();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}	
	
	
	
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