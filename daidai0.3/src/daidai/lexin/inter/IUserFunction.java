package daidai.lexin.inter;

import java.util.List;
import java.util.Map;

import daidai.lexin.models.User;

public interface IUserFunction {
	public int insertUser(User u);
	public int deleteUserByUserID(String id);
	public int updateUser(User u);
	public List<User> selectAllUser(Map<String, Object> map);
	public User selectUserByID(String id);
	public User selectUserByPhone(String phone);
	public User selectUserByPhoneAndPassword(Map<String, Object> map);
}
