package daidai.lexin.models;

import java.sql.Timestamp;

public class WhiteBox {
	private String user_id;
	private Integer whitebox_level;
	private Timestamp whitebox_date;
	private Timestamp whitebox_longtime;
	public WhiteBox(String user_id, Integer whitebox_level, Timestamp whitebox_date, Timestamp whitebox_longtime) {
		super();
		this.user_id = user_id;
		this.whitebox_level = whitebox_level;
		this.whitebox_date = whitebox_date;
		this.whitebox_longtime = whitebox_longtime;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getWhitebox_level() {
		return whitebox_level;
	}
	public void setWhitebox_level(Integer whitebox_level) {
		this.whitebox_level = whitebox_level;
	}
	public Timestamp getWhitebox_date() {
		return whitebox_date;
	}
	public void setWhitebox_date(Timestamp whitebox_date) {
		this.whitebox_date = whitebox_date;
	}
	public Timestamp getWhitebox_longtime() {
		return whitebox_longtime;
	}
	public void setWhitebox_longtime(Timestamp whitebox_longtime) {
		this.whitebox_longtime = whitebox_longtime;
	}
	@Override
	public String toString() {
		return "白盒子 [用户ID=" + user_id + ", 等级=" + whitebox_level + ", 日期="
				+ whitebox_date + ", 期限=" + whitebox_longtime + "]";
	}
	
	
}
