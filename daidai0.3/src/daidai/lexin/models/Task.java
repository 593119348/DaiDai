package daidai.lexin.models;

import java.sql.Timestamp;

public class Task {
	private String task_id;
	private Integer task_mod;
	private String task_mes;
	private Integer task_value;
	private Timestamp task_term;
	private Integer task_countdown;
	private Timestamp task_publishdate;
	private Timestamp task_finishdate;
	private String task_photo;
	private String task_address;
	private String user_id;
	public Task(String task_id, Integer task_mod, String task_mes, Integer task_value, Timestamp task_term,
			Integer task_countdown, Timestamp task_publishdate, Timestamp task_finishdate, String task_photo, String task_address,
			String user_id) {
		super();
		this.task_id = task_id;
		this.task_mod = task_mod;
		this.task_mes = task_mes;
		this.task_value = task_value;
		this.task_term = task_term;
		this.task_countdown = task_countdown;
		this.task_publishdate = task_publishdate;
		this.task_finishdate = task_finishdate;
		this.task_photo = task_photo;
		this.task_address = task_address;
		this.user_id = user_id;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public Integer getTask_mod() {
		return task_mod;
	}
	public void setTask_mod(Integer task_mod) {
		this.task_mod = task_mod;
	}
	public String getTask_mes() {
		return task_mes;
	}
	public void setTask_mes(String task_mes) {
		this.task_mes = task_mes;
	}
	public Integer getTask_value() {
		return task_value;
	}
	public void setTask_value(Integer task_value) {
		this.task_value = task_value;
	}
	public Timestamp getTask_term() {
		return task_term;
	}
	public void setTask_term(Timestamp task_term) {
		this.task_term = task_term;
	}
	public Integer getTask_countdown() {
		return task_countdown;
	}
	public void setTask_countdown(Integer task_countdown) {
		this.task_countdown = task_countdown;
	}
	public Timestamp getTask_publishdate() {
		return task_publishdate;
	}
	public void setTask_publishdate(Timestamp task_publishdate) {
		this.task_publishdate = task_publishdate;
	}
	public Timestamp getTask_finishdate() {
		return task_finishdate;
	}
	public void setTask_finishdate(Timestamp task_finishdate) {
		this.task_finishdate = task_finishdate;
	}
	public String getTask_photo() {
		return task_photo;
	}
	public void setTask_photo(String task_photo) {
		this.task_photo = task_photo;
	}
	public String getTask_address() {
		return task_address;
	}
	public void setTask_address(String task_address) {
		this.task_address = task_address;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "任务 [ID=" + task_id + ", 模式=" + task_mod + ", 信息=" + task_mes + ", 悬赏="
				+ task_value + ", 期限=" + task_term + ", 倒计时=" + task_countdown + ", 发布日期="
				+ task_publishdate + ", 完成日期=" + task_finishdate + ", 图片=" + task_photo
				+ ", 发布位置=" + task_address + ", 用户ID=" + user_id + "]";
	}
	
	
}
