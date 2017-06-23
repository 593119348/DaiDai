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
	 * 登录记录
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
	 * 根据用户ID取得最新的一条登录记录
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
	 * 获取指定时间段记录数量
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
	 * 获取登录次数最多的用户ID和次数
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
	 * 获取登录次数最多的登录地址和次数
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
	 * 获取所有登录记录
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
