package daidai.lexin.inter;

import daidai.lexin.models.BlackBox;

public interface IBlackBoxFunction {
	public int insertBlackBox(BlackBox bb);
	public int deleteBlackBoxByUserID(String userid);
	public int updateBlackBox(BlackBox bb);
	public BlackBox selectBlackBoxByUserID(String userid);
}
