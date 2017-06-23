package daidai.lexin.function;

import java.sql.Timestamp;
import java.util.Date;
import daidai.lexin.models.User;

/***
 * �û���¼
 * @author Lexin
 *
 */
public class Login{
	private User user;
	private String ip,address;
	
	/***
	 * ���캯��
	 * @param phoneNumber
	 * @param password
	 */
	public Login(String phoneNumber,String password,String ip,String address) {
		user = UserManager.getUserByPhoneAndPassword(phoneNumber, password);
		this.ip = ip;
		this.address = address;
	}

	/***
	 * ִ�е�¼����
	 */
	public User execute() {
		if(null!=user) {
			if( null==BlackBoxManager.getBlackBox(user.getUserid()) ) {
				LoginManager.addLoginRecode( 
						new daidai.lexin.models.Login(
								daidai.lexin.models.Login.markID(user.getUserid(),ip), 
								ip, 
								address, 
								new Timestamp(new Date().getTime()), 
								user.getUserid()
							)
						);
			} else {
				user = null;
			}
		}
		return user;
	}
	
}
