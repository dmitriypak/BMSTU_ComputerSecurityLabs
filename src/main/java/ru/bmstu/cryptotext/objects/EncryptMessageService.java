package ru.bmstu.cryptotext.objects;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
		
		createEncryptedImage(file);
		
		mvn.setViewName("success");
		return mvn;
	}
	
	
	private File createEncryptedImage(UploadedFile file) {
		File newFile = null;
//		try {
			newFile = new File(file.getAbsolutePath());
	        if(newFile.exists())
	            System.out.println("Файл существует");
	        else
	            System.out.println("Файл еще не создан");	
	        
//			byte[] bytes = file.getPath().getBytes();
//			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
//			stream.write(bytes);
//			stream.flush();
//			stream.close();
			
//		}catch(IOException ex) {
//			ex.printStackTrace();
//			return null;
//		}
		return newFile;
	}
}
