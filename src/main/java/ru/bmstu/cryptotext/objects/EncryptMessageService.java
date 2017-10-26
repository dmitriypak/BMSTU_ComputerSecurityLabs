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
	public ModelAndView encryptMessage(UploadedFile file, RequestContext context) {
		ModelAndView mvn = new ModelAndView();
		
		System.out.println(file.getPath());
		System.out.println(file.getMessage());
		
		File newFile = createEncryptedImage(file);
		
		
		mvn.setViewName("success");
		return mvn;
	}
	
	
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

	        
//			byte[] bytes = file.getPath().getBytes();
//			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(encryptedFile));
//			stream.write(bytes);
//			stream.flush();
//			stream.close();
			
		}catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return encryptedFile;
	}
}
