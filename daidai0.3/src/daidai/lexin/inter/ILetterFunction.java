package daidai.lexin.inter;

import daidai.lexin.models.Letter;

public interface ILetterFunction {
	public int insertLetter(Letter l);
	public int deleteLetterByLetterID(String id);
	public int updateLetter(Letter l);
	public Letter selectLetterByLetterID(String id);
}
