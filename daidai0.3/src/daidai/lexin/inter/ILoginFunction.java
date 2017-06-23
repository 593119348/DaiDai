package daidai.lexin.inter;

import java.util.List;
import java.util.Map;

import daidai.lexin.models.Login;

public interface ILoginFunction {
	public int insertLogin(Login l);
	public int deleteLoginByUserID(String id);
	public Login selectNewLoginByUserID(String id);
	public int selectAllLoginByDate(Map<String,Object> map);
	public List<Map<String, Object>> countLoginByUser(Map<String,Integer> map);
	public List<Map<String, Object>> countLoginByAddress(Map<String,Integer> map);
	public List<Login> selectAllLogin(Map<String,Integer> map);
}
