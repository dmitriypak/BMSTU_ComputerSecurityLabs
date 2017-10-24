package ru.bmstu.cryptotext.objects;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.webflow.context.servlet.ServletExternalContext;
import org.springframework.webflow.execution.RequestContext;

@Component
public class UploadedFileService {
	
	public ModelAndView checkFile(UploadedFile file, RequestContext context) {
		ModelAndView mav = new ModelAndView();
		ServletExternalContext externalContext = (ServletExternalContext) context.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getNativeRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getNativeResponse();		
		MultipartFile uploadedFile = null;
		if (file.getFile()!=null) {
//			Map<?,?>map = new LinkedHashMap<>();
//			map = context.getFlowScope().asMap();
//			context.getFlowScope().get("file");
//			uploadedFile = (UploadedFile) context.getFlowScope().get("file");
//			for(Map.Entry<?, ?> item:map.entrySet()) {
//				uploadedFile = (UploadedFile) item.getValue();
//				System.out.println("$$$ полученный файл " + uploadedFile.getFile().getOriginalFilename());
//				System.out.println(item.getKey());
//		
//			}
//			mapParam = context.getRequestParameters().asMap();
			uploadedFile = file.getFile();
			String rootPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
			String rootPath2 = request.getSession().getServletContext().getRealPath("/");
			String fileName =uploadedFile.getOriginalFilename();
			file.setPath(rootPath +"/resources/"+fileName);
			createNewFile(rootPath2,uploadedFile);
			System.out.println("$$$ полученные параметры " + rootPath);
			System.out.println(rootPath2);
			mav.setViewName("success");
			return mav;
		} else {
			mav.setViewName("failed");
			return mav;
		}

	}
	private void createNewFile(String path, MultipartFile file) {
		try {
			File dir = new File(path + "resources"+ File.separator);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File loadFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
			stream.write(bytes);
			stream.flush();
			stream.close();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
