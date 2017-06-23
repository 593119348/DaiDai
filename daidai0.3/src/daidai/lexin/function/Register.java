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
 * �����û�ע��
 * @author Lexin
 *
 */
public class Register{
	private String phoneNumber,password;
	
	/***
	 * ���캯��
	 * @param phoneNumber
	 * @param password
	 */
	public Register(String phoneNumber,String password) {
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	/***
	 * ִ��ע�����
	 * ���û���Ϣ�������ݿ�
	 * ����ֵ˵��
	 * -2���ڲ�����
	 * 0��ִ��ʧ��
	 * 1��ִ�гɹ�
	 * ����ֵΪһ����������
	 * ��һλ�����������ݿ���
	 * �ڶ�λ�����绰��������
	 * ����λ������������
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
