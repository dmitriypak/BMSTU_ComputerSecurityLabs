package ru.bmstu.cryptotext.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ru.bmstu.cryptotext.objects.UploadedFile;

@Controller
public class EncryptController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	@RequestMapping(value = "/encryptMessage", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView encryptMessage(@ModelAttribute("message") String originalMessage) {
		ModelAndView modelAndView = new ModelAndView();

		logger.info("Сообщение: " + originalMessage);
		
		modelAndView.setViewName("encryptedmessage");
		return modelAndView;
		
	}
	@RequestMapping(value = "/encryptedMessage", method = RequestMethod.GET)
	public String encryptedMessage() {
		return "encryptedmessage";
	}	
}
