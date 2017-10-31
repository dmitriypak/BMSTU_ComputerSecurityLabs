package ru.bmstu.cryptotext.objects;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.webflow.execution.RequestContext;

@Component
public class EncryptedMessageService {
	private static int count = 0;
    private static Map<Character,Integer> mapChars;
    private static ArrayList<Character> listChars;	
	
	public ModelAndView encryptMessageLeft(EncryptedMessage message, RequestContext context) {
		ModelAndView mvn = new ModelAndView();	
		count-=1;
		message.setCountShifts(count);
		mvn.setViewName("success");
		message.setKof(-1);
		message.setEncmessage(caesarEncrypt(message));
		return mvn;		
	}
	
	public ModelAndView encryptMessageRight(EncryptedMessage message, RequestContext context) {
		ModelAndView mvn = new ModelAndView();	
		count+=1;
		message.setCountShifts(count);
		mvn.setViewName("success");
		message.setKof(1);
		message.setEncmessage(caesarEncrypt(message));
		return mvn;		
	}

	private String caesarEncrypt(EncryptedMessage message) {
		String sourceMessage = message.getMessage();
		String encMessage = null;
		
		char[] ceasar = new char[sourceMessage.length()];
		System.out.println(message.getShift());
		StringBuilder res = new StringBuilder();
		
		mapChars = new LinkedHashMap<>();
		listChars = new ArrayList<>();
		
		Pattern p = Pattern.compile("[A-Za-zÀ-ßà-ÿ¸¨0-9]*");
		Matcher m;
		int num = 0;
		for (int i = 0; i < 1200; i++) {
		    char ch = (char)i;
		    m = p.matcher("" + ch);
		    if (m.matches()) {
		        num++;
		        mapChars.put(ch,num);
		        listChars.add(ch);
		        //System.out.println(ch);
		    }
		}			
		
        if(message.getEncmessage().length()==0){
        	sourceMessage.getChars(0, sourceMessage.length(), ceasar, 0);
        }
        else{
        	message.getEncmessage().getChars(0, message.getEncmessage().length(), ceasar, 0);
        }	
        

       
	    for(int j=0;j<ceasar.length;j++){
	    	Integer val = 0;
	    	
	    	m = p.matcher("" + ceasar[j]);

	    	if (!m.matches()) {
	    		res.append(""+ceasar[j]);
	    		continue;	    		
	    	}
	    	val = mapChars.get(ceasar[j])-1;
	        
	        
	        int s = (val+message.getShift()*message.getKof())%listChars.size();
	        if(s<0) {
	        	res.append(listChars.get(listChars.size()+s));
	        }else {
	        	res.append(listChars.get(s));
	        }
	        
	
	    }       
        

		return res.toString();
	}
}
