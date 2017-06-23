package daidai.lexin.models;

import java.sql.Timestamp;

public class UserBInformation {
	private String user_binformation_photo;
	private String user_binformation_sex;
	private String user_binformation_name;
	private String user_binformation_birth;
	private String user_binformation_address;
	private String user_binformation_introduction;
	private Timestamp user_binformation_register;
	private String user_id;
	public UserBInformation(String user_id,String user_binformation_photo, String user_binformation_sex,
			String user_binformation_name, String user_binformation_birth, String user_binformation_address,
			String user_binformation_introduction, Timestamp user_binformation_register) {
		super();
		this.user_binformation_photo = user_binformation_photo;
		this.user_binformation_sex = user_binformation_sex;
		this.user_binformation_name = user_binformation_name;
		this.user_binformation_birth = user_binformation_birth;
		this.user_binformation_address = user_binformation_address;
		this.user_binformation_introduction = user_binformation_introduction;
		this.user_binformation_register = user_binformation_register;
		this.user_id = user_id;
	}
	public String getUser_binformation_photo() {
		return user_binformation_photo;
	}
	public void setUser_binformation_photo(String user_binformation_photo) {
		this.user_binformation_photo = user_binformation_photo;
	}
	public String getUser_binformation_sex() {
		return user_binformation_sex;
	}
	public void setUser_binformation_sex(String user_binformation_sex) {
		this.user_binformation_sex = user_binformation_sex;
	}
	public String getUser_binformation_name() {
		return user_binformation_name;
	}
	public void setUser_binformation_name(String user_binformation_name) {
		this.user_binformation_name = user_binformation_name;
	}
	public String getUser_binformation_birth() {
		return user_binformation_birth;
	}
	public void setUser_binformation_birth(String user_binformation_birth) {
		this.user_binformation_birth = user_binformation_birth;
	}
	public String getUser_binformation_address() {
		return user_binformation_address;
	}
	public void setUser_binformation_address(String user_binformation_address) {
		this.user_binformation_address = user_binformation_address;
	}
	public String getUser_binformation_introduction() {
		return user_binformation_introduction;
	}
	public void setUser_binformation_introduction(String user_binformation_introduction) {
		this.user_binformation_introduction = user_binformation_introduction;
	}
	public Timestamp getUser_binformation_register() {
		return user_binformation_register;
	}
	public void setUser_binformation_register(Timestamp user_binformation_register) {
		this.user_binformation_register = user_binformation_register;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "用户基本信息 [头像="
				+ user_binformation_photo + ", 性别=" + user_binformation_sex
				+ ", 姓名=" + user_binformation_name + ", 出生年月="
				+ user_binformation_birth + ", 地址=" + user_binformation_address
				+ ", 简介=" + user_binformation_introduction + ", 注册日期="
				+ user_binformation_register + ", 用户ID=" + user_id + "]";
	}
	
	
}
