package daidai.lexin.models;


public class User {
	private String user_id;
	private String user_phone;
	private String user_password;
	private int isblackbox,iswhitebox;
	
	public User(String userid, String phoneNumber, String password,Integer isblackbox,Integer iswhitebox) {
		super();
		this.user_id = userid;
		this.user_phone = phoneNumber;
		this.user_password = password;
		this.isblackbox = isblackbox;
		this.iswhitebox = iswhitebox;
	}
	public String getUserid() {
		return user_id;
	}
	public void setUserid(String userid) {
		this.user_id = userid;
	}
	public String getPhoneNumber() {
		return user_phone;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.user_phone = phoneNumber;
	}
	public String getPassword() {
		return user_password;
	}
	public void setPassword(String password) {
		this.user_password = password;
	}
	public int getIsblackbox() {
		return isblackbox;
	}
	public void setIsblackbox(int isblackbox) {
		this.isblackbox = isblackbox;
	}
	public int getIswhitebox() {
		return iswhitebox;
	}
	public void setIswhitebox(int iswhitebox) {
		this.iswhitebox = iswhitebox;
	}
	
	@Override
	public String toString() {
		return "用户 [ID=" + user_id + ", 手机号=" + user_phone
				+ ", 密码=" + user_password +",黑名单="+(isblackbox==0?"no":"yes") +",管理员="+(iswhitebox==0?"no":"yes")+ "]";
	}
	
}
