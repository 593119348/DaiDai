package daidai.lexin.models;

public class UserDInformation {
	private String user_dinformation_education;
	private String user_dinformation_school;
	private String user_dinformation_schooltime;
	private String user_dinformation_job;
	private String user_dinformation_company;
	private String user_dinformation_jobtime;
	private String user_id;
	public UserDInformation(String user_id,String user_dinformation_education,
			String user_dinformation_school, String user_dinformation_schooltime, String user_dinformation_job,
			String user_dinformation_company, String user_dinformation_jobtime) {
		super();
		this.user_dinformation_education = user_dinformation_education;
		this.user_dinformation_school = user_dinformation_school;
		this.user_dinformation_schooltime = user_dinformation_schooltime;
		this.user_dinformation_job = user_dinformation_job;
		this.user_dinformation_company = user_dinformation_company;
		this.user_dinformation_jobtime = user_dinformation_jobtime;
		this.user_id = user_id;
	}
	public String getUser_dinformation_education() {
		return user_dinformation_education;
	}
	public void setUser_dinformation_education(String user_dinformation_education) {
		this.user_dinformation_education = user_dinformation_education;
	}
	public String getUser_dinformation_school() {
		return user_dinformation_school;
	}
	public void setUser_dinformation_school(String user_dinformation_school) {
		this.user_dinformation_school = user_dinformation_school;
	}
	public String getUser_dinformation_schooltime() {
		return user_dinformation_schooltime;
	}
	public void setUser_dinformation_schooltime(String user_dinformation_schooltime) {
		this.user_dinformation_schooltime = user_dinformation_schooltime;
	}
	public String getUser_dinformation_job() {
		return user_dinformation_job;
	}
	public void setUser_dinformation_job(String user_dinformation_job) {
		this.user_dinformation_job = user_dinformation_job;
	}
	public String getUser_dinformation_company() {
		return user_dinformation_company;
	}
	public void setUser_dinformation_company(String user_dinformation_company) {
		this.user_dinformation_company = user_dinformation_company;
	}
	public String getUser_dinformation_jobtime() {
		return user_dinformation_jobtime;
	}
	public void setUser_dinformation_jobtime(String user_dinformation_jobtime) {
		this.user_dinformation_jobtime = user_dinformation_jobtime;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "用户详细信息 [教育="
				+ user_dinformation_education + ", 学校=" + user_dinformation_school
				+ ", 入学时间=" + user_dinformation_schooltime + ", 职业="
				+ user_dinformation_job + ", 公司=" + user_dinformation_company
				+ ", 入职时间=" + user_dinformation_jobtime + ", 用户ID=" + user_id + "]";
	}
	
	
}
