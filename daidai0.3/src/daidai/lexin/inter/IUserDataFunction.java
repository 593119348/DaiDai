package daidai.lexin.inter;

import daidai.lexin.models.UserData;

public interface IUserDataFunction {
	public int insertUserData(UserData ud);
	public int deleteUserDataByID(String id);
	public int updateUserData(UserData ud);
	public UserData selectUserDataByUserID(String id);
}
