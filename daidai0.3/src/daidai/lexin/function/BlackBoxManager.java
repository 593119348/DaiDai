package daidai.lexin.function;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import daidai.lexin.SqlManager;
import daidai.lexin.inter.IBlackBoxFunction;
import daidai.lexin.models.BlackBox;
import daidai.lexin.models.User;

public class BlackBoxManager {
	private BlackBoxManager() {}
	
	/***
	 * 拉黑用户
	 * @param reson
	 * @param longtime
	 * @return
	 */
	public static int addBlackBox(String userid, String reson,long longtime) {
		int state = -1;
		User user = UserManager.getUserByUserID(userid);
		if (null!=user) {
			SqlSession session = SqlManager.getSession().openSession();
			IBlackBoxFunction ibb = session.getMapper(IBlackBoxFunction.class);
			user.setIsblackbox(1);
			long now = new Date().getTime();
			if( null==getBlackBox(userid) ) {
				try{
					state = ibb.insertBlackBox( new BlackBox(userid, reson, new Timestamp(now), new Timestamp(now+longtime)) );
					state = state==1? UserManager.updateUser(user) : state;
				} finally {
					ibb = null;
					session.close();
				}
			} else {
				try{
					state = ibb.updateBlackBox( new BlackBox(userid, reson, new Timestamp(now), new Timestamp(now+longtime)) );
					state = state==1? UserManager.updateUser(user) : state;
				} finally {
					ibb = null;
					session.close();
				}
			}
		}
		return state;
	}
	
	/***
	 * 获取用户黑名单记录
	 * @return
	 */
	public static BlackBox getBlackBox(String userid) {
		SqlSession session = SqlManager.getSession().openSession();
		IBlackBoxFunction ibb = session.getMapper(IBlackBoxFunction.class);
		BlackBox bb = null;
		try{
			bb = ibb.selectBlackBoxByUserID(userid);
		} finally {
			session.close();
		}
		if (null!=bb && null!=bb.getBlackbox_longtime() && bb.getBlackbox_longtime().before(new Timestamp(new Date().getTime())) ) {
			removeBlackBoxByUserID(userid);
			bb = null;
		}
		return bb;
	}
	
	/***
	 * 删除用户黑名单记录
	 * @return
	 */
	public static int removeBlackBoxByUserID(String userid) {
		int state = -1;
		User user = UserManager.getUserByUserID(userid);
		user.setIsblackbox(0);
		if (null!=user) {
			SqlSession session = SqlManager.getSession().openSession();
			IBlackBoxFunction ibb = session.getMapper(IBlackBoxFunction.class);
			try{
				state = ibb.deleteBlackBoxByUserID(userid);
				state = state==1 ? UserManager.updateUser(user) : state;
			} finally {
				ibb = null;
				session.close();
			}
		}
		return state;
	}
}
