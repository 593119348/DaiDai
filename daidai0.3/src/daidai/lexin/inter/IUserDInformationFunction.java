package daidai.lexin.inter;

import daidai.lexin.models.UserDInformation;

public interface IUserDInformationFunction {
	public int insertUserDInformation(UserDInformation ud);
	public int deleteUserDInformationByID(String id);
	public int updateUserDInformation(UserDInformation ud);
	public UserDInformation selectUserDInformationByID(String id);
}
