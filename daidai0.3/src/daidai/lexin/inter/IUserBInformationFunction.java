package daidai.lexin.inter;

import java.util.List;
import java.util.Map;

import daidai.lexin.models.UserBInformation;

public interface IUserBInformationFunction {
	public int insertUserBInformation(UserBInformation ub);
	public int deleteUserBInformationByID(String id);
	public int updateUserBInformation(UserBInformation ub);
	public UserBInformation selectUserBInformationByID(String id);
	public List<UserBInformation> selectAllUserBInformationByLevel(Map<String, Object> map);
}
