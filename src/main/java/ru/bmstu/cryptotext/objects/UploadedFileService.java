package ru.bmstu.cryptotext.objects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.webflow.execution.RequestContext;

@Component
public class UploadedFileService {
	
	public String checkFile(UploadedFile file, RequestContext context) {
		System.out.println(context.getFlowScope().asMap());
//		String rootPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
//		String rootPath2 = request.getSession().getServletContext().getRealPath("/");
		if (file.getFile()!=null) {
			Map<?,?>map = new LinkedHashMap<>();
			map = context.getFlowScope().asMap();
			for(Map.Entry<?, ?> item:map.entrySet()) {
				UploadedFile uploadedFile = (UploadedFile) item.getValue();
				System.out.println("$$$ полученный файл " + uploadedFile.getFile().getOriginalFilename());
				System.out.println(item.getKey());
			}
			return "success";
		} else {
			return "failed";
		}

	}
}
