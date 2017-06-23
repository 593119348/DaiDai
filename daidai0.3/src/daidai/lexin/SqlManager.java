package daidai.lexin;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



/***
 * 用于初始化Sql会话
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
     * 获取会话
     * @return
     */
    public static SqlSessionFactory getSession() {
    		return sqlSessionFactory;
    }
 

}
