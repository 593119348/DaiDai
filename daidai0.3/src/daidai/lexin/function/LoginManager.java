package daidai.lexin.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import daidai.lexin.SqlManager;
import daidai.lexin.inter.ILoginFunction;
import daidai.lexin.models.Login;

public class LoginManager {
	/***
	 * ��¼��¼
	 * @param login
	 * @return
	 */
	public static int addLoginRecode(Login login) {
		SqlSession session = SqlManager.getSession().openSession();
		ILoginFunction ilogin = session.getMapper(ILoginFunction.class);
		int state = -1;
		try {
			state = ilogin.insertLogin( login );
		} finally {
			ilogin = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * �����û�IDȡ�����µ�һ����¼��¼
	 * @param userid
	 * @return
	 */
	public static Login getNewLoginRecode(String userid) {
		SqlSession session = SqlManager.getSession().openSession();
		ILoginFunction ilogin = session.getMapper(ILoginFunction.class);
		Login login = null;
		try {
			login = ilogin.selectNewLoginByUserID(userid);
		} finally {
			ilogin = null;
			session.close();
		}
		return login;
	}
	
	/***
	 * ��ȡָ��ʱ��μ�¼����
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getLoginRecodeCount(String start,String end) {
		int res = 0;
		SqlSession session = SqlManager.getSession().openSession();
		ILoginFunction ilogin = session.getMapper(ILoginFunction.class);
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		try {
			res = ilogin.selectAllLoginByDate(map);
		} finally {
			ilogin = null;
			session.close();
		}
		return res;
	}
	
	/***
	 * ��ȡ��¼���������û�ID�ʹ���
	 * @param min
	 * @param max
	 * @return
	 */
	public static List<Map<String,Object>> countLogin(int min,int max) {
		SqlSession session = SqlManager.getSession().openSession();
		ILoginFunction ilogin = session.getMapper(ILoginFunction.class);
		Map<String, Integer> map = new HashMap<>();
		List<Map<String,Object>> list = null;
		map.put("min", min);
		map.put("max", max);
		try {
			list= ilogin.countLoginByUser(map);
		} finally {
			ilogin = null;
			session.close();
		}
		return list;
	}
	
	/***
	 * ��ȡ��¼�������ĵ�¼��ַ�ʹ���
	 * @param min
	 * @param max
	 * @return
	 */
	public static List<Map<String,Object>> countLoginAddress(int min,int max) {
		SqlSession session = SqlManager.getSession().openSession();
		ILoginFunction ilogin = session.getMapper(ILoginFunction.class);
		Map<String, Integer> map = new HashMap<>();
		List<Map<String,Object>> list = null;
		map.put("min", min);
		map.put("max", max);
		try {
			list= ilogin.countLoginByAddress(map);
		} finally {
			ilogin = null;
			session.close();
		}
		return list;
	}
	
	/***
	 * ��ȡ���е�¼��¼
	 * @param min
	 * @param max
	 * @return
	 */
	public static List<Login> selectAllLogin(int min,int max) {
		SqlSession session = SqlManager.getSession().openSession();
		ILoginFunction ilogin = session.getMapper(ILoginFunction.class);
		List<Login> list = null;
		Map<String, Integer> map = new HashMap<>();
		map.put("min", min);
		map.put("max", max);
		try {
			list= ilogin.selectAllLogin(map);
		} finally {
			ilogin = null;
			session.close();
		}
		return list;
	}
	
}
