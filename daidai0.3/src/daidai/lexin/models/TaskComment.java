package daidai.lexin.models;

import java.sql.Timestamp;

public class TaskComment {
	private String task_comment_id;
	private String task_comment_content;
	private Timestamp task_comment_date;
	private Integer task_comment_good;
	private String user_id;
	private String task_id;
	public TaskComment(String task_comment_id, String task_comment_content, Timestamp task_comment_date,
			Integer task_comment_good, String user_id, String task_id) {
		super();
		this.task_comment_id = task_comment_id;
		this.task_comment_content = task_comment_content;
		this.task_comment_date = task_comment_date;
		this.task_comment_good = task_comment_good;
		this.user_id = user_id;
		this.task_id = task_id;
	}
	public String getTask_comment_id() {
		return task_comment_id;
	}
	public void setTask_comment_id(String task_comment_id) {
		this.task_comment_id = task_comment_id;
	}
	public String getTask_comment_content() {
		return task_comment_content;
	}
	public void setTask_comment_content(String task_comment_content) {
		this.task_comment_content = task_comment_content;
	}
	public Timestamp getTask_comment_date() {
		return task_comment_date;
	}
	public void setTask_comment_date(Timestamp task_comment_date) {
		this.task_comment_date = task_comment_date;
	}
	public Integer getTask_comment_good() {
		return task_comment_good;
	}
	public void setTask_comment_good(Integer task_comment_good) {
		this.task_comment_good = task_comment_good;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	@Override
	public String toString() {
		return "任务评论 [ID=" + task_comment_id + ", 内容=" + task_comment_content
				+ ", 日期=" + task_comment_date + ", 赞=" + task_comment_good + ", 用户ID="
				+ user_id + ", 任务ID=" + task_id + "]";
	}
	
	
}
