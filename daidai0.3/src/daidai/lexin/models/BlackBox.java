package daidai.lexin.models;

import java.sql.Timestamp;

public class BlackBox {
	private String user_id;
	private String blackbox_reson;
	private Timestamp blackbox_date;
	private Timestamp blackbox_longtime;
	public BlackBox(String user_id,String blackbox_reson, Timestamp blackbox_date, Timestamp blackbox_longtime) {
		super();
		this.blackbox_reson = blackbox_reson;
		this.blackbox_date = blackbox_date;
		this.blackbox_longtime = blackbox_longtime;
		this.user_id = user_id;
	}
	public String getBlackbox_reson() {
		return blackbox_reson;
	}
	public void setBlackbox_reson(String blackbox_reson) {
		this.blackbox_reson = blackbox_reson;
	}
	public Timestamp getBlackbox_date() {
		return blackbox_date;
	}
	public void setBlackbox_date(Timestamp blackbox_date) {
		this.blackbox_date = blackbox_date;
	}
	public Timestamp getBlackbox_longtime() {
		return blackbox_longtime;
	}
	public void setBlackbox_longtime(Timestamp blackbox_longtime) {
		this.blackbox_longtime = blackbox_longtime;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "黑盒子 [用户ID=" + user_id + ", 原因=" + blackbox_reson + ", 日期="
				+ blackbox_date + ", 期限=" + blackbox_longtime + "]";
	}
	
	
	
}
