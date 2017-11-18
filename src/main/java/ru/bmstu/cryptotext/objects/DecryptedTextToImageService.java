package ru.bmstu.cryptotext.objects;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.webflow.context.servlet.ServletExternalContext;
import org.springframework.webflow.execution.RequestContext;

@Component
public class DecryptedTextToImageService {
	private static int count = 0;
	private byte bitPerPixel = 0;
	private static String message = null;
	public ModelAndView encryptTextToImage(UploadedFile file, RequestContext context) throws IOException {

		ModelAndView mvn = new ModelAndView();	
		byte bitPerPixel = file.getBitCount();
		ServletExternalContext externalContext = (ServletExternalContext) context.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getNativeRequest();
		
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		String dir = rootPath +"/resources/";		
		
		message = getBinaryString(file.getMessage());
		System.out.println(message);
		
		bitPerPixel = file.getBitCount();
		
		BufferedImage image = ImageIO.read(file.getSourceFile());
		file.setWidth(image.getWidth());
		file.setHeight(image.getHeight());
		count = image.getHeight()*image.getWidth();
		String sourceFileName = file.getFileName();
		String encryptedFileName = sourceFileName.substring(0,sourceFileName.lastIndexOf("."))+"_enc"+sourceFileName.substring(sourceFileName.lastIndexOf("."),
				sourceFileName.length());
		String path = dir + encryptedFileName;	
		BufferedImage encImage = getEcncyptedImage(image);
		
		ImageIO.write(encImage, "jpg",new File(path));
		File encFile = new File(path);
		file.setEncryptedFile(encFile);
		file.setEncryptedFilePath(serverPath+"/resources/"+encFile.getName());
		


		
		mvn.setViewName("success");
		return mvn;		
	
	}
	public String getBinaryString(String s) {

	    char[] cArray=s.toCharArray();

	    StringBuilder sb=new StringBuilder();

	    for(char c:cArray)
	    {
	        String cBinaryString=Integer.toBinaryString((int)c);
	        sb.append(cBinaryString);
	    }

	    return sb.toString();
	}
	
	public String getBinaryString(Integer color) {
		StringBuilder sb = new StringBuilder("00000000");
		String binaryString = sb.append(Integer.toBinaryString(color)).toString(); 
		return binaryString.substring(binaryString.length()-8,binaryString.length()-1);
	}
	
	public String getBit(String mes) {
		String ch = mes.substring(0,1);
		if(message.length()>0) {
			message = message.substring(1,message.length());
		}
		
		return ch;
	}
	
	
	public BufferedImage getEcncyptedImage(BufferedImage image) {
		int width;
		int height;
		
		try {

			width = image.getWidth();
			height = image.getHeight();
			int num = 0;
			
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					num+=1;
					Color c = new Color(image.getRGB(j, i));
					String red = null;
					String green = null;
					String blue = null;
					
					if(message.length()>0) {
						
						System.out.println("Message " + message.length());
						
						red = getBinaryString(c.getRed());
						StringBuilder r = new StringBuilder(red);
						r.append(getBit(message));
						if(message.length()==0) break;
						
						green = getBinaryString(c.getGreen());
						StringBuilder g = new StringBuilder(green);
						g.append(getBit(message));
						if(message.length()==0) break;

						blue = getBinaryString(c.getBlue());
						StringBuilder b = new StringBuilder(blue);
						b.append(getBit(message));	
						if(message.length()==0) break;
						
						int newRed = Integer.parseInt(r.toString(),2);
						int newGreen = Integer.parseInt(g.toString(),2);
						int newBlue = Integer.parseInt(b.toString(),2);
						Color newColor = new Color(newRed, newGreen, newBlue);
						image.setRGB(j,i,newColor.getRGB());						
						
					}

					//System.out.println("red "+ c.getRGB()+"|"+newColor.getRGB());
					//System.out.println("$red "+ red+"|"+);
					//System.out.println("S.No: " + num + " Red: " + r.toString()+ "/" + c.getRed() + "Green: " + getBinaryString(c.getGreen()) + " Blue: "
					//		+getBinaryString(c.getBlue()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}

}
