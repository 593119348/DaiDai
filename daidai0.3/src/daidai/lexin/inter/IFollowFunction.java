package daidai.lexin.inter;

import daidai.lexin.models.Follow;

public interface IFollowFunction {
	public int insertFollow(Follow f);
	public int deleteFollow(Follow f);
	public Follow selectFollowByFromUserID(String userid);
	public Follow selectFollowByToUserID(String userid);
}
