package daidai.lexin.function;

import java.sql.Timestamp;
import java.util.Date;


import daidai.lexin.models.User;
import daidai.lexin.models.UserBInformation;
import daidai.lexin.models.UserDInformation;
import daidai.lexin.models.UserData;
import daidai.lexin.models.UserVInformation;
import daidai.lexin.util.StringFactory;

/***
 * 用于用户注册
 * @author Lexin
 *
 */
public class Register{
	private String phoneNumber,password;
	
	/***
	 * 构造函数
	 * @param phoneNumber
	 * @param password
	 */
	public Register(String phoneNumber,String password) {
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	/***
	 * 执行注册操作
	 * 将用户信息插入数据库
	 * 返回值说明
	 * -2：内部错误
	 * 0：执行失败
	 * 1：执行成功
	 * 返回值为一个整型数组
	 * 第一位数：插入数据库结果
	 * 第二位数：电话号码检查结果
	 * 第三位数：密码检查结果
	 * @return int[]
	 */
	public Integer execute() {
		int state = -1;
		if ( phoneNumber.matches(Constant.REGISTER_PHONENUMBER_MATCHES) && null==UserManager.getUserByPhone(phoneNumber) ) {
			state = 0;
			if (password.matches(Constant.REGISTER_PASSWORD_MATCHES)) {
				String ID = StringFactory.markID(phoneNumber);
				User user = new User(ID, phoneNumber, password,0,0);
				UserVInformation uv = new UserVInformation(ID,"0", 0, null, "0", 0, 0, 0, 0);
				UserBInformation ub = new UserBInformation(ID,null, null, null, null, null, null, new Timestamp(new Date().getTime()));
				UserDInformation ud = new UserDInformation(ID,null, null, null, null, null, null);
				UserData userData = new UserData(user.getUserid(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				UserManager.addUser(user);
				UserManager.addUserVInformation(uv);
				UserManager.addUserBInformation(ub);
				UserManager.addUserDInformation(ud);
				UserManager.addUserData(userData);
				state = 1;
			}
		}
		return state;
	}

}
