package daidai.lexin;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



/***
 * ���ڳ�ʼ��Sql�Ự
 * @author Lexin
 *
 */
public class SqlManager {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static{
		try{
			reader = Resources.getResourceAsReader("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    private SqlManager(){}
    
    /***
     * ��ȡ�Ự
     * @return
     */
    public static SqlSessionFactory getSession() {
    		return sqlSessionFactory;
    }
 

}
