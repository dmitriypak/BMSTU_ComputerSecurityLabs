package ru.bmstu.cryptotext.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ru.bmstu.cryptotext.objects.UploadedFile;
import ru.bmstu.cryptotext.objects.FileValidator;

@Controller
@SessionAttributes("filename")

public class FileController {

	@Autowired
	private FileValidator fileValidator;

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	private MultipartFile file = null;
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView uploadFile(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result,
			HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();

		String fileName = null;

		file = uploadedFile.getFile();
		fileValidator.validate(uploadedFile, result);

		if (result.hasErrors()) {
			modelAndView.setViewName("index");
		} else {

			try {
				byte[] bytes = file.getBytes();
		
				fileName = file.getOriginalFilename();

				String rootPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
				String rootPath2 = request.getSession().getServletContext().getRealPath("/");
				//String rootPath3 = System.getProperty("catalina.home");
				logger.info("path: " + rootPath);
				logger.info("path2: " + rootPath2);
						
				File dir = new File(rootPath2 + "resources"+ File.separator);

				if (!dir.exists()) {
					dir.mkdirs();
				}

				File loadFile = new File(dir.getAbsolutePath() + File.separator + fileName);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
				stream.write(bytes);
				stream.flush();
				stream.close();

				logger.info("uploaded: " + loadFile.getAbsolutePath());

				RedirectView redirectView = new RedirectView("fileuploaded");
				redirectView.setStatusCode(HttpStatus.FOUND);
				modelAndView.setView(redirectView);
			
			    uploadedFile.setPath(rootPath +"/resources/"+fileName);
			    //modelAndView.addObject("filename", rootPath +"/resources/"+fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return modelAndView;
	}

	@RequestMapping(value = "/fileuploaded", method = RequestMethod.GET)
	public String fileUploaded() {
		return "fileuploaded";
	}

	
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("originalFile", file);
        
    }
    
}
