package com.code;
 
import com.zhenzi.sms.ZhenziSmsClient;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Code {
    public static String getNum(String phone) throws Exception{

        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "107731", "5a1248e4-489f-45ce-854b-4a9c38e6c5d3");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("number", phone);
        params.put("templateId", "3082");
        String[] templateParams = new String[2];
        templateParams[0] = getVerifyCode();
        templateParams[1] = "5分钟";
        params.put("templateParams", templateParams);
        String result = client.send(params);
        return  templateParams[0];
    }
    //产生随机数
    public static String getVerifyCode() {
		String ch = "1234567890";
		String result = "";
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(ch.length());
			char c = ch.charAt(index);
			result += c;
		}
		return result;
	}
	public static void main(String[] args)  {
		try {
			Code.getNum("18775756179");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}