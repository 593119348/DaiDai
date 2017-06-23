package daidai.lexin.models;

import java.sql.Timestamp;

public class Follow {
	private String follow_fromuserid;
	private String follow_touserid;
	private Timestamp follow_date;
	public Follow(String follow_fromuserid, String follow_touserid, Timestamp follow_date) {
		super();
		this.follow_fromuserid = follow_fromuserid;
		this.follow_touserid = follow_touserid;
		this.follow_date = follow_date;
	}
	public String getFollow_fromuserid() {
		return follow_fromuserid;
	}
	public void setFollow_fromuserid(String follow_fromuserid) {
		this.follow_fromuserid = follow_fromuserid;
	}
	public String getFollow_touserid() {
		return follow_touserid;
	}
	public void setFollow_touserid(String follow_touserid) {
		this.follow_touserid = follow_touserid;
	}
	public Timestamp getFollow_date() {
		return follow_date;
	}
	public void setFollow_date(Timestamp follow_date) {
		this.follow_date = follow_date;
	}
	@Override
	public String toString() {
		return "关注 [关注ID=" + follow_fromuserid + ", 被关注用户ID=" + follow_touserid
				+ ", 关注日期=" + follow_date + "]";
	}
	
	
}
