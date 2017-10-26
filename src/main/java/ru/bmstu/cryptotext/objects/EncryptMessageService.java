package ru.bmstu.cryptotext.objects;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.webflow.execution.RequestContext;

@Component
public class EncryptMessageService {
	
	private static final int MAX_INT_LEN = 4;
	
	public ModelAndView encryptMessage(UploadedFile file, RequestContext context) {
		ModelAndView mvn = new ModelAndView();
		
		System.out.println(file.getPath());
		System.out.println(file.getMessage());
		
		File newFile = createEncryptedImage(file);
		
		
		mvn.setViewName("success");
		return mvn;
	}
	
	private static byte[] intToBytes(int i)
	{
	 byte[] integerBs = new byte[MAX_INT_LEN];
	 integerBs[0] = (byte) ((i >>> 24) & 0xFF);
	 integerBs[1] = (byte) ((i >>> 16) & 0xFF);
	 integerBs[2] = (byte) ((i >>> 8) & 0xFF);
	 integerBs[3] = (byte) (i & 0xFF);
	 return integerBs;
	} 

	
	private static byte[] getMessageBytes(String inputText)
	{
	 // convert data to byte arrays
	 byte[] msgBytes = inputText.getBytes();
	 byte[] lenBs = intToBytes(msgBytes.length);
	 int totalLen = lenBs.length + msgBytes.length;
	 byte[] stego = new byte[totalLen]; // for holding resulting stego
	 // combine the two fields into one byte array
	 System.arraycopy(lenBs, 0, stego, 0, lenBs.length);
	 // length of binary message
	 System.arraycopy(msgBytes, 0, stego, lenBs.length,msgBytes.length);
	 // binary message
	 return stego;
	} // en
	
	private File createEncryptedImage(UploadedFile file) {
		File originalFile = null;
		File encryptedFile = null;
		String nameEncryptedFile = "enc_"+file.getFileName();
		try {
		originalFile = new File(file.getAbsolutePath()+File.separator+file.getFileName());
		encryptedFile = new File(file.getAbsolutePath()+File.separator+nameEncryptedFile);
        if(!originalFile.exists()) {
            System.out.println("Файл отсутствует");	
            return null;
        }
        InputStream  inStream = new FileInputStream(originalFile);
        OutputStream outStream = new FileOutputStream(encryptedFile);
        
        byte[] buffer = new byte[1024];

	    int length;
	    //copy the file content in bytes
	    while ((length = inStream.read(buffer)) > 0){
	    	outStream.write(buffer, 0, length);
	    }

	    inStream.close();
	    outStream.close();

	    System.out.println("File is copied successful!");

		}catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return encryptedFile;
	}
}
