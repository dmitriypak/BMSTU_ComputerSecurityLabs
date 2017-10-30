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
	private int shift = 0;
    private String txtEncryption = "";
    private int x;
    private static Map<Character,Integer> mapChars;
    private static ArrayList<Character> listChars;	
	
	
	public ModelAndView encryptMessage(EncryptedMessage message, RequestContext context) {
		ModelAndView mvn = new ModelAndView();
		
		
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
                System.out.println(ch);
            }

        }
        System.out.println(mapChars.size());		
		
		
		
		System.out.println(message.getMessage());
		System.out.println(message.getShift());
		
		count+=1;
		message.setCountShifts(count);
		mvn.setViewName("success");
		return mvn;
	}
	
}
