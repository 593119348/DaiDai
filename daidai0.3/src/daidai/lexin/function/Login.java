package daidai.lexin.function;

import java.sql.Timestamp;
import java.util.Date;
import daidai.lexin.models.User;

/***
 * 用户登录
 * @author Lexin
 *
 */
public class Login{
	private User user;
	private String ip,address;
	
	/***
	 * 构造函数
	 * @param phoneNumber
	 * @param password
	 */
	public Login(String phoneNumber,String password,String ip,String address) {
		user = UserManager.getUserByPhoneAndPassword(phoneNumber, password);
		this.ip = ip;
		this.address = address;
	}

	/***
	 * 执行登录事务
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
