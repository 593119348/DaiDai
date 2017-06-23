package daidai.lexin.function;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import daidai.lexin.SqlManager;
import daidai.lexin.inter.IOperationFunction;
import daidai.lexin.models.Operation;

/***
 * ������¼����
 */
public class OperationManager {
	
	/***
	 * ��Ӳ�����¼
	 * @param op
	 * @return
	 */
	public static int addOperation(Operation op) {
		SqlSession session = SqlManager.getSession().openSession();
		IOperationFunction iop = session.getMapper(IOperationFunction.class);
		int state = -1;
		try {
			state = iop.insertOperation(op);
		} finally {
			iop = null;
			session.close();
		}
		return state;
	}
	
	/***
	 * ��ȡ�ù���Ա�û����в�����¼
	 * @param userid
	 * @param min
	 * @param max
	 * @param order
	 * @return
	 */
	public static List<Operation> GetAllAdminOperationByUser(String userid,int min,int max,String order) {
		SqlSession session = SqlManager.getSession().openSession();
		IOperationFunction iop = session.getMapper(IOperationFunction.class);
		List<Operation> list = null;
		try {
			list = iop.selectOperationByUserID(userid, min, max, order);
		} finally {
			session.close();
		}
		return list;
	}
	
	/***
	 * ɾ��ĳ��������¼
	 * @param id
	 * @return
	 */
	public static int delete(String id) {
		SqlSession session = SqlManager.getSession().openSession();
		IOperationFunction iop = session.getMapper(IOperationFunction.class);
		int state = -1;
		try {
			state = iop.deleteOperationByID(id);
		} finally {
			session.close();
		}
		return state;
	}
	
}
