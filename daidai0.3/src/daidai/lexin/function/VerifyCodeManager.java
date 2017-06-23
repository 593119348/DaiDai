package daidai.lexin.function;

import java.io.IOException;

import daidai.lexin.util.MobileMessageSend;

/***
 * ���������
 * @author Lexin
 *
 */
public class VerifyCodeManager {
	
	/***
	 * ������֤�뵽�ֻ�
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
	 * �˶���֤��
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
