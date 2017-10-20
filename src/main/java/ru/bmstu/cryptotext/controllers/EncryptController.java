package ru.bmstu.cryptotext.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import ru.bmstu.cryptotext.objects.UploadedFile;

@Controller
public class EncryptController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	@RequestMapping(value = "/encryptMessage", method = RequestMethod.POST)
	public String encryptMessage(HttpServletRequest request,Model model) {
		 Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		//logger.info("Сообщение: " + flashMap.get("uploadedFile"));
		
		 if(flashMap != null){
			 UploadedFile file =  (UploadedFile) flashMap.get("uploadedFile");
			logger.info("Загруженный файл: " + file.getPath());
			logger.info("сообщение: " + file.getMessage());
			 return "encryptedmessage";
		 } 
		return "encryptedmessage";
		
	}
	@RequestMapping(value = "/encryptedMessage", method = RequestMethod.GET)
	public String encryptedMessage() {
		return "encryptedmessage";
	}	
}
