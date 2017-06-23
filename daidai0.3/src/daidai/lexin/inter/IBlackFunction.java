package daidai.lexin.inter;

import daidai.lexin.models.Black;

public interface IBlackFunction {
	public int insertBlack(Black b);
	public int deleteBlack(Black b);
	public Black selectBlackByFromUserID(String userid);
	public Black selectBlackByToUserID(String userid);
}
