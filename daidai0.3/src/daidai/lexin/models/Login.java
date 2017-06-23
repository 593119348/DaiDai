package daidai.lexin.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

public class Login {
	private String login_id;
	private String login_ip;
	private String login_address;
	private Timestamp login_date;
	private String user_id;
	public Login(String login_id, String login_ip, String login_address, Timestamp login_date, String user_id) {
		super();
		this.login_id = login_id;
		this.login_ip = login_ip;
		this.login_address = login_address;
		this.login_date = login_date;
		this.user_id = user_id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getLogin_address() {
		return login_address;
	}
	public void setLogin_address(String login_address) {
		this.login_address = login_address;
	}
	public Timestamp getLogin_date() {
		return login_date;
	}
	public void setLogin_date(Timestamp login_date) {
		this.login_date = login_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "登录记录 [ID=" + login_id + ", IP=" + login_ip + ", 地址=" + login_address
				+ ", 日期=" + login_date + ", 用户ID=" + user_id + "]";
	}
	
	/***
	 * 根据用户ID生成LoginID
	 * 由用户ID加时间Long和两位随机数合成
	 * @param userid
	 * @return
	 */
	public static String markID(String userid,String ip) {
		String[] ipArr = ip.split("\\.");
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<ipArr.length;i++) {
			for(int z=ipArr[i].length();z<3;z++) {
				sb.append("0");
			}
			sb.append(ipArr[i]);
		}
		Long time = new Date().getTime();
		int ran = new Random().nextInt(90)+10;
		return userid.substring(userid.length()-2)+sb+time+ran;
	}
	
}
