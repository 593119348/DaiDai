package daidai.lexin.function;

import java.io.IOException;

import daidai.lexin.util.MobileMessageSend;

/***
 * 事务抽象类
 * @author Lexin
 *
 */
public class VerifyCodeManager {
	
	/***
	 * 发送验证码到手机
	 * @param phone
	 * @return
	 */
	public static int sendMesForPhone(String phone) {
		int state = 500;
		try {
			state = MobileMessageSend.haveReadySendMsg(phone);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return state;
	}
	
	/***
	 * 核对验证码
	 * @param phone
	 * @param code
	 * @return
	 */
	public static int verifycode(String phone,String code) {
		int state = 500;
		try {
			state = MobileMessageSend.verifycode(phone, code);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return state;
	}
	
}
