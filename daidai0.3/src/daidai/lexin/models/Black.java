package daidai.lexin.models;

import java.sql.Timestamp;

public class Black {
	private String black_fromuserid;
	private String black_touserid;
	private Timestamp black_date;
	public Black(String black_fromuserid, String black_touserid, Timestamp black_date) {
		super();
		this.black_fromuserid = black_fromuserid;
		this.black_touserid = black_touserid;
		this.black_date = black_date;
	}
	public String getBlack_fromuserid() {
		return black_fromuserid;
	}
	public void setBlack_fromuserid(String black_fromuserid) {
		this.black_fromuserid = black_fromuserid;
	}
	public String getBlack_touserid() {
		return black_touserid;
	}
	public void setBlack_touserid(String black_touserid) {
		this.black_touserid = black_touserid;
	}
	public Timestamp getBlack_date() {
		return black_date;
	}
	public void setBlack_date(Timestamp black_date) {
		this.black_date = black_date;
	}
	@Override
	public String toString() {
		return "黑名单 [拉黑用户ID=" + black_fromuserid + ", 被拉黑用户ID="
				+ black_touserid + ", 日期=" + black_date + "]";
	}
	
	
}
