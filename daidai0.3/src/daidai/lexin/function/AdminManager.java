package daidai.lexin.function;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import daidai.lexin.SqlManager;
import daidai.lexin.inter.IWhiteBoxFunction;
import daidai.lexin.models.User;
import daidai.lexin.models.WhiteBox;

public class AdminManager {
	
	/***
	 * 获取所有低等级的管理员用户
	 * @param level
	 * @param min
	 * @param max
	 * @param order
	 * @return
	 */
	public static List<WhiteBox> getAllAdminByUserID(int level,int min,int max,String order) {
		List<WhiteBox> list = null;
		SqlSession session = SqlManager.getSession().openSession();
		try{
			IWhiteBoxFunction admin = session.getMapper(IWhiteBoxFunction.class);
			list = admin.selectAllWhiteBoxByLevel(level, min, max, order);
		} finally {
			session.close();
		}
		return list;
	}

	/***
	 * 添加管理员
	 * @param userid
	 * @param level
	 * @param start
	 * @param end
	 * @return
	 */
	public static int addAdmin(String userid,int level,long start,long end) {
		int state = -1;
		User user = UserManager.getUserByUserID(userid);
		if (null!=user) {
			SqlSession session = SqlManager.getSession().openSession();
			IWhiteBoxFunction iwb = session.getMapper(IWhiteBoxFunction.class);
			user.setIswhitebox(1);
			if (null==getAdminByUser(userid)) {
				try{
					state = iwb.insertWhiteBox( new WhiteBox(userid, level, new Timestamp(start), end==0?null:new Timestamp(end)) );
					state = state==1?  UserManager.updateUser(user)  : state;
				} finally {
					iwb = null;
					session.close();
				}
			} else {
				try{
					state = iwb.updateWhiteBox( new WhiteBox(userid, level, new Timestamp(start), end==0?null:new Timestamp(end)) );
					state = state==1?  UserManager.updateUser(user)  : state;
				} finally {
					iwb = null;
					session.close();
				}
			}
		}
		return state;
	}
	
	/***
	 * 获取管理员信息
	 * @param user
	 * @return
	 */
	public static WhiteBox getAdminByUser(String userid) {
		SqlSession session = SqlManager.getSession().openSession();
		IWhiteBoxFunction iwb = session.getMapper(IWhiteBoxFunction.class);
		WhiteBox wb = null;
		try{
			wb = iwb.selectWhiteBoxByUserID(userid);
		} finally {
			session.close();
		}
		if (null!=wb && null!=wb.getWhitebox_longtime() && wb.getWhitebox_longtime().before(new Timestamp(new Date().getTime())) ) {
			removeAdminByUser(userid);
			wb = null;
		}
		return wb;
	}
	
	/***
	 * 删除白盒子身份
	 * @param user
	 * @return
	 */
	public static int removeAdminByUser(String userid) {
		int state = -1;
		User user = UserManager.getUserByUserID(userid);
		if (null!=user) {
			SqlSession session = SqlManager.getSession().openSession();
			IWhiteBoxFunction iwb = session.getMapper(IWhiteBoxFunction.class);
			user.setIswhitebox(0);
			try{
				state = iwb.deleteWhiteBoxByUserID(userid);
				state = state==1? UserManager.updateUser(user) : state;
			} finally {
				iwb = null;
				session.close();
			}
		}
		return state;
	}
	
}
