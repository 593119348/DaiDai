package daidai.lexin.util;

import java.util.Date;
import java.util.Random;

public class StringFactory {
	
	public static final char[] chars = new char[]{
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0',
			'1','2','3','4','5','6','7','8','9'};
	
	
	public static String getString(String str) {
		StringBuffer sb = new StringBuffer(str);
		sb.append(String.valueOf( new Date().getTime() ));
		sb.append( String.valueOf( new Random().nextInt(90)+10 ) );
		return sb.toString();
	}
	
	public static String getString(int len) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			sb.append( StringFactory.chars[new Random().nextInt(StringFactory.chars.length)] );
		}
		return sb.toString();
	}
	
	
	/***
	 * ID生成器
	 * 根据手机号码和当前时间加上三位随机数生成ID
	 * @param phoneNumber
	 * @return
	 */
	public static String markID(String phoneNumber) {
		Long time = new Date().getTime();
		int ran = new Random().nextInt(900)+100;
		return phoneNumber+time+ran;
	}
	
}
