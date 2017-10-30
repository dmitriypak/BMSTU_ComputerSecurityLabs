package ru.bmstu.cryptotext.objects;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.webflow.execution.RequestContext;

@Component
public class EncryptedMessageService {

	
	public ModelAndView encryptMessage(EncryptedMessage message, RequestContext context) {
		ModelAndView mvn = new ModelAndView();
		
		System.out.println(message.getMessage());
		System.out.println(message.getShift());
		
		
		mvn.setViewName("success");
		return mvn;
	}
	
}
