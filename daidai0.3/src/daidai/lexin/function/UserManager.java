package daidai.lexin.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import daidai.lexin.SqlManager;
import daidai.lexin.inter.IUserBInformationFunction;
import daidai.lexin.inter.IUserDInformationFunction;
import daidai.lexin.inter.IUserDataFunction;
import daidai.lexin.inter.IUserFunction;
import daidai.lexin.inter.IUserVInformationFunction;
import daidai.lexin.models.User;
import daidai.lexin.models.UserBInformation;
import daidai.lexin.models.UserDInformation;
import daidai.lexin.models.UserData;
import daidai.lexin.models.UserVInformation;
import daidai.lexin.models.WhiteBox;

public class UserManager {
	
	/***
	 * ����û�
	 * @param user
	 * @return
	 */
	public static int addUser(User user) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserFunction iu = session.getMapper(IUserFunction.class);
		int state = -1;
		try {
			state = iu.insertUser(user);
		} finally {
			iu = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * ����û�������Ϣ
	 * @param uv
	 * @return
	 */
	public static int addUserVInformation(UserVInformation uv) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserVInformationFunction iuv = session.getMapper(IUserVInformationFunction.class);
		int state = -1;
		try {
			state = iuv.insertUserVInformation(uv);
		} finally {
			iuv = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * ����û�������Ϣ
	 * @param ub
	 * @return
	 */
	public static int addUserBInformation(UserBInformation ub) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserBInformationFunction iub = session.getMapper(IUserBInformationFunction.class);
		int state = -1;
		try {
			state = iub.insertUserBInformation(ub);
		} finally {
			iub = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * ����û���ϸ��Ϣ
	 * @param ud
	 * @return
	 */
	public static int addUserDInformation(UserDInformation ud) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserDInformationFunction iud = session.getMapper(IUserDInformationFunction.class);
		int state =  -1;
		try {
			state = iud.insertUserDInformation(ud);
		} finally {
			iud = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * ����û�����
	 * @param ud
	 * @return
	 */
	public static int addUserData(UserData ud) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserDataFunction iud = session.getMapper(IUserDataFunction.class);
		int state = -1;
		try {
			state = iud.insertUserData(ud);
		} finally {
			iud = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * ɾ���û�
	 * @param userid
	 * @return
	 */
	public static int removeUserByUserID(String userid) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserFunction iu = session.getMapper(IUserFunction.class);
		int state = -1;
		try {
			state = iu.deleteUserByUserID(userid);
		} finally {
			iu = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * �����û�
	 * @param user
	 * @return
	 */
	public static int updateUser(User user) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserFunction iu = session.getMapper(IUserFunction.class);
		int state = -1;
		try {
			state = iu.updateUser(user);
		} finally {
			iu = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * ��ȡ�����û�
	 * @param min
	 * @param max
	 * @param order
	 * @return
	 */
	public static List<User> getAllUser(int min,int max,String order) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserFunction iu = session.getMapper(IUserFunction.class);
		List<User> list = null;
		Map<String, Object> map = new HashMap<>();
		map.put("min", min);
		map.put("max", max);
		map.put("order", order);
		try {
			list = iu.selectAllUser(map); 
		} finally {
			iu = null;
			map = null;
			session.close();
		}
		return list;
	}
	
	/***
	 * ��ȡ�����û�������Ϣ
	 * @param userid
	 * @param min
	 * @param max
	 * @param order
	 * @return
	 */
	public static List<UserBInformation> getAllUserBInformationByUserID(String userid,int min,int max,String order) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserBInformationFunction iub = session.getMapper(IUserBInformationFunction.class);
		List<UserBInformation> list = null;
		WhiteBox wb = AdminManager.getAdminByUser(userid);
		if (null!=wb) {
			Map<String, Object> map = new HashMap<>();
			map.put("level", wb.getWhitebox_level());
			map.put("min", min);
			map.put("max", max);
			map.put("order", order);
			try {
				list = iub.selectAllUserBInformationByLevel(map);
			} finally {
				iub = null;
				session.close();
			}
		}
		return list;
	}
	
	/***
	 * �����û�������Ϣ
	 * @param uv
	 * @return
	 */
	public static int updateVInformation(UserVInformation uv) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserVInformationFunction iuv = session.getMapper(IUserVInformationFunction.class);
		int state = -1;
		try {
			state = iuv.updateUserVInformation(uv);
		} finally {
			iuv = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * �����û�������Ϣ
	 * @param ub
	 * @return
	 */
	public static int updateBInformation(UserBInformation ub) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserBInformationFunction iub = session.getMapper(IUserBInformationFunction.class);
		int state = -1;
		try {
			state = iub.updateUserBInformation(ub);
		} finally {
			iub = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * �����û���ϸ��Ϣ
	 * @param ud
	 * @return
	 */
	public static int updateDInformation(UserDInformation ud) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserDInformationFunction iud = session.getMapper(IUserDInformationFunction.class);
		int state = -1;
		try {
			state = iud.updateUserDInformation(ud);
		} finally {
			iud = null;
			session.close();
		}
		return	state;
	}

	/***
	 * �����û�����
	 * @param userData
	 * @return
	 */
	public static int updateUserData(UserData userData) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserDataFunction iud = session.getMapper(IUserDataFunction.class);
		int state = -1;
		try {
			state = iud.updateUserData(userData);
		} finally {
			iud = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * ��ȡ�û�������Ϣ
	 * @param user
	 * @return
	 */
	public static UserVInformation getVInformationByUser(String userid) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserVInformationFunction iuv = session.getMapper(IUserVInformationFunction.class);
		UserVInformation uv = null;
		try {
			uv = iuv.selectUserVInformationByUserID(userid);
		} finally {
			iuv = null;
			session.close();
		}
		return uv;
	}
	
	/***
	 * ��ȡ�û�������Ϣ
	 * @param user
	 * @return
	 */
	public static UserBInformation getBInformationByUser(String userid) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserBInformationFunction iub = session.getMapper(IUserBInformationFunction.class);
		UserBInformation ub = null;
		try {
			ub = iub.selectUserBInformationByID(userid);
		} finally {
			iub = null;
			session.close();
		}
		return ub;
	}
	
	/***
	 * ��ȡ�û���ϸ��Ϣ
	 * @param user
	 * @return
	 */
	public static UserDInformation getDInformationByUser(String userid) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserDInformationFunction iud = session.getMapper(IUserDInformationFunction.class);
		UserDInformation ud = null;
		try {
			ud = iud.selectUserDInformationByID(userid);
		} finally {
			iud = null;
			session.close();
		}
		return ud;
	}
	
	/***
	 * ��ȡ�û�����
	 * @param user
	 * @return
	 */
	public static UserData getUserDataByUser(String userid) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserDataFunction iud = session.getMapper(IUserDataFunction.class);
		UserData ud = null;
		try {
			ud = iud.selectUserDataByUserID(userid);
		} finally {
			iud = null;
			session.close();
		}
		return ud;
	}
	
	/***
	 * �����ֻ��ź������ȡ�û�
	 * @param phoneNumber
	 * @param password
	 * @return
	 */
	public static User getUserByPhoneAndPassword(String phoneNumber,String password) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserFunction iu = session.getMapper(IUserFunction.class);
		User user = null;
		Map<String, Object> map = new HashMap<>();
		map.put("user_phone", phoneNumber);
		map.put("user_password", password);
		try {
			user = iu.selectUserByPhoneAndPassword( map );
		} finally {
			iu = null;
			session.close();
		}
		return user;
	}
	
	/***
	 * �����ֻ��Ż�ȡ�û�
	 * @param phone
	 * @return
	 */
	public static User getUserByPhone(String phone) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserFunction iu = session.getMapper(IUserFunction.class);
		User user = null;
		try{
			user = iu.selectUserByPhone(phone);
		} finally {
			iu = null;
			session.close();
		}
		return user;
	}
	
	/***
	 * �����û�ID��ȡ�û�
	 * @param userid
	 * @return
	 */
	public static User getUserByUserID(String userid) {
		SqlSession session = SqlManager.getSession().openSession();
		IUserFunction iu = session.getMapper(IUserFunction.class);
		User user = null;
		try{
			user = iu.selectUserByID(userid);
		} finally {
			iu = null;
			session.close();
		}
		return user;
	}
	
	
}
