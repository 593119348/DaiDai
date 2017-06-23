package daidai.lexin.inter;

import daidai.lexin.models.UserVInformation;

public interface IUserVInformationFunction {
	public int insertUserVInformation(UserVInformation uv);
	public int deleteUserVInformationByID(String id);
	public int updateUserVInformation(UserVInformation uv);
	public UserVInformation selectUserVInformationByUserID(String id);
}
