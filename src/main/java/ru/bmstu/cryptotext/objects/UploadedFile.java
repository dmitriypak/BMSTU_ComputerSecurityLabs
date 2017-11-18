package ru.bmstu.cryptotext.objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile implements Serializable {
	private static final long serialVersionUID = 7730377931313245319L;
	private transient MultipartFile file;
	private String message;
	private String fileName;
	private String path;
	private String dir;
	private String absolutePath;
	private File sourceFile;
	private int width;
	private int height;
	private byte bitCount;
	private File encryptedFile;
	private String encryptedFilePath;
	
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public byte getBitCount() {
		return bitCount;
	}

	public void setBitCount(byte bitCount) {
		this.bitCount = bitCount;
	}

	public File getEncryptedFile() {
		return encryptedFile;
	}

	public void setEncryptedFile(File encryptedFile) {
		this.encryptedFile = encryptedFile;
	}

	public String getEncryptedFilePath() {
		return encryptedFilePath;
	}

	public void setEncryptedFilePath(String encryptedFilePath) {
		this.encryptedFilePath = encryptedFilePath;
	}


	
}