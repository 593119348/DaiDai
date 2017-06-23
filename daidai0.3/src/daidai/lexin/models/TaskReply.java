package daidai.lexin.models;

import java.sql.Timestamp;

public class TaskReply {
	private String task_reply_id;
	private String task_reply_content;
	private Timestamp task_reply_date;
	private String task_comment_id;
	public TaskReply(String task_reply_id, String task_reply_content, Timestamp task_reply_date, String task_comment_id) {
		super();
		this.task_reply_id = task_reply_id;
		this.task_reply_content = task_reply_content;
		this.task_reply_date = task_reply_date;
		this.task_comment_id = task_comment_id;
	}
	public String getTask_reply_id() {
		return task_reply_id;
	}
	public void setTask_reply_id(String task_reply_id) {
		this.task_reply_id = task_reply_id;
	}
	public String getTask_reply_content() {
		return task_reply_content;
	}
	public void setTask_reply_content(String task_reply_content) {
		this.task_reply_content = task_reply_content;
	}
	public Timestamp getTask_reply_date() {
		return task_reply_date;
	}
	public void setTask_reply_date(Timestamp task_reply_date) {
		this.task_reply_date = task_reply_date;
	}
	public String getTask_comment_id() {
		return task_comment_id;
	}
	public void setTask_comment_id(String task_comment_id) {
		this.task_comment_id = task_comment_id;
	}
	@Override
	public String toString() {
		return "任务回复 [ID=" + task_reply_id + ", 内容=" + task_reply_content
				+ ", 日期=" + task_reply_date + ", 评论ID=" + task_comment_id + "]";
	}
	
	
}
