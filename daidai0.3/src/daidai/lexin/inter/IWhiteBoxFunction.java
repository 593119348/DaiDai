package daidai.lexin.inter;

import java.util.List;

import daidai.lexin.models.WhiteBox;

public interface IWhiteBoxFunction {
	public int insertWhiteBox(WhiteBox wb);
	public int deleteWhiteBoxByUserID(String id);
	public int updateWhiteBox(WhiteBox wb);
	public WhiteBox selectWhiteBoxByUserID(String id);
	public List<WhiteBox> selectAllWhiteBoxByLevel(int level,int min,int max,String order);
}
